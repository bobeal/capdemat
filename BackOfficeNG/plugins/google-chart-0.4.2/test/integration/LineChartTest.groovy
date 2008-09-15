class LineChartTest extends GoogleChartBuilderTestCase {
    def result
    void test_regular_line_chart_with_all_options() {
        result = chart.lineChart{
            size(w:300, h:200)
            title{
                row('Joy vs. Pain')
            }
            data(encoding:'extended'){
                dataSet([1,18,200,87,1090,44,3999])
                dataSet([88,900,77,1,2998,4])
            }
            colors{
                color('66CC00')
                color('3399ff')
            }
            lineStyle(line1:[1,6,3])
            legend{
                label('Joy')
                label('Pain')
            }
            axis(left:(1..5).toList(), bottom:[])
            backgrounds{
                background{
                    solid(color:'999999')
                }
                area{
                    gradient(angle:45, start:'CCCCCC', end:'999999')
                }
            }
             markers{
                rangeMarker(type:'horizontal', color:'FF0000', start:0.75, end:0.25)
                rangeMarker(type:'vertical', color:'0000cc', start:0.7, end:0.71)
            }
        }

         assertEquals "http://chart.apis.google.com/chart?cht=lc&chs=300x200&chtt=Joy+vs.+Pain&chd=e:ABASDIBXRCAs-f,BYOEBNABu2AE&chco=66CC00,3399ff&chls=1,6,3&chdl=Joy|Pain&chxt=y,x&chxl=0:|1|2|3|4|5&chf=bg,s,999999|c,lg,45,CCCCCC,0,999999,1&chm=r,FF0000,0,0.75,0.25|R,0000cc,0,0.7,0.71", result.toString()
    }

     void test_regular_line_xy_chart_with_all_options() {
        result = chart.lineXYChart{
            size(w:300, h:200)
            title{
                row('Joy vs. Time')
            }
            data(encoding:'simple'){
                 def map = [55:22, 33:18, 99:43,66:100, 0:9 ]
                dataSet(map.keySet().toList())
                dataSet(map.values().toList())
            }
            colors{
                color('3399ff')
            }
            lineStyle(line1:[3,6,3])
            legend{
                label('Joy')
            }
            axis(left:(1..5).toList(), bottom:[])
            backgrounds{
                background{
                    solid(color:'999999')
                }
                area{
                    gradient(angle:45, start:'CCCCCC', end:'999999')
                }
            }
             markers{
                rangeMarker(type:'horizontal', color:'FF0000', start:0.75, end:0.25)
                rangeMarker(type:'vertical', color:'0000cc', start:0.7, end:0.71)
            }
        }

         assertEquals "http://chart.apis.google.com/chart?cht=lxy&chs=300x200&chtt=Joy+vs.+Time&chd=s:3hnullnullA,WSrnullJ&chco=3399ff&chls=3,6,3&chdl=Joy&chxt=y,x&chxl=0:|1|2|3|4|5&chf=bg,s,999999|c,lg,45,CCCCCC,0,999999,1&chm=r,FF0000,0,0.75,0.25|R,0000cc,0,0.7,0.71", result.toString()
    }
}