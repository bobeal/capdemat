// add langs here
def langs = ['fr']
def baseFilename = '../grails-app/i18n/messages'

def extractKeys = { filename ->
	def keys = []
	new File(filename).eachLine { line ->
		if (line.indexOf('=') != -1) {
			def key = line.substring(0,line.indexOf('=')).trim()
			keys << key
		}
	}
    return keys;
}

def referenceKeys = extractKeys(baseFilename + '.properties')

langs.each { lang ->
    def langKeys = extractKeys(baseFilename + '_' + lang + '.properties')
    langKeys.each {
    	if (!referenceKeys.contains(it))
            println "$it in $lang does not exist in reference file"
    }
    referenceKeys.each {
    	if (!langKeys.contains(it))
            println "$it in reference file does not exist in $lang"
    }
}

// create a file containing only keys
// useful for migration operations

/*
def bareKeysFile = new File(baseFilename + '_bare.properties')
bareKeysFile.delete()
referenceKeys.each {
	bareKeysFile << it << '\n'
}
*/