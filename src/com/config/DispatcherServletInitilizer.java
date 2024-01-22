package com.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;

public class DispatcherServletInitilizer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		Class[] configclasses = {config.class};
		return configclasses;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[]  {"/"};
	}
	
	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {

		// Optionally also set maxFileSize, maxRequestSize, fileSizeThreshold
		registration.setMultipartConfig(new MultipartConfigElement("D:\\AD_JAVA\\AlldataWithImage\\webapp\\WEB-INF\\Resources", 2097152, 4194304, 0));
	}


}
