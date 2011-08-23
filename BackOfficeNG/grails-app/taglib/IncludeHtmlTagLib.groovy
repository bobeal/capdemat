class IncludeHtmlTagLib {

  static namespace = 'html'

  def render = {attrs ->

    def filePath = attrs.file

//    if (!filePath) {
//      throwTagError("'file' attribute must be provided")
//    }
	
	File includedFile = new File(filePath);
	
	if (includedFile.exists()){
	    def htmlContent = includedFile.text
	    out << htmlContent
	}
		
  }
}
