package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import logic.Administration;

public class Graphs extends JDialog {
    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();

    public static void main(String[] args) {
        try {
            Graphs dialog = new Graphs();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Graphs() {
        setTitle("Gráficos de Inventario y Ganancias");
        setBounds(100, 100, 800, 600);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);

        // Crea el JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Panel para el gráfico de pastel de inventario
        JPanel pieChartPanel = new JPanel(new BorderLayout());
        String HardDisk = "Disco Duro";
        String MicroProcessor = "Microprocesador";
        String MotherBoard = "Tarjeta Madre";
        String RAM = "RAM";
        
        int hdCount = Administration.getAdministration().getHowManyHDs();
        int mpCount = Administration.getAdministration().getHowManyMPs();
        int mbCount = Administration.getAdministration().getHowManyMBs();
        int ramCount = Administration.getAdministration().getHowManyRAMs();
        
        DefaultPieDataset pieData = new DefaultPieDataset();
        pieData.setValue(HardDisk, hdCount);
        pieData.setValue(MicroProcessor, mpCount);
        pieData.setValue(MotherBoard, mbCount);
        pieData.setValue(RAM, ramCount);

        JFreeChart pieChart = ChartFactory.createPieChart(
            "Inventario",
            pieData,
            true,
            true,
            false
        );

        ChartPanel pieChartChartPanel = new ChartPanel(pieChart);
        pieChartPanel.add(pieChartChartPanel, BorderLayout.CENTER);

        // Panel para el gráfico de línea de ganancias
        JPanel lineChartPanel = new JPanel(new BorderLayout());
        JFreeChart lineChart = createLineChart();
        ChartPanel lineChartChartPanel = new ChartPanel(lineChart);
        lineChartPanel.add(lineChartChartPanel, BorderLayout.CENTER);

        // Agrega los paneles al JTabbedPane
        tabbedPane.addTab("Inventario", pieChartPanel);
        tabbedPane.addTab("Ganancias Mensuales", lineChartPanel);

        // Agrega el JTabbedPane al contentPanel
        contentPanel.add(tabbedPane, BorderLayout.CENTER);
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        // Botones
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        
        JButton okButton = new JButton("OK");
        okButton.setFont(new Font("Verdana", Font.BOLD, 12));
        okButton.setActionCommand("OK");
        okButton.setPreferredSize(new Dimension(85, 30));
        okButton.setBorder(new RoundedBorder(Color.BLACK,1,25));
        okButton.addActionListener(e -> dispose());
         buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);
        
        
        JButton btn_refresh = new JButton("Actualizar gr\u00E1ficos");
        btn_refresh.addActionListener(e -> updateCharts());
        buttonPane.add(btn_refresh);
        btn_refresh.setFont(new Font("Verdana", Font.BOLD, 12));
        buttonPane.add(btn_refresh);
        btn_refresh.setPreferredSize(new Dimension(155, 30));
        btn_refresh.setBorder(new RoundedBorder(Color.BLACK,1,25));
      
    }

    public void updateCharts() {
        // Actualizar el gráfico de pastel
        DefaultPieDataset pieData = new DefaultPieDataset();
        pieData.setValue("Disco Duro", Administration.getAdministration().getHowManyHDs());
        pieData.setValue("Microprocesador", Administration.getAdministration().getHowManyMPs());
        pieData.setValue("Tarjeta Madre", Administration.getAdministration().getHowManyMBs());
        pieData.setValue("RAM", Administration.getAdministration().getHowManyRAMs());

        JFreeChart pieChart = ChartFactory.createPieChart(
            "Inventario",
            pieData,
            true,
            true,
            false
        );

        // Actualizar el panel del gráfico de pastel
        ChartPanel pieChartPanel = (ChartPanel) ((JPanel) ((JTabbedPane) contentPanel.getComponent(0)).getComponentAt(0)).getComponent(0);
        pieChartPanel.setChart(pieChart);

        // Actualizar el gráfico de línea
        DefaultCategoryDataset lineDataset = new DefaultCategoryDataset();
        double[] monthlyProfits = Administration.getAdministration().getMonthlyProfits();
        String[] monthNames = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", 
                               "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        
        for (int i = 0; i < monthlyProfits.length; i++) {
            lineDataset.addValue(monthlyProfits[i], "Ganancias", monthNames[i]);
        }

        JFreeChart lineChart = ChartFactory.createLineChart(
            "Ganancias Mensuales",
            "Meses",
            "Ganancias",
            lineDataset
        );

        // Configurar el formato de los números en el eje Y
        NumberAxis yAxis = (NumberAxis) lineChart.getCategoryPlot().getRangeAxis();
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        yAxis.setNumberFormatOverride(numberFormat);

        // Actualizar el panel del gráfico de línea
        ChartPanel lineChartPanel = (ChartPanel) ((JPanel) ((JTabbedPane) contentPanel.getComponent(0)).getComponentAt(1)).getComponent(0);
        lineChartPanel.setChart(lineChart);
    }


	private JFreeChart createLineChart() {
        double[] monthlyProfits = Administration.getAdministration().getMonthlyProfits(); // Este método devuelve un array de ganancias mensuales

        String[] monthNames = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", 
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < monthlyProfits.length; i++) {
            dataset.addValue(monthlyProfits[i], "Ganancias", monthNames[i]);
        }

        
        JFreeChart lineChart = ChartFactory.createLineChart(
            "Ganancias Mensuales",
            "Meses",
            "Ganancias",
            dataset
        );

        // Obtener el eje Y del gráfico y establecer formato
        NumberAxis yAxis = (NumberAxis) lineChart.getCategoryPlot().getRangeAxis();

        // Configurar el formato de los números en el eje Y
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        yAxis.setNumberFormatOverride(numberFormat);

        return lineChart;
    }
}
