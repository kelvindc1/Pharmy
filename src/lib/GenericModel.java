/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import interfaces.InterfaceModel;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Cristiano Peiter <cristiano.peiter@universo.univates.br>
 * @param <T>
 */
public abstract class GenericModel<T extends Entity> implements InterfaceModel<T> 
{

    private final Connection connection;
    private final Class<T> entityClass;
    private final String table;

    public GenericModel(Class<T> e) 
    {
        connection = ConexaoBD.getInstance().getConnection();
        entityClass = e;
        table = e.getSimpleName().toLowerCase();
    }

    @Override
    public void store(T entity) throws Exception 
    {
        Field[] fields = entity.getClass().getDeclaredFields();
        String[] columns = new String[fields.length];
        Object[] values = new Object[fields.length];
        
        for (int i = 0; i < fields.length; i++) 
        {
            Field field = fields[i];
            if (field.getName().equals("id")) 
            {
                continue;
            }
            field.setAccessible(true);
            values[i] = field.get(entity);
            columns[i] = field.getName();
        }
        
        String sql;
        if (entity.isNew()) 
        {
            String params = null;
            String columnNames = null;
            for (String column : columns) 
            {
                if (columnNames == null) 
                {
                    columnNames = column;
                } 
                else 
                {
                    columnNames += ", " + column;
                }
            }
            
            for (String column : columns) 
            {
                if (params == null) 
                {
                    params = "?";
                } 
                else 
                {
                    params += ", ?";
                }
            }
            sql = "INSERT INTO " + table + " (" + columnNames + ") VALUES (" + params + ")";
        } 
        else 
        {
            String columnNames = null;
            for (String column : columns) 
            {
                if (columnNames == null) 
                {
                    columnNames = column + "=?";
                } 
                else 
                {
                    columnNames += ", " + column + "=?";
                }
            }
            sql = "UPDATE " + table + " SET " + columnNames + " WHERE id =  ?";
        }
        
        PreparedStatement ps = connection.prepareStatement(sql);
        
        for (int i = 1; i <= values.length; i++) 
        {
            if( values[i - 1] != null && values[i - 1].getClass() == Timestamp.class )
            {
                ps.setTimestamp(i, (Timestamp) values[i - 1]);
            }
            else if( values[i - 1] != null && values[i - 1].getClass() == Date.class )
            {
                java.util.Date dt_util = (java.util.Date) values[i - 1];
                java.sql.Date dt_sql = new java.sql.Date(dt_util.getTime());
                ps.setDate(i, dt_sql);
            }
            else
            {
                Object value = values[i - 1];
                ps.setObject(i, value);
            }
        }
        if (!entity.isNew()) 
        {
            ps.setObject(values.length + 1, entity.getId());
        }
        System.out.println(ps);
        ps.executeUpdate();
    }

