
class GoogleChartGrailsPlugin {
	def version = '0.4.2'
	def dependsOn = [:]
	def author = 'James Williams'
	def authorEmail = 'jwill@codehaus.org'
	def title = 'This plugin adds Google Chart API features to Grails applications.'
	def documentation = "http://grails.codehaus.org/Google+Chart+Plugin"
	
	def doWithSpring = {
		// TODO Implement runtime spring config (optional)
	}   
	def doWithApplicationContext = { applicationContext ->
		// TODO Implement post initialization spring config (optional)		
	}
	def doWithWebDescriptor = { xml ->
		// TODO Implement additions to web.xml (optional)
	}	                                      
	def doWithDynamicMethods = { ctx ->
		// TODO Implement additions to web.xml (optional)
	}	
	def onChange = { event ->
		// TODO Implement code that is executed when this class plugin class is changed  
		// the event contains: event.application and event.applicationContext objects
	}                                                                                  
	def onApplicationChange = { event ->
		// TODO Implement code that is executed when any class in a GrailsApplication changes
		// the event contain: event.source, event.application and event.applicationContext objects
	}
}
