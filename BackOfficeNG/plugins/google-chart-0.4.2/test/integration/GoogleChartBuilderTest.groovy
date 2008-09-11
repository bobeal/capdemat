class GoogleChartBuilderTest extends GoogleChartBuilderTestCase {

	void test2DPieChart(){
		def result = chart.pieChart(){}
		assertEquals("${baseUrl}cht=p", result.toString())
	}
	
	
	void test3DPieChart(){
		def result = chart.pie3DChart(){}
		assertEquals("${baseUrl}cht=p3", result.toString())
	}


	void test_line_chart(){
		def result = chart.lineChart(){}
		assertEquals("${baseUrl}cht=lc", result.toString())
	}
	
	void test_line_xy_chart(){
		def result = chart.lineXYChart(){}
		assertEquals("${baseUrl}cht=lxy", result.toString())
	}
 
	void test_horizontal_bar_stacked(){
		def result = chart.barChart(['hori','stacked']){}
		assertEquals("${baseUrl}cht=bhs", result.toString())
	} 
	
	void test_vertical_bar(){
		def result = chart.barChart(['vert','stacked']){ }
		assertEquals("${baseUrl}cht=bvs", result.toString())
	} 
	
	void test_horizontal_bar_grouped(){
		def result = chart.barChart(['horizontal','grouped']){}
		assertEquals("${baseUrl}cht=bhg", result.toString())
	}
	
	void test_vertical_bar_grouped(){
		def result = chart.barChart(['v', 'g']){}
		assertEquals("${baseUrl}cht=bvg", result.toString())
	}
	
	void test_venn(){
		def result = chart.vennDiagram(){}
		assertEquals("${baseUrl}cht=v", result.toString())
	}
	
	void test_scatter(){
		def result = chart.scatterPlot(){}
		assertEquals("${baseUrl}cht=s", result.toString())
	}
		
}
