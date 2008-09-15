class VennDiagramTest extends GoogleChartBuilderTestCase {
    def result
    void test_venn_with_all_options() {
        result = chart.vennDiagram{
            size(w:350, h:200)
            title{
                row("Music Tates")
            }
            data(encoding:'text'){
                dataSet([100,80,60,30,30,30,10])
            }
            legend{
                label('Music I Like')
                label('Music Joe Likes')
                label('Music Amy Likes')
            }
            colors{
                color('00ff00')
                color('ff00ff')
                color('0000aa')
            }
            background{
                solid(color:'bdbdbd')
            }

        }
         assertEquals "http://chart.apis.google.com/chart?cht=v&chs=350x200&chtt=Music+Tates&chd=t:100,80,60,30,30,30,10&chdl=Music+I+Like|Music+Joe+Likes|Music+Amy+Likes&chco=00ff00,ff00ff,0000aabg,s,bdbdbd", result.toString()
    }

}