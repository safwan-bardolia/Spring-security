package com.luv2code.springsecurity.demo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/* no root config  classes for our project...
	 		only servlet config classes*/
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {DemoAppConfig.class} ;	//servlet config class which created earlier (which contain 'viewResolver', @EnableWebMvc etc)
	}

	@Override
	protected String[] getServletMappings() {
		 
		return new String[] {"/"};
	}

}
