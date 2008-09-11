class DataSetColorTest extends GoogleChartBuilderTestCase {

    def result
    def testBaseUrl = "${baseUrl}cht=lc&chco="

    void test_base_custome_color_url() {
        result = chart.lineChart{
            colors()
        }

        assertEquals (testBaseUrl, result.toString())
    }

    void test_one_custom_color() {
        result = chart.lineChart{
            colors{
                color('ff0000')
            }
        }

        assertEquals ("${testBaseUrl}ff0000", result.toString())
    }

    void test_multiple_cusotm_colors() {
        result = chart.lineChart{
            colors{
                color('ff0000')
                color('aa1234')
            }
        }

        assertEquals ("${testBaseUrl}ff0000,aa1234", result.toString())
    }
}