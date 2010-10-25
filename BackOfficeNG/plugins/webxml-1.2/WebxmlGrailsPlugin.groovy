import groovy.xml.StreamingMarkupBuilder;

/**
 * Copyright 2008 Roger Cass (roger.cass@byu.net)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * History
 *   1.0 Roger Cass, Filter/BeanMapping
 *   1.1 ericacm - gmail.com, Listener
 *   1.2 Bob Schulze al.lias - web.de, Context Parameters
 *   
 */
class WebxmlGrailsPlugin {

    def DEFAULT_CONFIG_FILE = "DefaultWebXmlConfig"
    def APP_CONFIG_FILE     = "WebXmlConfig"

    def version = "1.2"
    def author = "Roger Cass"
    def authorEmail = "roger.cass@byu.net"
    def title = "Create useful additions to web.xml"
    def description = '''Add additional Features to your web.xml, such as Filters, Config Listeners or Context
Parameter definitions '''
    def documentation = "http://grails.org/WebXML+Plugin"
    def watchedResources = "**/grails-app/conf/${APP_CONFIG_FILE}.groovy"    
	
    def doWithSpring = {
        // TODO Implement runtime spring config (optional)
    }
   
    def doWithApplicationContext = { applicationContext ->
        // TODO Implement post initialization spring config (optional)		
    }

    def doWithWebDescriptor = { xml ->
    
        def config = getConfig()

        if(config) {
            if(config.filterChainProxyDelegator?.add) {
                def contextParam = xml."context-param"
                    contextParam[contextParam.size() - 1] + {
                        'filter' {
                            'filter-name'(config.filterChainProxyDelegator.filterName)
                            'filter-class'(config.filterChainProxyDelegator.className)
                            'init-param' {
                                'param-name'('targetBeanName')
                                'param-value'(config.filterChainProxyDelegator.targetBeanName)
                            }
                        }
                    }
        
                def filter = xml."filter"
                    filter[filter.size() - 1] + {
                        'filter-mapping' {
                            'filter-name'(config.filterChainProxyDelegator.filterName)
                            'url-pattern'(config.filterChainProxyDelegator.urlPattern)
                        }
                    }
            }

            if (config.listener?.add) {
                def listenerNode = xml."listener"

                config.listener.classNames.each{ cn ->
                    def lnode = {
                        'listener' {
                            'listener-class'(cn)
                        }
                    }
                    listenerNode[listenerNode.size() - 1] + lnode
                }
            }

            if (config.servlet?.add) {

                def servletNode = xml."servlet"
                config.servlet.names.each{ name, clazz ->
                    def snode = {
                        'servlet' {
                            'servlet-name'(name)
                            'servlet-class'(clazz)
                            config.servlet.initparams[name].each { key, value ->
                            'init-param' {
                                'param-name'(key)
                                'param-value'(value)
                            }
                        }
                        }
                    }
                    servletNode[servletNode.size() - 1] + snode
                }

                def servletMappingNode = xml."servlet-mapping"
                config.servlet.mappings.each{ name, url ->
                    def snode = {
                        'servlet-mapping' {
                            'servlet-name'(name)
                            'url-pattern'(url)
                        }
                    }
                    servletMappingNode[servletMappingNode.size() - 1] + snode
                }
            }

            if (config.filter?.add) {

                def filterNode = xml."filter"
                config.filter.names.each{ name, clazz ->
                    def fnode = {
                        'filter' {
                            'filter-name'(name)
                            'filter-class'(clazz)
                            config.filter.initparams[name].each { key, value ->
                                'init-param' {
                                    'param-name'(key)
                                    'param-value'(value)
                                }
                            }
                        }
                    }
                    filterNode[filterNode.size() - 1] + fnode
                }

                def filterMappingNode = xml."filter-mapping"
                config.filter.mappings.each{ name, url ->
                    def fnode = {
                        'filter-mapping' {
                            'filter-name'(name)
                            'url-pattern'(url)
                        }
                    }
                    filterMappingNode[filterMappingNode.size() - 1] + fnode
                }
            }

            // add possibility for context params. As with the other features, the generated result is a bit thin,
            // it could contain the descriptions field too, a context.xml also would be a good idea...  (bs)
            if (config.contextparams) {
                config.contextparams.each{ k, v ->
                    def contextParam = xml."context-param"
                        contextParam[contextParam.size() - 1] + {
                        'context-param' {
                            'param-name'(k)
                            'param-value'(v)
                            }
                        }
                }
            }
        }

//        System.out.println new StreamingMarkupBuilder().bind{ out << xml }
    }
	                                      
    def doWithDynamicMethods = { ctx ->
        // TODO Implement registering dynamic methods to classes (optional)
    }
	
    def onChange = { event ->
        // TODO Implement code that is executed when this class plugin class is changed  
        // the event contains: event.application and event.applicationContext objects
    }
                                                                                  
    def onApplicationChange = { event ->
        // TODO Implement code that is executed when any class in a GrailsApplication changes
        // the event contain: event.source, event.application and event.applicationContext objects
    }
    
    def getConfig = {
        ClassLoader parent = getClass().getClassLoader()
        GroovyClassLoader loader = new GroovyClassLoader(parent)

        def config

        try {
            def defaultConfigFile = loader.loadClass(DEFAULT_CONFIG_FILE)
            //log.info("Loading default config file: "+defaultConfigFile)
            config = new ConfigSlurper().parse(defaultConfigFile)
            
            try {
                def appConfigFile = loader.loadClass(APP_CONFIG_FILE)
                //log.info("Found application config file: "+appConfigFile)
                def appConfig = new ConfigSlurper().parse(appConfigFile)
                if (appConfig) {
                    //log.info("Merging application config file: "+appConfigFile)
                    config = config.merge(appConfig)
                }
            } catch(ClassNotFoundException e) {
                //log.warn("Did not find application config file: "+APP_CONFIG_FILE)
            }
        } catch(ClassNotFoundException e) {
            //log.error("Did not find default config file: "+DEFAULT_CONFIG_FILE)
        }

        config?.webxml
    }
}
