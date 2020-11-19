/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import org.jfree.chart.ChartFactory;                                        // captura todos os dados abaixo
import org.jfree.chart.ChartUtils;                                          // utilitários dos gráficos (números ao redor)
import org.jfree.chart.JFreeChart;                                          // cria o gráfico
import org.jfree.chart.plot.PlotOrientation;                                // orientação das linhas
import org.jfree.data.category.DefaultCategoryDataset;                      // colocar dados no gráfico

import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Win10
 */
public class Grafico {

    private int a = 0;
    private String b = "Maximo";
    private String c = "Hora ";

    public void getGrafico(/*String[][] aux*/) {
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
        JFreeChart criarGrafico = ChartFactory.createAreaChart("Custos", "Dia", "Valor", dataset, PlotOrientation.VERTICAL, true, true, false);

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
