class RangeMarkerTest extends GoogleChartBuilderTestCase {
    def result
    def testBaseUrl = "${baseUrl}cht=lc&chm="

    void test_base_range_marker() {
        result = chart.lineChart {
            markers()
        }

        assertEquals (testBaseUrl, result.toString())
    }

    void test_horzontal_range_marker() {
        result = chart.lineChart {
            markers{
                rangeMarker(type:'horizontal', color:'FF0000', start:0.75, end:0.25)
            }
        }

        assertEquals ("${testBaseUrl}r,FF0000,0,0.75,0.25", result.toString())
    }

    void test_vertical_range_marker() {
        result = chart.lineChart {
            markers{
                rangeMarker(type:'vertical', color:'FF0000', start:0.75, end:0.25)
            }
        }

        assertEquals ("${testBaseUrl}R,FF0000,0,0.75,0.25", result.toString())
    }

    void test_multiple_range_markers() {
        result = chart.lineChart {
            markers{
                rangeMarker(type:'Hor', color:'ff0000')
                rangeMarker(type:'V', color:'ff0000', start:0.00, end:0.11)
            }
        }
        assertEquals ("${testBaseUrl}r,ff0000,0,0.00,1.00|R,ff0000,0,0.00,0.11",
                result.toString())
    }
}