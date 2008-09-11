class DataEncodingTest extends GoogleChartBuilderTestCase {
    def testBaseUrl = "${baseUrl}cht=lc&chd="

    void assertExtendedMatch(expected, input){
        assertEquals(expected, chart.extendedTranslator(input))
    }

    void test_simple_encode_list_of_numbers() {
        def input = (0..5).toList()
        def expected  ='ABCDEF'

        chart.encodingTranslator = chart.translators['s']

        def result = chart.encodingTranslator.call(input)

        assertEquals (expected, result.toString())
    }

    void test_extended_encoded_list_of_numbers() {
        def input = (0..5).toList()
        def expected = 'AAABACADAEAF'

        chart.encodingTranslator = chart.translators['e']
        def result = chart.encodingTranslator.call(input)

        assertEquals(expected, result.toString())
    }

    void test_text_encoding_list_of_numbers() {
        def input = (0..5).toList()
        def expected = '0,1,2,3,4,5'

        chart.encodingTranslator = chart.translators['t']
        def result = chart.encodingTranslator.call(input)

        assertEquals (expected, result.toString())
    }


}
