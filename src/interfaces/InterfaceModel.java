/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import lib.Entity;
import java.util.List;
import lib.Filter;
import lib.Order;

/**
 *
 * @author Cris
 * @param <T>
 */
public interface InterfaceModel<T extends Entity> 
{
    void delete(int id) throws Exception;

    T getObject(int id) throws Exception;

    List<T> getObjects() throws Exception;
    
    List<T> getObjects(Order order) throws Exception;

    List<T> getObjects(Filter... filters) throws Exception;
    
    List<T> getObjects(Order order, Filter... filters) throws Exception;

    void store(T entity) throws Exception;
}