    @Override
    public void delete(int id) throws Exception 
    {
        String sql = "DELETE FROM " + table + " WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public T getObject(int id) throws Exception 
    {
        String sql = "SELECT * FROM " + table + " WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet resultado = ps.executeQuery();
        
        if (resultado.next()) 
        {
            T entity = statementToEntity(resultado);
            return entity;
        }
        return null;
    }

    @Override
    public List<T> getObjects() throws Exception 
    {
        String sql = "SELECT * FROM " + table;
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultado = ps.executeQuery();
        List<T> entities = new ArrayList();
        
        while (resultado.next()) 
        {
            T entity = statementToEntity(resultado);
            entities.add(entity);
        }
        return entities;
    }

    @Override
    public List<T> getObjects(Order order) throws Exception 
    {
        String sql = "SELECT * FROM " + table + " " + order.getStatement();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultado = ps.executeQuery();
        List<T> entities = new ArrayList();
        
        while (resultado.next()) 
        {
            T entity = statementToEntity(resultado);
            entities.add(entity);
        }
        return entities;
    }

    @Override
    public List<T> getObjects(Filter... filters) throws Exception 
    {
        String constraint = null;
        for (Filter filter : filters) 
        {
            if (constraint == null) 
            {
                constraint = filter.getStatement();
            } 
            else 
            {
                constraint += " AND " + filter.getStatement();
            }
        }
        
        String sql = "SELECT * FROM " + table + " WHERE " + constraint;
        PreparedStatement ps = connection.prepareStatement(sql);
        int aux = 1;
        for (int i = 1; i <= filters.length; i++) 
        {
            Filter filter = filters[i - 1];
            if (filter.getOperator() == Operator.ILIKE) 
            {
                ps.setObject(aux, "%" + filter.getValue() + "%");
            } 
            else 
            {
                ps.setObject(aux, filter.getValue());
            }
            aux++;
            if (filter.getOperator() == Operator.BET) 
            {
                ps.setObject(aux, filter.getValue2());
                aux++;
            }
        }
        ResultSet resultado = ps.executeQuery();
        List<T> entities = new ArrayList();
        while (resultado.next()) 
        {
            T entity = statementToEntity(resultado);
            entities.add(entity);
        }
        return entities;
    }

    @Override
    public List<T> getObjects(Order order, Filter... filters) throws Exception 
    {
        String constraint = null;
        for (Filter filter : filters) 
        {
            if (constraint == null) 
            {
                constraint = filter.getStatement();
            } else 
            {
                constraint += " AND " + filter.getStatement();
            }
        }
        String sql = "SELECT * FROM " + table + " WHERE " + constraint + " " + order.getStatement();
        PreparedStatement ps = connection.prepareStatement(sql);
        int aux = 1;
        for (int i = 1; i <= filters.length; i++) 
        {
            Filter filter = filters[i - 1];
            if (filter.getOperator() == Operator.ILIKE) 
            {
                ps.setObject(aux, "%" + filter.getValue() + "%");
            } 
            else 
            {
                ps.setObject(aux, filter.getValue());
            }
            aux++;
            if (filter.getOperator() == Operator.BET) 
            {
                ps.setObject(aux, filter.getValue2());
                aux++;
            }
        }
        ResultSet resultado = ps.executeQuery();
        List<T> entities = new ArrayList();
        while (resultado.next()) 
        {
            T entity = statementToEntity(resultado);
            entities.add(entity);
        }
        return entities;
    }
    
    public List<T> getObjects(Order order, ArrayList<Filter> filters) throws Exception 
    {
        String constraint = null;
        for (Filter filter : filters) 
        {
            if (constraint == null) 
            {
                constraint = filter.getStatement();
            } else 
            {
                constraint += " AND " + filter.getStatement();
            }
        }
        String sql = "SELECT * FROM " + table + " WHERE " + constraint + " " + order.getStatement();
        System.out.println(sql);
        PreparedStatement ps = connection.prepareStatement(sql);
        int aux = 1;
        for (int i = 1; i <= filters.size(); i++) 
        {
            Filter filter = filters.get(i - 1);
            if (filter.getOperator() == Operator.ILIKE) 
            {
                ps.setObject(aux, "%" + filter.getValue() + "%");
            } 
            else 
            {
                ps.setObject(aux, filter.getValue());
            }
            aux++;
            if (filter.getOperator() == Operator.BET) 
            {
                ps.setObject(aux, filter.getValue2());
                aux++;
            }
        }
        System.out.println(ps.toString());
        ResultSet resultado = ps.executeQuery();
        List<T> entities = new ArrayList();
        while (resultado.next()) 
        {
            T entity = statementToEntity(resultado);
            entities.add(entity);
        }
        return entities;
    }

    public List<T> getObjectsSQL(String sql) throws SQLException, InstantiationException, IllegalAccessException 
    {
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultado = ps.executeQuery();
        List<T> entities = new ArrayList();
        while (resultado.next()) 
        {
            T entity = statementToEntity(resultado);
            entities.add(entity);
        }
        return entities;
    }

    private T statementToEntity(ResultSet resultado) throws InstantiationException, IllegalAccessException, SQLException 
    {
        T entity = entityClass.newInstance();
        entity.setId(resultado.getInt("id"));
        Field[] fields = entity.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) 
        {
            Field field = fields[i];
            if (field.getName().equals("id")) 
            {
                continue;
            }
            field.setAccessible(true);
            String columnLabel = field.getName();
            Object value = resultado.getObject(columnLabel);
            if (value != null) 
            {
                field.set(entity, value);
            }
        }
        return entity;
    }

}
