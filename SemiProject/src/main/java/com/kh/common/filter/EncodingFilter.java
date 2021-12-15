package com.kh.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


// 절대 인코딩을 전역으로 걸지 않는다!! => 속도 늦어진다. 학습 목적이라는 것을 염두해주세요.
@WebFilter(filterName = "encodingFilter", urlPatterns = "/*")
public class EncodingFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
//		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
//		if(httpServletRequest.getMethod().toUpperCase().equals("POST")) {
//			// post일때만 할때는 이곳에...
//		}
		
		request.setCharacterEncoding("UTF-8"); // 자원을 엄청 먹는 작업으로 주의해야한다!!
		response.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void destroy() {}
}
