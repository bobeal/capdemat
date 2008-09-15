class LineStyleTest extends GoogleChartBuilderTestCase {

    def  testBase = "${baseUrl}cht=lc&"
    def result

    void test_line_style_base() {
        result = chart.lineChart{
            lineStyle()
        }
        assertEquals ("${testBase}chls", result.toString())
    }

    void test_line_style_thin_and_solid() {
        result = chart.lineChart {
            lineStyle(line1:[1,1,0])
        }

        assertEquals ("${testBase}chls=1,1,0", result.toString())
    }

    void test_two_line_styles() {
        result = chart.lineChart {
            lineStyle(line1:[1,1,0], line2:[3,3,3])
        }

        assertEquals("${testBase}chls=1,1,0|3,3,3", result.toString())
    }
}