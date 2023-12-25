package com.Analysis;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author seabirds
 */
public class AccuracyGraph extends ApplicationFrame {

    public static double F1 = 0, F2 = 0, F3 = 0, F4 = 0, F5 = 0;

    public AccuracyGraph(final String title) {

        super(title);

        final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 470));
        setContentPane(chartPanel);

    }

    private CategoryDataset createDataset() {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();;
        try {
            final String bar1 = "Accuracy";
            final String bar2 = "False Ratio";

            final String series1 = "Tumor Detection Accuracy";
            
            // TODO add your handling code here:
            int strgpos=17, pos=3, total=20;


//            Dbconn db=new Dbconn();
//            Connection con=db.conn();
//            Statement st=con.createStatement();
//            ResultSet rs=st.executeQuery("select count(*) from resulttable");
//            if(rs.next())
//            {
//                total=rs.getInt(1);
//            }
//            Statement st1=con.createStatement();
//            ResultSet rs1=st1.executeQuery("select count(*) from resulttable where result='strong_positive'");
//            if(rs1.next())
//            {
//                strgpos=rs1.getInt(1);
//            }
//            Statement st2=con.createStatement();
//            ResultSet rs2=st2.executeQuery("select count(*) from resulttable where result='positive'");
//            if(rs2.next())
//            {
//                pos=rs2.getInt(1);
//            }
//            Statement st5=con.createStatement();
//            ResultSet rs5=st5.executeQuery("select count(*) from resulttable where result='weak_positive'");
//            if(rs5.next())
//            {
//                weakpos=rs5.getInt(1);
//            }
//            Statement st3=con.createStatement();
//            ResultSet rs3=st3.executeQuery("select count(*) from resulttable where result='strong_negative'");
//            if(rs3.next())
//            {
//                strgneg=rs3.getInt(1);
//            }
//            Statement st4=con.createStatement();
//            ResultSet rs4=st4.executeQuery("select count(*) from resulttable where result='positive'");
//            if(rs4.next())
//            {
//                neg=rs4.getInt(1);
//            }
//            Statement st6=con.createStatement();
//            ResultSet rs6=st6.executeQuery("select count(*) from resulttable where result='weak_negative'");
//            if(rs6.next())
//            {
//                weakneg=rs6.getInt(1);
//            }
            
            dataset.addValue(((double)strgpos/total)*100, bar1, series1);
            dataset.addValue(((double)pos/total)*100, bar2, series1);
           


        } catch (Exception ex) {
            Logger.getLogger(AccuracyGraph.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataset;

    }

    private JFreeChart createChart(final CategoryDataset dataset) {

        final JFreeChart chart = ChartFactory.createBarChart(
                "Analysis",
                "Tumor Detection Accuracy",
                "Result in %",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        chart.setBackgroundPaint(Color.white);

        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        //final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        //rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        // disable bar outlines...
        final BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);

        final GradientPaint gp0 = new GradientPaint(
                0.0f, 0.0f, Color.green,
                0.0f, 0.0f, Color.green
        );
        final GradientPaint gp1 = new GradientPaint(
                0.0f, 0.0f, Color.red,
                0.0f, 0.0f, Color.red
        );
        final GradientPaint gp2 = new GradientPaint(
                0.0f, 0.0f, Color.green,
                0.0f, 0.0f, Color.green
        );

        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);
        renderer.setSeriesPaint(2, gp2);
        // renderer.setSeriesPaint(3, gp3);

        final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
                CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );

        return chart;

    }

}
