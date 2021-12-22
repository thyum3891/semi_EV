package com.kh.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.kh.common.wrapper.EncryptPasswordWrapper;


@WebFilter(filterName = "encryptFilter", servletNames = {"login", "enroll", "updatePwd"}  )
public class EncryptFilter implements Filter {

    public EncryptFilter() {
    }
    
    @Override
	public void init(FilterConfig fConfig) throws ServletException {
	}
    
    @Override
	public void destroy() {
	}
    
    @Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	// request의 파라미터 값을 변경할 수 없기 때문에 RequestWrapper를 생성한다.
    	EncryptPasswordWrapper wrapper = new EncryptPasswordWrapper((HttpServletRequest)request);
    	
    	// request 대신에 생성한 wrapper를 객체를 넘겨준다.
		chain.doFilter(wrapper, response);
	}
}
