class ScatterPlotTest extends GoogleChartBuilderTestCase {
    def result
    void test_scatter_plot_with_all_options() {
        result = chart.scatterPlot{
            title{
                row('My scatter plot chart')
            }
            size(w:300, h:200)
            data(encoding:'text'){
                dataSet([5,10,20]) // x coords
                dataSet([10, 22, 14]) // y coords
                dataSet([40,80,120]) // point size
            }
            legend{
                label('Joy')
            }
            markers{
                shape(type:'diamond', color:'FF0000', set:0, point:1.0, size:20 )
            }
            grid(y:55, x:20, dash:3, space:1)
            axis(left:[25,50], bottom:[0,20,40,60,80,100]){
                position(0:[55,100])
                style(0:['0000dd', 12, -1])
                style(1:['00cccc', 16, 0])
                range(0:[5,100])
                range(1:[50, 100])
            }
        }
         assertEquals "http://chart.apis.google.com/chart?cht=s&chtt=My+scatter+plot+chart&chs=300x200&chd=t:5,10,20|10,22,14|40,80,120&chdl=Joy&chm=d,FF0000,0,1.0,20&chg=20,55,3,1&chxt=y,x&chxl=0:|25|50|1:|0|20|40|60|80|100&chxp=0,55,100&chxs=0,0000dd,12,-1|1,00cccc,16,0&chxr=0,5,100|1,50,100", result.toString()
    }

}