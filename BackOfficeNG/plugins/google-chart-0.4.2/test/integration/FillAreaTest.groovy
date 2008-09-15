class FillAreaTest extends GoogleChartBuilderTestCase {
    def result
    def testBaseUrl = "${baseUrl}cht=lc&chm="

    void test_base_fill_area() {
        result = chart.lineChart{
            markers()
        }

        assertEquals (testBaseUrl, result.toString())
    }

    void test_basic_fill_implicitly_not_a_single_dataset() {
        result = chart.lineChart{
            markers{
                fill(color:'ff0000', startLine:0, endLine:1)
            }
        }

        assertEquals ("${testBaseUrl}b,ff0000,0,1,0|", result.toString())
    }

     void test_basic_fill_explcitly_not_a_single_dataset() {
        result = chart.lineChart{
            markers{
                fill(single:false, color:'ff0000', startLine:0, endLine:1)
            }
        }

        assertEquals ("${testBaseUrl}b,ff0000,0,1,0|", result.toString())
    }

    void test_single_data_set() {
        result = chart.lineChart {
            markers{
                fill(single:true, color:'ff0000')
            }
        }
        assertEquals ("${testBaseUrl}B,ff0000,0,0,0|", result.toString())
    }

    void test_multiple_dataset_fill() {
        result = chart.lineChart {
            markers{
                fill(color:'ff1234', startLine:0, endLine:1)
                fill(single:false, color:'FFFFFF', startLine:1, endLine:2)
            }
        }

        assertEquals ("${testBaseUrl}b,ff1234,0,1,0|b,FFFFFF,1,2,0|", result.toString())
    }
}