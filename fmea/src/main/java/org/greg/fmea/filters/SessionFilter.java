package org.greg.fmea.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.greg.fmea.utils.C;

public class SessionFilter implements Filter {

	private ArrayList<String> urlExceptionList;
	
	public void destroy() {
	}
	
	/**
	 * doFilter: Determine whether a user login is required.
	 * 
	 * If there is no session, or if there is no User object in the session,
	 * redirect to the login page.
	 * 
	 * Some resources, such as js/css/image files, do not require authorization to render.
	 */
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String url = request.getServletPath();
		System.out.println("\n*** getServletPath(): " + url);
		System.out.println("    uri: " + request.getRequestURI());
		
		boolean urlException = urlExceptionList.contains(url);
		HttpSession session = request.getSession(false);
		
		if (urlException || ((null != session) && (null != session.getAttribute("user")))) {
			System.out.println("    chaining to " + request.getRequestURI());
			chain.doFilter(req, res);
		} else {
			System.out.println("    sending redirect to " + request.getContextPath() + C.LOGIN_JSP);
			response.sendRedirect(request.getContextPath() + C.LOGIN_JSP);
		}
	}

	public void init(FilterConfig config) throws ServletException {
		System.out.println("*** SessionFilter init()");
		String urls = config.getInitParameter("avoid-urls");
		StringTokenizer token = new StringTokenizer(urls, ",");

		urlExceptionList = new ArrayList<String>();

		while (token.hasMoreTokens()) {
			urlExceptionList.add(token.nextToken());
		}
	}
}