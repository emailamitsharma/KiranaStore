/**
 * 
 */
package com.retail.kiranaStore.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.retail.kiranaStore.configuration.WebConfigParametersHolder;

@Configuration
public class WebProperties {
	
	public enum WebProperty{
		
		app_url("app.url"),
		app_title("app.title");
	
		
		private String propertyName;
		
		WebProperty(String propName){
			this.propertyName = propName;
		}
		
		WebProperty(){
			this.propertyName = this.toString();
		}		
		
		public String getPropertyName(){
			return this.propertyName;
		}

	}
	
	@Autowired
	private Environment env;

	@Bean
	public WebConfigParametersHolder webConfigParameters(){
		Map<String, String> map = new HashMap<>();
		for(WebProperty prop:WebProperty.values())
			map.put(prop.toString(), env.getProperty(prop.getPropertyName()));
		
		WebConfigParametersHolder bean = new WebConfigParametersHolder();
		bean.setConfigParameterMap(map);
		return bean;
	}
	
}
