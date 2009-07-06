// locations to search for config files that get merged into the main config
// config files can either be Java properties files or ConfigSlurper scripts

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

grails.config.locations = [ "classpath:${appName}-config.properties" ]

// if(System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.types = [ html: ['text/html','application/xhtml+xml'],
                      xml: ['text/xml', 'application/xml'],
                      text: 'text-plain',
                      js: 'text/javascript',
                      rss: 'application/rss+xml',
                      atom: 'application/atom+xml',
                      css: 'text/css',
                      csv: 'text/csv',
                      all: '*/*',
                      json: ['application/json','text/json'],
                      form: 'application/x-www-form-urlencoded',
                      multipartForm: 'multipart/form-data'
                    ]
// The default codec used to encode data with ${}
grails.views.default.codec="none" // none, html, base64

// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true

// log4j configuration
log4j {
    appender.stdout = "org.apache.log4j.RollingFileAppender"
    appender.'stdout.layout'="org.apache.log4j.PatternLayout"
    appender.'stdout.File'="capdemat.log"
    appender.'stdout.MaxFileSize'="20000KB"
    appender.'stdout.MaxBackupIndex'="10"
    appender.errors = "org.apache.log4j.FileAppender"
    appender.'errors.layout'="org.apache.log4j.PatternLayout"
    appender.'errors.File'="stacktrace.log"
    rootLogger="error,stdout"
    logger {
        StackTrace="error,errors"
        org {
            codehaus.groovy.grails.web.servlet="error"  //  controllers
            codehaus.groovy.grails.web.pages="error" //  GSP
            codehaus.groovy.grails.web.sitemesh="error" //  layouts
            codehaus.groovy.grails."web.mapping.filter"="error" // URL mapping
            codehaus.groovy.grails."web.mapping"="error" // URL mapping
            codehaus.groovy.grails.commons="info" // core / classloading
            codehaus.groovy.grails.plugins="error" // plugins
            codehaus.groovy.grails.orm.hibernate="error" // hibernate integration
            springframework="off"
            hibernate="off"
        }
        fr.cg95="debug"
    }
    additivity.StackTrace=false
}

// WAR dependency config
grails.war.dependencies = [
    "ant.jar",
    "ant-launcher.jar",
    "hibernate3.jar",
    "jdbc2_0-stdext.jar",
    "jta.jar",
    "groovy-all-*.jar",
    "springmodules-sandbox.jar",
    "standard-${servletVersion}.jar",
    "jstl-${servletVersion}.jar",
    "antlr-*.jar",
    "cglib-*.jar",
    "dom4j-*.jar",
    "ehcache-*.jar",
    "junit-*.jar",
    "commons-logging-*.jar",
    "sitemesh-*.jar",
    "spring-*.jar",
    "log4j-*.jar",
    "ognl-*.jar",
    "hsqldb-*.jar",
    "commons-lang-*.jar",
    "commons-collections-*.jar",
    "commons-beanutils-*.jar",
    "commons-pool-*.jar",
    "commons-dbcp-*.jar",
    "commons-cli-*.jar",
    "commons-validator-*.jar",
    "commons-fileupload-*.jar",
    "commons-io-*.jar",
    "commons-io-*.jar",
    "*oro-*.jar",
    "jaxen-*.jar",
    "xercesImpl.jar",
    "xstream-1.2.1.jar",
    "xpp3_min-1.1.3.4.O.jar"
]

grails.war.java5.dependencies = [
    "hibernate-annotations.jar",
    "ejb3-persistence.jar",
]

grails.views.gsp.encoding="UTF-8"

// Debug Plugin
grails.debug.system = true
grails.debug.stats = true
grails.debug.params = true
grails.debug.headers = true
grails.debug.controller = true
grails.debug.session = true
grails.debug.requestAttributes = true
grails.debug.model = true

//jcaptcha Plugin
import java.awt.Font
import java.awt.Color

import com.octo.captcha.service.multitype.GenericManageableCaptchaService
import com.octo.captcha.engine.GenericCaptchaEngine
import com.octo.captcha.image.gimpy.GimpyFactory
import com.octo.captcha.component.word.wordgenerator.RandomWordGenerator
import com.octo.captcha.component.image.wordtoimage.ComposedWordToImage
import com.octo.captcha.component.image.fontgenerator.RandomFontGenerator
import com.octo.captcha.component.image.backgroundgenerator.GradientBackgroundGenerator
import com.octo.captcha.component.image.color.SingleColorGenerator
import com.octo.captcha.component.image.textpaster.NonLinearTextPaster

jcaptchas {
	captchaImage = new GenericManageableCaptchaService(
		new GenericCaptchaEngine(
			new GimpyFactory(
				new RandomWordGenerator(
					"abcdefghijkmnpqrstuvwxyz23456789"
				),
				new ComposedWordToImage(
					new RandomFontGenerator(
						20, // min font size
						30, // max font size
						[new Font("Arial", 0, 10)] as Font[]
					),
					new GradientBackgroundGenerator(
						150, // width
						50, // height
						new SingleColorGenerator(Color.white),
						new SingleColorGenerator(Color.lightGray)
					),
					new NonLinearTextPaster(
						6, // minimal length of text
						6, // maximal length of text
						Color.black
					)
				)
			)
		),
		180, // minGuarantedStorageDelayInSeconds
		180000 // maxCaptchaStoreSize
	)
}

environments {
    development {
        i18n.basedir = "classpath:"
        log4j {
            appender.'stdout.layout.ConversionPattern'='[%d{ABSOLUTE}] %c{2} %m%n'
            appender.'errors.layout.ConversionPattern'='[%d{ABSOLUTE}] %c{2} %m%n'
            logger {
                grails="debug"
            }
        }
    }
    production {
        i18n.basedir = "/WEB-INF"
        log4j {
            appender.'stdout.layout.ConversionPattern'='[%d{ISO8601}] %c{2} %m%n'
            appender.'errors.layout.ConversionPattern'='[%d{ISO8601}] %c{2} %m%n'
            logger {
                grails="error"
            }
        }
    }
}