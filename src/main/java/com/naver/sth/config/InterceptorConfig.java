package com.naver.sth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.naver.sth.interceptors.LogingCheckInterceptor;

//import com.naver.sth.interceptors.TestInterceptor;
import com.naver.sth.interceptors.WriterCheckInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{

	//@Autowired
	//private TestInterceptor testInterceptor;
	@Autowired
	private LogingCheckInterceptor checkInterceptor;
	@Autowired
	private WriterCheckInterceptor writerCheckInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(checkInterceptor)
		.addPathPatterns("/member/*")
		.addPathPatterns("/qna/*")
		.excludePathPatterns("/qna/list")
		.excludePathPatterns("/member/login","/member/join");
		
		registry.addInterceptor(writerCheckInterceptor)
		.addPathPatterns("/notice/update","/qna/update");
		
		
		
		
		//적용할 인터셉터를 등록 하는것
		//registry.addInterceptor(testInterceptor)
		
		//인터셉터를 사용할 URL 패턴 작성 
		//.addPathPatterns("/notice/*","/qna/*")
		
		//제외하는 것 
		//.excludePathPatterns("/notice/detail");
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
