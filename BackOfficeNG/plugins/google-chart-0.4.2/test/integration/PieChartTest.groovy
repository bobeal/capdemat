class PieChartTest extends GoogleChartBuilderTestCase {

    def textList = (1..5).toList()
    def result
    void test_basic_2d_pie_chart() {
        result = chart.pieChart{
            size(w:300, h:150)
			data(encoding:'text'){
				dataSet(textList)
			}
		}
		
		assertEquals("${baseUrl}cht=p&chs=300x150&chd=t:1,2,3,4,5", 
				result.toString())
	}

    void test_basic_3d_pie_chart() {
        result = chart.pie3DChart{
            size(w:350, h:200)
            data(encoding:'text'){
                dataSet(textList)
            }
        }

        assertEquals ("${baseUrl}cht=p3&chs=350x200&chd=t:${chart.listToString(textList)}", result.toString())
    }

    void test_2d_pie_chart_with_data_labels() {
        result = chart.pieChart{
            size(w:350, h:200)
            data(encoding:'text'){
                dataSet(textList)
            }
            labels{
                textList.each{ label(it) }
            }
        }

        assertEquals("${baseUrl}cht=p&chs=350x200&chd=t:${chart.listToString(textList)}&chl=1|2|3|4|5", result.toString())
    }

    void test_3d_pie_chart_with_data_labels() {
        result = chart.pie3DChart{
            size(w:350, h:200)
            data(encoding:'text'){
                dataSet(textList)
            }
            labels{
                textList.each{ label(it) }
            }
        }

        assertEquals("${baseUrl}cht=p3&chs=350x200&chd=t:${chart.listToString(textList)}&chl=1|2|3|4|5", result.toString())
    }

    void test_pie_chart_with_custom_colors() {
        result = chart.pie3DChart{
            size(w:350, h:200)
            data(encoding:'t'){
                dataSet(textList)
            }
            colors{
                color('0000ff')
                color('ff0000')
            }
        }
        assertEquals("${baseUrl}cht=p3&chs=350x200&chd=t:${chart.listToString(textList)}&chco=0000ff,ff0000", result.toString())
    }

    void test_3D_pie_chart_with_multi_row_title() {
        result = chart.pie3DChart{
            size(w:350, h:250)
            data(encoding:'text'){
                dataSet(textList)
            }
            title(color:'0000ff', size:20){
                row('First Title')
                row('Second Title')
            }
        }

        assertEquals "http://chart.apis.google.com/chart?cht=p3&chs=350x250&chd=t:1,2,3,4,5&chts=0000ff,20&chtt=First+Title|Second+Title", result.toString()
    }

    void test_3D_pie_chart_with_solid_background_fill() {
        result = chart.pie3DChart{
            size(w:350, h:250)
            data(encoding:'t'){
                dataSet(textList)
            }
            background{
                solid(color:'ff0000')
            }
        }
        assertEquals "http://chart.apis.google.com/chart?cht=p3&chs=350x250&chd=t:1,2,3,4,5bg,s,ff0000", result.toString()
    }

    void test_3D_pie_chart_with_gradient_background_fill() {
        result = chart.pie3DChart{
            size(w:350, h:250)
            data(encoding:'t'){
                dataSet(textList)
            }
            background{
                gradient(angle:0, start:'FFFFFF', end:'0000ff')
            }
        }
         assertEquals "http://chart.apis.google.com/chart?cht=p3&chs=350x250&chd=t:1,2,3,4,5bg,lg,0,FFFFFF,0,0000ff,1", result.toString()
    }

    void test_pie_chart_with_vertical_background_fill() {
        result = chart.pieChart{
            size(w:350, h:250){
                data(encoding:'t'){
                    dataSet(textList)
                }
            }
            background{
                stripes(angle:0){
                    stripe(color:'CCCCCC', width:0.20)
                    stripe(color:'ffffff', width:0.20)
                }    
            }
        }
         assertEquals "http://chart.apis.google.com/chart?cht=p&chs=350x250&chd=t:1,2,3,4,5bg,ls,0,CCCCCC,0.20,ffffff,0.20", result.toString()
    }
    

}
