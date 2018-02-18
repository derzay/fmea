package org.greg.fmea.servlets;

import java.io.IOException;
import org.greg.fmea.utils.*;
import org.greg.fmea.helpers.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApplicationMgr
 */
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		View view;
		String workflow = request.getServletPath();
		if ((workflow == null) || workflow.equals("/") || workflow.isEmpty()) workflow = ("/" + C.WF_HOME);
		workflow = workflow.substring(1);
		
		String action = request.getParameter(C.ACTION);
		if ((action == null) || action.isEmpty()) action = C.ACTION_VIEW;
		
		logRequestInfo(request, workflow, action);
		
		switch (workflow) {
		case C.WF_HOME:
			view = new View(C.FORWARD, C.HOME_JSP);
			break;
		case C.WF_APPS:
			view = (new AppsHelper()).execute(request, response, action);
			break;
		case C.WF_SEVS:
			view = (new SevsHelper()).execute(request, response, action);
			break;
		case C.WF_OCCS:
			view = (new OccsHelper()).execute(request, response, action);
			break;
		case C.WF_DETS:
			view = (new DetsHelper()).execute(request, response, action);
			break;
		case C.WF_PROFILE:
			view = new View(C.FORWARD, C.PROFILE_JSP);
			break;
		case C.WF_FMEA:
			view = new View(C.FORWARD, C.FMEA_JSP);
			break;
		case C.WF_RISKS:
			view = new View(C.FORWARD, C.RISKS_JSP);
			break;
		case C.WF_LOGIN:
			view = (new LoginHelper()).execute(request, response, action);
			break;
		case C.WF_LOGOUT:
			request.getSession().invalidate();
			view = new View(C.REDIRECT, C.HOME_SERVLET);
			break;
		default:
			view = new View(C.FORWARD, C.HOME_JSP);
			break;
		}
		
		// For read actions, forward directly to jsp, otherwise redirect to view
		// The redirect ensures that http parameters are cleared and not presented to the user
		// However forwards do not require an additional network request and thus are faster
		if (view.isForwardMode()) {
			System.out.println("    forwarding to: " + view.getResource());
			request.getRequestDispatcher(view.getResource()).forward(request, response);
		} else {
			System.out.println("    redirecting to: " + request.getContextPath() + view.getResource());
			response.sendRedirect(request.getContextPath() + view.getResource());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	protected void logRequestInfo(HttpServletRequest request, String workflow, String action) {
		System.out.println("\n--- context path: " + request.getContextPath());
		System.out.println("    uri: " + request.getRequestURI());
		System.out.println("    servlet path: " + request.getServletPath());
		System.out.println("    path info: " + request.getPathInfo());
		System.out.println("    method: " + request.getMethod());
		System.out.println("    workflow: " + workflow);
		System.out.println("    action: " + action);
	}
}
