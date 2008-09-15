class TextChartDataCodec {
	static encode = { str ->	// str is an array of values
	if (str[0] instanceof ArrayList) {
		def encodedData = []
		for (array in str) {
			encodedData.add(array.encodeAsTextChartData())
		}
		def multipleSets = ''
		for (set in encodedData) multipleSets += set + '|'
		return multipleSets.substring(0,multipleSets.length()-1)
	} else {
		def key = 0.0..100.0
		def maxValue = Collections.max(str)
		def data = ''
		for (i in str) {
			def currentValue = i
			if (currentValue != null && currentValue >= 0) {
				data += key.get(Math.round((key.size() - 1) * currentValue / maxValue).intValue())+','
			} else {
				data += '-1'
			}
		}
		return data.substring(0,data.length()-1)
	}
	}
}
