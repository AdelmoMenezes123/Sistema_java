package Grupo4;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class GraficoProdutos extends JFrame {

	public GraficoProdutos() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Grafico dos produtos");
		setSize(850,600);
		setLocationRelativeTo(null);
		criarGrafico();
		setVisible(true);
	}
	
	public void criarGrafico() {
		DefaultPieDataset graficoProdutos = new DefaultPieDataset();
		graficoProdutos.setValue("Feijao ", 1);
		graficoProdutos.setValue("Arroz", 2);
		graficoProdutos.setValue("Carne", 2);
		graficoProdutos.setValue("Farinha", 2);
		graficoProdutos.setValue("Macarrao", 1);
		
		JFreeChart grafico = ChartFactory.createPieChart("Graficos de Remedios",graficoProdutos, true,true,false );
		ChartPanel painel = new ChartPanel(grafico);
		add(painel);
	}
}
