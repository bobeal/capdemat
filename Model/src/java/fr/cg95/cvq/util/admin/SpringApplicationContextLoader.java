package fr.cg95.cvq.util.admin;

import org.springframework.context.MessageSourceAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

public class SpringApplicationContextLoader {

    public static ClassPathXmlApplicationContext loadContext(String config){
        String[] configLocations = new String[4];
        configLocations[0] = "classpath:/applicationContext.xml";
        configLocations[1] = "classpath:/applicationContext-deployment.xml";
        configLocations[2] = "classpath:/applicationContext-admin.xml";
        configLocations[3] = "classpath*:pluginContext.xml";
        ClassPathXmlApplicationContext cpxa = new ClassPathXmlApplicationContext(configLocations);
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setBasename("messages");
        ((MessageSourceAware)cpxa.getBean("translationService")).setMessageSource(messageSource);
        return cpxa;
    }
}
