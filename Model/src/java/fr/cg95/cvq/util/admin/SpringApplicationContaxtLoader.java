package fr.cg95.cvq.util.admin;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplicationContaxtLoader {

    public static ClassPathXmlApplicationContext loadContext(String config){
        String[] configLocations = new String[4];
        configLocations[0] = "classpath:/applicationContext.xml";
        configLocations[1] = "classpath:/applicationContext-deployment.xml";
        configLocations[2] = "classpath:/applicationContext-admin.xml";
        configLocations[3] = "classpath*:pluginContext.xml";
        ClassPathXmlApplicationContext cpxa = new ClassPathXmlApplicationContext(configLocations);
        return cpxa;
    }
}
