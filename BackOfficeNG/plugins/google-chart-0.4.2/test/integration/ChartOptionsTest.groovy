class ChartOptionsTest extends GoogleChartBuilderTestCase{
	
	void test_single_line_chart_title(){
		def result = chart.pieChart{
			title(){
				row('This is a single line title')
			}
		}
		assertEquals("${baseUrl}cht=p&chtt=This+is+a+single+line+title", result.toString())
	}

	void test_double_line_chart_title(){
		def result = chart.pieChart{
			title(){
				row('First Row')
				row('Second Row')
			}
		}
		assertEquals("${baseUrl}cht=p&chtt=First+Row|Second+Row", result.toString())
	}

	void test_chart_title_color_and_size(){
		def result = chart.pieChart {
			title(color:'FF0000', size:20){
				row('Title')
			}
		}
		assertEquals("${baseUrl}cht=p&chts=FF0000,20&chtt=Title", result.toString())
	}

    void test_legend_one_legend_one_word() {
        def result = chart.legend{
            label('Label')
        }
        assertEquals ("${baseUrl}chdl=Label", result.toString())
    }

    void test_one_legend_two_words() {
        def result = chart.legend{
            label('Two Words')
        }
        
        assertEquals( "${baseUrl}chdl=Two+Words", result.toString())
    }

    void test_multiple_legends() {
        def result = chart.legend{
            label('Legend1')
            label('Legend Two')
        }

        assertEquals ("${baseUrl}chdl=Legend1|Legend+Two", result.toString())
    }


    void test_pie_chart_label_one_label() {
        def result = chart.labels{
            label('Label1')
        }

        assertEquals ("${baseUrl}chl=Label1", result.toString())
    }

    void test_pie_chart_label_one_multi_word_label() {
        def result = chart.labels{
            label('Two words')
        }

        assertEquals ("${baseUrl}chl=Two+words", result.toString())
    }

    void test_pie_chart_label_multiple_labels() {
        def result = chart.labels {
            label('Label one')
            label('2ndLabel')
        }

        assertEquals ("${baseUrl}chl=Label+one|2ndLabel", result.toString())
    }



}
