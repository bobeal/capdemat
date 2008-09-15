class ShapeMarkersTest extends GoogleChartBuilderTestCase {
    def result
    def testBaseUrl = "${baseUrl}cht=lc&chm="

    void test_base_marker() {
        result = chart.lineChart{
            markers()
        }

        assertEquals (testBaseUrl, result.toString())
    }


    void test_arrow() {
        createMarkerWithType('arrow')
        assertMarkerTypeHas('a')
    }

    void test_cross() {
        createMarkerWithType ('cross')
        assertMarkerTypeHas ('c')
    }

    void test_diamond() {
        createMarkerWithType('diamond')
        assertMarkerTypeHas('d')
    }

    void test_circle() {
        createMarkerWithType ('circle')
        assertMarkerTypeHas ('o')
    }

    void test_square() {
        createMarkerWithType ('square')
        assertMarkerTypeHas ('s')
    }

    void test_vertical_line_form_x_axis_to_data_point() {
        createMarkerWithType ('vPoint')
        assertMarkerTypeHas ('v')
    }

    void test_vertical_line_from_x_axis_to_top() {
        createMarkerWithType ('vTop')
        assertMarkerTypeHas ('V')
    }

    void test_horizontal_line() {
        createMarkerWithType ('horizontal')
        assertMarkerTypeHas ('h')
    }

    void test_x_shape() {
        createMarkerWithType ('xShape')
        assertMarkerTypeHas('x')
    }

    def assertMarkerTypeHas(type){
        assertEquals ("${testBaseUrl}${type},FF0000,0,1.0,20", result.toString())
    }

    def createMarkerWithType(markerType){
        result = chart.lineChart{
            markers{
                shape(type:markerType, color:'FF0000', set:0, point:1.0, size:20 )
            }
        }
    }



    void test_multiple_shape_markers() {
        result = chart.lineChart {
            markers{
                shape(type:'arrow', color:'FF0000', set:0, point:1.0, size:20)
                shape(type:'square', color:'FFFFFF', set:2, point:2.5, size:10)
            }
        }

        assertEquals ("${testBaseUrl}a,FF0000,0,1.0,20|s,FFFFFF,2,2.5,10", result.toString())
    }

}