class ExtendedChartDataCodec {
	static values = []
	static encode = { str ->	// str is an array of values
	if (str[0] instanceof ArrayList) {
		def encodedData = []
		for (array in str) {
			encodedData.add(array.encodeAsExtendedChartData())
		}
		def multipleSets = ''
		for (set in encodedData) multipleSets += set + ','
		return multipleSets.substring(0,multipleSets.length()-1)
	} else {
		//Compose list of keys
		def key = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-."
		if (values.size() == 0) {
			for (i in key)
 				for (k in key)
    				values += (i+k)
		}
		def maxValue = Collections.max(str)
		def data = ''
		for (i in str) {
			def currentValue = i
			if (currentValue != null && currentValue >= 0) {
				data += values[(Math.round((values.size() - 1) * currentValue / maxValue).intValue())]
			} else {
				data += '_'
			}
		}
		return data.substring(0,data.length()-1)
	}
	}
}
