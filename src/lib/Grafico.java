/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import control.Financeiro;
import everest.geral.Data;
import org.jfree.chart.ChartFactory;                                        // captura todos os dados abaixo
import org.jfree.chart.ChartUtils;                                          // utilitários dos gráficos (números ao redor)
import org.jfree.chart.JFreeChart;                                          // cria o gráfico
import org.jfree.chart.plot.PlotOrientation;                                // orientação das linhas
import org.jfree.data.category.DefaultCategoryDataset;                      // colocar dados no gráfico

import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Win10
 */
public class Grafico {

    private int a = 0;
    private String b = "Maximo";
    private String c = "";

    public void getGrafico(ArrayList<Financeiro> fin, String inicio, String fim, String tp) {
        //LANÇAMENTOS
        Data dt_inicio = new Data(inicio);
        Data dt_final = new Data(fim);
        int cont = dt_final.compareTo(dt_inicio);
        System.out.println("cont ->"+cont);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        Financeiro f = null;
        
        
       /*
        while (dt_inicio.equals(dt_final)) {
            dt_final.avancarUmDia();
            cont++;
        }
*/
       
        

        for (int i = 0; i < fin.size(); i++) {
            f = fin.get(i);
            dataset.addValue(f.getValor(),b,Formatting.ajustaDataDMA(f.getDt_inicio())) ;
            System.out.println("VALOR -> "+f.getValor()+"\n"
                    + "DATA -> "+Formatting.ajustaDataDMA(f.getDt_inicio()));
        }
/*
        dataset.addValue(10, b, c + "1");
        dataset.addValue(20, b, c + "2");
        dataset.addValue(30, b, c + "3");
        dataset.addValue(70, b, c + "4");
        dataset.addValue(80, b, c + "5");
        dataset.addValue(90, b, c + "6");
*/
        /*for (int i = 0; aux.length < 10; i++) {
            a = Integer.parseInt(aux[i][0]);
            b = aux[i][1];
            c = aux[i][2];
            dataset.addValue(a, b, c);
        }*/
        //JFreeChart criarGrafico = ChartFactory.createAreaChart("Nome do gráfico","x dp grafico","y do grafico", DefaultCategoryDataset,PlotOrientation.VERTICAL,legenda,legenda,url)
        JFreeChart criarGrafico = ChartFactory.createAreaChart(tp, "Data", "Valor", dataset, PlotOrientation.VERTICAL, true, true, false);

        try {
            System.out.println("Criando Gráfico");
            OutputStream png = new FileOutputStream("Grafico.png");
            ChartUtils.writeChartAsPNG(png, criarGrafico, 500, 400);
            png.close();
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());

        }
        System.out.println("Gráfico finalizado");
    }
    public void getGrafico() {
        
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
 

   
        dataset.addValue(10, b, c + "1");
        dataset.addValue(20, b, c + "2");
        dataset.addValue(30, b, c + "3");
        dataset.addValue(70, b, c + "4");
        dataset.addValue(80, b, c + "5");
        dataset.addValue(90, b, c + "6");

        /*for (int i = 0; aux.length < 10; i++) {
            a = Integer.parseInt(aux[i][0]);
            b = aux[i][1];
            c = aux[i][2];
            dataset.addValue(a, b, c);
        }*/
        //JFreeChart criarGrafico = ChartFactory.createAreaChart("Nome do gráfico","x dp grafico","y do grafico", DefaultCategoryDataset,PlotOrientation.VERTICAL,legenda,legenda,url)
        JFreeChart criarGrafico = ChartFactory.createAreaChart("Custos", "Data", "Valor", dataset, PlotOrientation.VERTICAL, true, true, false);

        try {
            System.out.println("Criando Gráfico");
            OutputStream png = new FileOutputStream("Grafico.png");
            ChartUtils.writeChartAsPNG(png, criarGrafico, 500, 400);
            png.close();
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());

        }
        System.out.println("Gráfico finalizado");
    }
}