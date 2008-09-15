

class GoogleChartBuilderTestCase extends GroovyTestCase {

	def baseUrl = 'http://chart.apis.google.com/chart?'
			
	GoogleChartBuilder chart
	void setUp() {
		chart = new GoogleChartBuilder()
	}

    void test_test_to_avoid_error() {
        assertTrue(true)
    }
}
