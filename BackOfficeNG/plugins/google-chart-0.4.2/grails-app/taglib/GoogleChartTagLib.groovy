class GoogleChartTagLib {
	static apiString = "http://chart.apis.google.com/chart?"

	def baseChart(attrs) { 
		def baseString = ''
		baseString += '<img src='
		baseString += '\"'+apiString
		if (attrs.size != null)
			baseString += 'chs='+attrs.size[0]+'x'+attrs.size[1]
		else baseString += 'chs=400x200'
		
		def minValue = attrs.minValue ?: 0
        def maxValue = attrs.maxValue ?: null

		if (attrs.dataType == null || attrs.dataType == 'simple') {
			baseString += '&chd=s:' + chartDataEncoding(attrs.data, minValue, maxValue)
		} else if (attrs.dataType == 'text') {
            baseString += '&chd=t:' + chartDataEncoding(attrs.data, minValue, maxValue, textChartDataValues)
		} else if (attrs.dataType == 'extended') {
			baseString += '&chd=e:' + chartDataEncoding(attrs.data, minValue, maxValue, extendedChartDataValues)
		}
		
		if (attrs.axes != null) {
			baseString += '&chxt=' + attrs.axes
		}
		
		// takes a map in the form
		// [0:[Jan,Feb,Mar], 1:[0,100]...]
		if (attrs.axesLabels != null) {
			baseString += '&chxl='
			baseString += processAxesLabels(attrs.axesLabels)
		}
		
		// takes a map in the form
		// [0:[Jan,Feb,Mar], 1:[0,100]...]
		if (attrs.axesPositions != null) {
			baseString += '&chxp='
			baseString += processAxesPositions(attrs.axesPositions)
		}
		
		// takes a map in the form
		// [0:[Jan,Feb,Mar], 1:[0,100]...]
		if (attrs.axesRanges != null) {
			baseString += '&chxr='
			baseString += processAxesPositions(attrs.axesRanges)
		}
		
		// takes a map in the form
		// [0:[Jan,Feb,Mar], 1:[0,100]...]
		if (attrs.axesStyles != null) {
			baseString += '&chxs='
			baseString += processAxesPositions(attrs.axesStyles)
		}
		
		if (attrs.colors != null) {
			baseString += '&chco='
			def colors = ''
			for(color in attrs.colors) {
				colors += color + ','
			}
			baseString += colors.substring(0,colors.length()-1)
		}
		
		if (attrs.fill != null) {
			baseString += '&chf='
			if (attrs.fill instanceof ArrayList)
				baseString += attrs.fill[0] + '|' + attrs.fill[1]
			else baseString += attrs.fill
		}
		
		// takes an ArrayList of the titles
		// Valid for all types except pie charts
		if (attrs.legend != null) {
			baseString += '&chdl='
			def legendLabels = ''
			for(label in attrs.legend) {
				legendLabels += label + '|'
			}
			baseString += legendLabels.substring(0,legendLabels.length()-1)
		}
		// chart title and attributes
		if (attrs.title != null)
			baseString += '&chtt='+attrs.title.encodeAsHTML()
		// takes an array of length 2 [color, font size]
		if (attrs.titleAttrs != null) {
			println attrs.titleAttrs
			baseString += "&chts=${attrs.titleAttrs[0]},${attrs.titleAttrs[1]}"
		}
		return baseString
	}

	def processAxesLabels(params) {
		def labelString = ''
		for (axis in params.keySet()) {
			labelString += "${axis}:|"
			for (value in params[axis]) {
				labelString += "${value}|"
			}
		}
		return labelString.substring(0,labelString.length()-1)
	}
	
	def processAxesPositions(params) {
		def posString = ''
		for (axis in params.keySet()) {
			posString += "${axis},"
			for (value in params[axis]) {
				posString += "${value},"
			}
			posString = posString.substring(0,posString.length()-1) + '|'
		}
		return posString.substring(0,posString.length()-1)
	}

	// Attributes:
	// size	- ArrayList
	// type - simple, text, or extended
	def pieChart = { attrs, body ->
		out << baseChart(attrs)
		
		if (attrs.labels != null) {
			out << '&chl='
			def labels = ''
			for(label in attrs.labels) {
				labels += label + '|'
			}
			out << labels.substring(0,labels.length()-1)
		}
		
		if (attrs.type != '3d')
			out << '&cht=p'
		else out << '&cht=p3'
		
		out << '\" />'
	}
	
	def lineChart = { attrs, body ->
		out << baseChart(attrs)
		
		//chart line styles
		if (attrs.lineStyles != null) {
			out << '&chls='
			def lineText = ''
			for (line in attrs.lineStyles) {
				for (val in line) {
					lineText += (val + ',')
				}
				lineText = lineText.substring(0, lineText.length() - 1) + '|'
			}
			lineText = lineText.substring(0, lineText.length() - 1)
			out << lineText
		}
		//grid styles
		if (attrs.gridLines != null) {
			out << '&chg='
			out << attrs.gridLines
		}
		out << parseShapeRangeFill(attrs)		
		
		if (attrs.type != 'xy')
			out << '&cht=lc'
		else out << '&cht=lxy'
		
		out << '\" />'
	}
	
	String parseShapeRangeFill(params) {
		def text = ''
		if (params.shapeRangeFill != null) {
			text += '&chm='
			def shapeText = ''
			for (shape in params.shapeRangeFill) {
				for (val in shape) {
					shapeText += (val + ',')
				}
				shapeText = shapeText.substring(0, shapeText.length() - 1) + '|'
			}
			shapeText = shapeText.substring(0, shapeText.length() - 1)
			text += shapeText
		}
		return text
	}
	
	// You must specify the type for a bar chart, there
	// are just too many combinations
	def barChart = { attrs, body ->
		out << baseChart(attrs)

		out << '&cht='+attrs.type
		
		out << '\" />'
	}
	
	def vennDiagram = { attrs, body ->
		out << baseChart(attrs)

		out << '&cht=v'
		
		out << '\" />'
	}
	
	def scatterPlot = { attrs, body ->
		out << baseChart(attrs)
		out << '&cht=s'
		out << parseShapeRangeFill(attrs)
		//grid lines
		if (attrs.gridLines != null) {
			out << '&chg='
			out << attrs.gridLines
		}
		
		out << '\" />'
	}

	def simpleChartDataValues = { dataSet, minValue, maxValue ->
        return dataSet.collect { currentValue ->
            if (currentValue != null && currentValue >= minValue && currentValue <= maxValue) {
                def key = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789'
                return key.charAt(Math.round(61 * ((currentValue - minValue) / (maxValue - minValue))).intValue())
            }
            return "_"
        }.join("")
    }

    def textChartDataValues = { dataSet, minValue, maxValue ->
        return dataSet.collect { currentValue ->
            if (currentValue != null && currentValue >= minValue && currentValue <= maxValue) {
                def key = 0.0..100.0
                return key.get(Math.round(100 * ((currentValue - minValue) / (maxValue - minValue))).intValue())
            } else {
                return "-1"
            }
        }.join(",")
    }

    def extendedChartDataValues = { dataSet, minValue, maxValue ->
        def chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-."
        def keys = chars.collect { first -> chars.collect { second ->"$first$second"} }.flatten()

        return dataSet.collect { currentValue ->
            if (currentValue != null && currentValue >= minValue && currentValue <= maxValue) {
                return keys.get(Math.round(4095 * ((currentValue - minValue) / (maxValue - minValue))).intValue())
            }
            return "_"
        }.join("")
    }

	def chartDataEncoding = { dataSet, minValue = 0, maxValue = null, dataValueClosure = simpleChartDataValues ->
        maxValue = maxValue ?: dataSet.flatten().max()
        if (dataSet[0] instanceof List) {
            return dataSet.collect{ chartDataEncoding(it, minValue, maxValue, dataValueClosure) }.join("|")
        } else {
            return dataValueClosure.call(dataSet, minValue, maxValue)
        }
    }
}
