class SimpleChartDataCodec {
	static encode = { str ->	// str is an array of values
	if (str[0] instanceof ArrayList) {
		def encodedData = []
		for (array in str) {
			encodedData.add(array.encodeAsSimpleChartData())
		}
		def multipleSets = ''
		for (set in encodedData) multipleSets += set + ','
		return multipleSets.substring(0,multipleSets.length()-1)
	} else {
		def key = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789'
		def maxValue = Collections.max(str)
		def data = ''
		for (i in str) {
			def currentValue = i
			if (currentValue != null && currentValue >= 0) {
				data += key.charAt(Math.round((key.size() - 1) * currentValue / maxValue).intValue())
			} else {
				data += '_'
			}
		}
		return data
	}
	}
}
