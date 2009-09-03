/*
 * Copyright (C) 2005 Bryant Harris
 *
 * This library is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of the
 * License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA 
 */
package fr.cg95.cvq.platform;

import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanReference;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.RuntimeBeanReference;

/**
 * <p>Utility used by spring to dynamically <em>plug-in</em> beans into
 * <em>extension</em> beans.</p>
 * 
 * <p>Typical spring allows you to directly wire together components.  This
 * post processor will insert a bean definition into a {@link Set} based property
 * of another bean just before object creation.  This combined with springs
 * auto discovery of context files allows you to wire together components without
 * the original component's configuration getting modified.</p>
 * 
 * <h2>Example</h2>
 * Imagine a bean context with the following contents.  It defines a bean named
 * <em>extension.object</em> with a property <em>extProperty</em> that is
 * an empty set.
 * <pre><code>
 * <beans>
 *     <bean id="extension.object" class="some.class">
 *         <property name="extProperty">
 *	           <set>
 *	           <!-- properties typically added via plug-in mechanism -->
 *	           </set>
 *          </property>
 *     </bean>
 * </beans>
 * </code></pre>
 * 
 * Now imagine we want to wire in a bean reference to <em>extProperty</em> but
 * we don't want to modify this file.  We could define a seperate context file
 * as follows.  It defines the plug-in bean and uses an instance of
 * <code>PluginBeanFactoryPostProcessor</code> to wire in its reference.
 * <pre><code>
 * <beans>
 *     <bean class="platform.spring.PluginBeanFactoryPostProcessor">
 *	       <property name="extensionBeanName" value="extension.object" />
 *		   <property name="propertyName" value="extProperty" />
 *		   <property name="pluginBeanName" value="plugin" />
 *	   </bean>
 *
 *	   <bean id="plugin" class="some.class.AppropriateForExtProperty" />
 * </beans>
 * </code></pre>
 * 
 * <h2>Usage</h2>
 * This class assumes the usage of spring and its configuration should look
 * as follows:
 * <pre><code>
 *     <bean class="platform.spring.PluginBeanFactoryPostProcessor">
 *	       <property name="extensionBeanName" value="<em>bean with set based property</em>" />
 *		   <property name="propertyName" value="<em>set based property</em>" />
 *		   <property name="pluginBeanName" value="<em>bean to plugin</em>" />
 *	   </bean>
 * </code></pre>
 * @author bharris
 */
public class PluginBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	String extensionBeanName;
	String propertyName;
	String pluginBeanName;
	
	static Logger logger = Logger.getLogger(PluginBeanFactoryPostProcessor.class);
	
	/**
	 * The bean that is being extended (the bean with a {@link Set} based
	 * property.
	 * @param beanName Spring bean name.
	 */
	public void setExtensionBeanName(String beanName) {
		this.extensionBeanName = beanName;
	}

	/**
	 * The name of the {@link Set} property within the
	 * {@link #setExtensionBeanName(String) extension} bean.
	 * @param propertyName property name.
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	/**
	 * The name of the bean to plug-in to the extension bean's set property.
	 * @param pluginName The plugin bean's name.
	 */
	public void setPluginBeanName(String pluginName) {
		pluginBeanName = pluginName;
	}

	////////////////////////////////////////////////////////////////////////////
	// BeanFactoryPostProcessor method
	/*
	 * (non-Javadoc)
	 * @see org.springframework.beans.factory.config.BeanFactoryPostProcessor#postProcessBeanFactory(org.springframework.beans.factory.config.ConfigurableListableBeanFactory)
	 */
	public void postProcessBeanFactory(ConfigurableListableBeanFactory arg0)
			throws BeansException {
		logger.info("Plugging in " + pluginBeanName + " into bean:" + extensionBeanName + " property:" + propertyName);
		if ( extensionBeanName == null || !arg0.containsBeanDefinition(extensionBeanName) )
			throw new IllegalArgumentException("Cannot find bean " + extensionBeanName);
		
		BeanDefinition beanDef = arg0.getBeanDefinition(extensionBeanName);
		MutablePropertyValues propValues = beanDef.getPropertyValues();
		if ( propertyName == null || !propValues.contains(propertyName))
			throw new IllegalArgumentException("Cannot find property " + propertyName + " in bean " + extensionBeanName);
		PropertyValue pv = propValues.getPropertyValue(propertyName);
		Object prop = pv.getValue();
		if ( !(prop instanceof Set<?>))
			throw new IllegalArgumentException("Property " + propertyName +
					                           " in extension bean " + extensionBeanName +
					                           " is not an instanceof Set.");
			
		Set<BeanReference> l =
		    (Set<BeanReference>)pv.getValue();
		l.add(new RuntimeBeanReference(pluginBeanName));
	}
}
