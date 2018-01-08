package esprit.egov.gui;

import esprit.egov.dao.interfaces.IArticlesDao;
import esprit.egov.dao.classes.ArticlesDao;
import esprit.egov.entities.Articles;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jfree.chart.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.*;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.*;

public final class BarChart extends ApplicationFrame {
    public BarChart(final String title) throws IOException {
        super(title);
        final CategoryDataset dataset = createDataset();
        final JFreeChart graphe = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(graphe);
        chartPanel.setPreferredSize(new java.awt.Dimension(400, 400));
        setContentPane(chartPanel);
    }
public CategoryDataset createDataset() throws IOException {
        // 0. Création d'un diagramme.
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
       //Valeurs statiques
            List<Articles> pays = new ArrayList<>();
            List<String> type = new ArrayList<>();
            type.add("post");
            type.add("industrie");
            type.add("journaux");
            type.add("interieur");
            type.add("tunisie");
            type.add("gouvernement");

    IArticlesDao paysDao;

    paysDao=new ArticlesDao();
    pays = paysDao.findAll();
    int c =0,m=0,n=0,t=0,r=0,l=0;
    for(int i = 0 ; i < pays.size(); i++){
        {  
            if (pays.get(i).getType().equals("post"))
                c++;
        }
        dataset.addValue(c,"post","");      
    }
        for(int i = 0 ; i < pays.size(); i++){
        {  
            if (pays.get(i).getType().equals("tunisie"))
                m++;
        }
        dataset.addValue(m,"tunisie","");      
    }
                for(int i = 0 ; i < pays.size(); i++){
        {  
            if (pays.get(i).getType().equals("industrie"))
                n++;
        }
        dataset.addValue(n,"industrie","");      
    }
                        for(int i = 0 ; i < pays.size(); i++){
        {  
            if (pays.get(i).getType().equals("interieur"))
                r++;
        }
        dataset.addValue(r,"interieur","");      
    }
                                for(int i = 0 ; i < pays.size(); i++){
        {  
            if (pays.get(i).getType().equals("gouvernemant"))
                t++;
        }
        dataset.addValue(t,"gouvernement","");      
    }
                                        for(int i = 0 ; i < pays.size(); i++){
        {  
            if (pays.get(i).getType().equals("journaux"))
                l++;
        }
        dataset.addValue(l,"journaux","");      
    }
    
       return dataset;
    }
	public JFreeChart createChart(CategoryDataset dataset) {
        final JFreeChart chart = ChartFactory.createBarChart3D(
                " le taux des actualités pour chaque type ", // chart title
                " ", // domain axis label
                "  Les Types d'actualite", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // orientation
                true, // include legend
                true, // tooltips
                true // urls
                );

 final CategoryPlot plot = chart.getCategoryPlot();
        final CategoryAxis axis = plot.getDomainAxis();
        axis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 2.0));
        final CategoryItemRenderer renderer = plot.getRenderer();
        renderer.setItemLabelsVisible(true); 
        return chart;
    }
    public static void main(final String[] args) throws IOException {
        final BarChart demo = new BarChart("Test de la couverture ");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }
}
