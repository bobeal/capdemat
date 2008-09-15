class ChartAreaBackgroundFillTest extends GoogleChartBuilderTestCase {
    def result
    def testBaseUrl = "${baseUrl}cht=lc&chf="

    void test_base_background_fill_url() {
        result = chart.lineChart{
            backgrounds{
                background()
            }
        }

        assertEquals("${testBaseUrl}bg,", result.toString())
    }

    void test_base_chart_area_fill_url() {
        result = chart.lineChart{
            backgrounds{
                area()
            }
        }

        assertEquals ("${testBaseUrl}c,", result.toString())
    }

    void test_background_solid_fill() {
        result = chart.lineChart{
            backgrounds{
                background{
                    solid(color:'ff0000')
                }
            }
        }
        assertEquals ("${testBaseUrl}bg,s,ff0000", result.toString())
    }

    void test_chart_area_solid_fill() {
        result = chart.lineChart{
            backgrounds{
                area{
                    solid(color:'ff0000')
                }
            }
        }
        assertEquals ("${testBaseUrl}c,s,ff0000", result.toString())
    }

    void test_background_zero_degree_linear_gradient() {
        result = chart.lineChart{
            backgrounds{
                background{
                    gradient(angle:0, start:'fff000', end:'0000ff')
                }
            }
        }

        assertEquals ("${testBaseUrl}bg,lg,0,fff000,0,0000ff,1", result.toString())
    }

    void test_chart_area_zero_degree_linear_gradient() {
        result = chart.lineChart{
            backgrounds{
                area{
                    gradient(angle:0, start:'fff000', end:'0000ff')
                }
            }
        }

        assertEquals ("${testBaseUrl}c,lg,0,fff000,0,0000ff,1", result.toString())
    }

    void test_background_45_degree_linear_gradinet() {
       result = chart.lineChart{
           backgrounds{
                background{
                    gradient(angle:45, start:'fff000', end:'0000ff')
                }
           }
        }

        assertEquals ("${testBaseUrl}bg,lg,45,fff000,0,0000ff,1", result.toString())
    }

    void test_chart_area_45_degree_linear_gradinet() {
       result = chart.lineChart{
           backgrounds{
                area{
                    gradient(angle:45)
                }
           }
        }

        assertEquals ("${testBaseUrl}c,lg,45,ffffff,0,efefef,1", result.toString())
    }

    void test_background_two_vertical_linear_stripes() {
        result = chart.lineChart{
            backgrounds{
                background{
                    stripes(angle:0){
                        stripe(color:'CCCCCC', width:0.2)
                        stripe(color:'FFFFFF', width:0.2)
                    }
                }
            }
        }
        assertEquals ("${testBaseUrl}bg,ls,0,CCCCCC,0.2,FFFFFF,0.2", result.toString())
    }

   void test_chart_area_two_vertical_linear_stripes() {
        result = chart.lineChart{
            backgrounds{
                area{
                    stripes(angle:0){
                        stripe(color:'CCCCCC', width:0.2)
                        stripe(color:'FFFFFF', width:0.2)
                    }
                }
            }
        }
        assertEquals ("${testBaseUrl}c,ls,0,CCCCCC,0.2,FFFFFF,0.2", result.toString())
    }

    void test_background_three_horizontall_linear_stripes() {
        result = chart.lineChart{
            backgrounds{
                background{
                    stripes(angle:90){
                        stripe(color:'CCCCCC', width:0.2)
                        stripe(color:'FFFFFF', width:0.2)
                        stripe(color:'AAAAAA', width:0.2)
                    }
                }
            }
        }
        assertEquals ("${testBaseUrl}bg,ls,90,CCCCCC,0.2,FFFFFF,0.2,AAAAAA,0.2", result.toString())
    }

    void test_chart_area_three_horizontall_linear_stripes() {
        result = chart.lineChart{
            backgrounds{
                area{
                    stripes(angle:90){
                        stripe(color:'CCCCCC', width:0.2)
                        stripe(color:'FFFFFF', width:0.2)
                        stripe(color:'AAAAAA', width:0.2)
                    }
                }
            }
        }
        assertEquals ("${testBaseUrl}c,ls,90,CCCCCC,0.2,FFFFFF,0.2,AAAAAA,0.2", result.toString())
    }
}