class BarChartTest extends GoogleChartBuilderTestCase {
    def result

    void test_horizontal_stacked_chart_with_all_options() {
        createBarChartThatIs('horizontal','stacked')
         assertEquals "http://chart.apis.google.com/chart?cht=bhs&chbh=10,2&chs=350x200&chts=808080,16&chtt=Chart+1|Sampel+bar+chart&chd=s:BCDEF,FEDCB&chco=66CC00,3399ff&chdl=Joy|Pain&chxt=y,x&chxl=0:|1|2|3|4|5&chf=bg,s,999999|c,lg,45,CCCCCC,0,999999,1", result.toString()
    }

    void test_horizontal_grouped_chart_with_all_options() {
        createBarChartThatIs('horiz', 'grouped')
         assertEquals "http://chart.apis.google.com/chart?cht=bhg&chbh=10,2&chs=350x200&chts=808080,16&chtt=Chart+1|Sampel+bar+chart&chd=s:BCDEF,FEDCB&chco=66CC00,3399ff&chdl=Joy|Pain&chxt=y,x&chxl=0:|1|2|3|4|5&chf=bg,s,999999|c,lg,45,CCCCCC,0,999999,1", result.toString()
    }

    void test_vertical_stacked_chart_with_all_options() {
        createBarChartThatIs ('vert', 'stacked')
         assertEquals "http://chart.apis.google.com/chart?cht=bvs&chbh=10,2&chs=350x200&chts=808080,16&chtt=Chart+1|Sampel+bar+chart&chd=s:BCDEF,FEDCB&chco=66CC00,3399ff&chdl=Joy|Pain&chxt=y,x&chxl=0:|1|2|3|4|5&chf=bg,s,999999|c,lg,45,CCCCCC,0,999999,1", result.toString()
    }

    void test_vertical_grouped_chart_with_all_options() {
        createBarChartThatIs('vertical', 'grouped')
         assertEquals "http://chart.apis.google.com/chart?cht=bvg&chbh=10,2&chs=350x200&chts=808080,16&chtt=Chart+1|Sampel+bar+chart&chd=s:BCDEF,FEDCB&chco=66CC00,3399ff&chdl=Joy|Pain&chxt=y,x&chxl=0:|1|2|3|4|5&chf=bg,s,999999|c,lg,45,CCCCCC,0,999999,1", result.toString()
    }

    void createBarChartThatIs(orientation, style){
        result = chart.barChart([orientation, style]){
            barSize(witdth:10, space:2)
            size(w:350, h:200)
            title(color:808080, size:16){
                row('Chart 1')
                row('Sampel bar chart')
            }
            data(encoding:'simple'){
                dataSet((1..5).toList())
                dataSet((5..1).toList())
            }
            colors{
                color('66CC00')
                color('3399ff')
            }
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
        }
    }


}