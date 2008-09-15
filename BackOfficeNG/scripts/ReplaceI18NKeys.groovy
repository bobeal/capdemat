def keys = [:]
new File('../grails-app/i18n/messages_bare.properties').eachLine { line ->
	if (line.indexOf('\t') != -1) {
		def oldKey = line.substring(0,line.indexOf('\t')).trim()
		def newKey = line.substring(line.indexOf('\t')+1).trim()
		println "gonna replace $oldKey by $newKey"
		keys[oldKey] = newKey
	}
}

def replaceKeys = { line ->
	def newLine = line
	keys.each { key, value ->
		if (line.indexOf(key) != -1)
			newLine = newLine.replaceAll(key,value)
	}
	return newLine
}

new File('../grails-app').eachFileRecurse { file ->
	if (file.getName().endsWith('.groovy') || file.getName().endsWith('.gsp')
			|| file.getName().endsWith('.properties')) {
		println "searching keys file $file"
		def outputFile = new File(file.getAbsolutePath() + '.transformed')
		file.eachLine { line ->
			def newLine = replaceKeys(line)
			outputFile << newLine << '\n'
		}
	}
}

new File('../grails-app').eachFileRecurse { file ->
	if (file.getName().endsWith('.transformed')) {
		println "renaming file $file"
		def outputFile = new File(file.getAbsolutePath() - '.transformed')
		outputFile.delete()
		file.renameTo(outputFile)
	}
}
