/*
 * Cartevaloise 
 *
 * Copyright (C) 2004 Conseil Général du Val d'Oise. All Rights
 * Reserved.
 *
 * Developed by René le Clercq. 
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 */
package fr.cg95.cvq.bo.reporting;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import org.apache.struts.util.RequestUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleInsets;

import fr.cg95.cvq.bo.dispatcher.StartupServlet;
import fr.cg95.cvq.bo.record.ReportRecord;
import fr.cg95.cvq.bo.tag.BaseTag;

/**
 */
public class ReportChartTag extends BaseTag {

	private static final long serialVersionUID = -1817320928837521285L;

	private static final org.apache.log4j.Category logger =
		org.apache.log4j.Category.getInstance(ReportChartTag.class);

	private String type = null;

	public int doEndTag() {
		try {
			JspWriter out = pageContext.getOut();

			ArrayList results =
				(ArrayList) RequestUtils.lookup(pageContext, name, property, getScope());

			if (results != null) {
				if (results.size() == 0) {
					out.println(
						"<td class=\"casecontenu1\" colspan=\"8\">Aucun enregistrement trouvé</td>");
				} else if (styleClass.equals("pie")) {
					out.println(displayPieChart(results, 400, 250));

				} else if (styleClass.equals("bar")) {
					out.println(displayBarChart(results, 400, 250));
				}
			}
		} catch (Exception ignored) {
			ignored.getMessage();
		}
		return EVAL_PAGE;
	}

	public String displayPieChart(ArrayList results, int width, int height) {

		String pieChart = "";
		// create a chart
		final DefaultPieDataset data = new DefaultPieDataset();
		PiePlot plot = new PiePlot();
		for (int i = 0; i < results.size(); i++) {
			ReportRecord record = (ReportRecord)results.get(i);
			data.setValue(record.getLabel(), Double.parseDouble(record.getNbdemands()));
			if (record.getColor() != null)
				plot.setSectionPaint(i, record.getColor());
		}
		plot.setDataset(data);
		
		Color backcolor = new Color(0xf6f6f6);

		plot.setLabelGenerator(new StandardPieSectionLabelGenerator());
		plot.setInsets(new RectangleInsets(0, 5, 5, 5));
		plot.setBackgroundPaint(backcolor);

		JFreeChart chart = new JFreeChart(null, JFreeChart.DEFAULT_TITLE_FONT, plot, false);

		chart.setBackgroundPaint(backcolor);
		chart.setBorderVisible(false);

		// save it to an image
		final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());

		try {
			File file = StartupServlet.getTempContextFile(pageContext.getSession(), "piechart");
			ChartUtilities.saveChartAsPNG(file, chart, width, height, info);

			// write an HTML page incorporating the image with an image map
			pieChart =
				"<img src=\""
					+ StartupServlet.getFileContextName((HttpServletRequest)pageContext.getRequest(), file)
					+ "\" width=\""
					+ width
					+ "\" height=\""
					+ height
					+ "\" border=\"0\" />";
					
		} catch (IOException ioe) {
			logger.error("displayPieChart", ioe);
		}
		return pieChart;
	}

	public String displayBarChart(ArrayList results, int width, int height) {

		String barChart = "";

		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		final String series1 = "demandes reçus";
		final String series2 = "demandes validées";

		for (int i = 0; i < results.size(); i++) {
			ReportRecord record = (ReportRecord)results.get(i);
			dataset.addValue(Double.parseDouble(record.getNbdemands()), series1, record.getLabel());
			dataset.addValue(Double.parseDouble(record.getNbvalidated()), "demandes "+ record.getTitle(), record.getLabel());
		}

		Color backcolor = new Color(0xf6f6f6);

		final JFreeChart chart = ChartFactory.createBarChart(
			null,       // chart title
			null,               // domain axis label
			null,                  // range axis label
			dataset,                  // data
			PlotOrientation.VERTICAL, // orientation
			true,                    // include legend
			false,                     // tooltips?
			false                     // URLs?
		);

		// set the background color for the chart...
		chart.setBackgroundPaint(backcolor);

		// get a reference to the plot for further customisation...
		final CategoryPlot plot = chart.getCategoryPlot();
		plot.setBackgroundPaint(backcolor);
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinePaint(Color.white);
        
		// set the range axis to display integers only...
		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		rangeAxis.setUpperMargin(0.15);
        
		// disable bar outlines...
		final CategoryItemRenderer renderer = plot.getRenderer();
		renderer.setSeriesItemLabelsVisible(0, Boolean.TRUE);
		renderer.setSeriesItemLabelsVisible(1, Boolean.TRUE);
        
		final CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);

		// save it to an image
		final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());

		try {
			File file = StartupServlet.getTempContextFile(pageContext.getSession(), "piechart");
			ChartUtilities.saveChartAsPNG(file, chart, width, height, info);

			// write an HTML page incorporating the image with an image map
			barChart =
				"<img src=\""
					+ StartupServlet.getFileContextName((HttpServletRequest)pageContext.getRequest(), file)
					+ "\" width=\""
					+ width
					+ "\" height=\""
					+ height
					+ "\" border=\"0\" />";
					
		} catch (IOException ioe) {
			logger.error("displayBarChart", ioe);
		}
		return barChart;
	}


	public String getType() {
		return type;
	}

	public void setType(String string) {
		type = string;
	}

}
