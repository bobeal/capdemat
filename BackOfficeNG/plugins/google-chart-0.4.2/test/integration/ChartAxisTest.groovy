class ChartAxisTest extends GoogleChartBuilderTestCase {

    def  axisBase = "${baseUrl}cht=lc&chxt=r&chxl=0:|A|B&"
    def result

    void test_right_axis_no_label() {
        result = chart.lineChart{
            axis( right:[] )
        }
        
        assertEquals ( "${baseUrl}cht=lc&chxt=r", result.toString())
    }

    void test_left_axis_no_label() {
        result = chart.lineChart{
            axis( left:[] )
        }

        assertEquals ("${baseUrl}cht=lc&chxt=y", result.toString())
    }

    void test_bottom_axis_no_label() {
        result = chart.lineChart {
            axis( bottom:[])
        }

        assertEquals ("${baseUrl}cht=lc&chxt=x", result.toString())
    }

    void test_top_axis_no_label() {
        result = chart.lineChart {
            axis( top:[])
        }

        assertEquals ("${baseUrl}cht=lc&chxt=t", result.toString())
    }

    void test_all_types_no_label() {
        result = chart.lineChart {
            axis(top:[], bottom:[], left:[], right:[])
        }
        assertEquals ("${baseUrl}cht=lc&chxt=t,x,y,r", result.toString())
    }

    void test_one_axis_with_text_lables() {
        result = chart.lineChart{
            axis(bottom:['One', 'Two', 'Three'])
        }
        assertEquals ("${baseUrl}cht=lc&chxt=x&chxl=0:|One|Two|Three", result.toString())
    }


    void test_one_axis_with_numeric_labels() {
        result = chart.lineChart {
            axis( left: (1..3).toList())
        }
        assertEquals ("${baseUrl}cht=lc&chxt=y&chxl=0:|1|2|3", result.toString())
    }

    void test_multiple_axis_all_with_labels() {
        result = chart.lineChart {
            axis( right: ['A', 'B', 'C'], top: [1,2,3])
        }
        assertEquals ("${baseUrl}cht=lc&chxt=r,t&chxl=0:|A|B|C|1:|1|2|3", result.toString())
    }

    void test_three_axis_middle_one_no_explicit_label() {
        result = chart.lineChart{
            axis(right:['A','B','C'],
                   left: [],
                    bottom:[1,2,3])
        }
        assertEquals ("${baseUrl}cht=lc&chxt=r,y,x&chxl=0:|A|B|C|2:|1|2|3", result.toString())
    }

    void test_label_position_for_one_label() {
        result = chart.lineChart{
            axis(right:['A','B']){
                position(0:[1,5])
            }
        }
        assertEquals ("${axisBase}chxp=0,1,5", result.toString())
    }

    void test_multiple_lable_positions() {
        result = chart.lineChart{
            axis(right:['A','B']){
                position(0:[1,2], 5:[99,5])
            }
        }
        assertEquals ("${axisBase}chxp=0,1,2|5,99,5", result.toString())
    }

    void test_axis_range_for_one_label() {
        result = chart.lineChart{
            axis(right:['A','B']){
                range(0:[100,500])
            }
        }

        assertEquals("${axisBase}chxr=0,100,500", result.toString())
    }

    void test_mulitple_axis_ranges() {
        result = chart.lineChart{
            axis(right:['A','B']){
                range(0:[10,15],3:[88,7])
            }
        }
        assertEquals("${axisBase}chxr=0,10,15|3,88,7", result.toString())
    }

    void test_axis_syle_with_only_color() {
        result = chart.lineChart {
            axis(right:['A','B']){
                style(0:['0000dd'])
            }
        }

        assertEquals ("${axisBase}chxs=0,0000dd", result.toString())
    }

    void test_axis_syle_with_color_and_size() {
        result = chart.lineChart {
            axis(right:['A','B']){
                style(0:['0000dd', 12])
            }
        }
        assertEquals ("${axisBase}chxs=0,0000dd,12", result.toString())
    }

    void test_axis_style_with_12_point_centered() {
        result = chart.lineChart{
            axis(right:['A','B']){
                style(0:['0000dd', 12, 0])
            }
        }

        assertEquals ("${axisBase}chxs=0,0000dd,12,0", result.toString())
    }

    void test_axis_style_with_12_point_right() {
        result = chart.lineChart{
            axis(right:['A','B']){
                style(0:['0000dd', 12, 1])
            }
        }

        assertEquals ("${axisBase}chxs=0,0000dd,12,1", result.toString())
    }

    void test_axis_style_with_12_point_left() {
        result = chart.lineChart{
            axis(right:['A','B']){
                style(0:['0000dd', 12, -1])
            }
        }

        assertEquals ("${axisBase}chxs=0,0000dd,12,-1", result.toString())
    }

     void test_multiple_axis_all_with_styles() {
        def result = chart.lineChart {
            axis( right: ['A', 'B', 'C'], top: [1,2,3]){
                style(0:['0000dd', 12, -1], 1:['0000ff', 14, 0])
            }
        }
        assertEquals ("${baseUrl}cht=lc&chxt=r,t&chxl=0:|A|B|C|1:|1|2|3&chxs=0,0000dd,12,-1|1,0000ff,14,0", result.toString())

    }
}