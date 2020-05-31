package com.mitesh.springcloud.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter{

	private Logger logger=LoggerFactory.getLogger(ZuulLoggingFilter.class);
	
	/*
	 * This method is used to decide , if we want this filter to execute or not.
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}
	/*
	 * This is the method where , the actual logic of requests resides.
	 * Let's captures every request and log some of it's parameter 
	 */
	@Override
	public Object run() throws ZuulException {
		
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("request->{} request uri->{}",request,request.getRequestURI());		
		return null;
	}

	/*
	 * This method is used to set , when we want this filter to execute (Before or After the request, or 
	 *  in case of any error occurs)
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/*
	 * This method is used to set the priority for this Filter , In case we have multiple filters available 
	 */
	@Override
	public int filterOrder() {
		return 1;
	}

}
