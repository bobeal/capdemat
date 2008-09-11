class GridLinesTest extends GoogleChartBuilderTestCase {

    def result

    void test_20_x_50_step_size() {
        result = chart.lineChart{
            grid(x:20, y:50)
        }

        assertEquals ("${baseUrl}cht=lc&chg=20,50", result.toString())
    }

    void test_base_grid_plus_line_style() {
        result = chart.lineChart{
            grid(y:55, x:25, dash:3, space:1)
        }

        assertEquals ("${baseUrl}cht=lc&chg=25,55,3,1", result.toString())
    }
}