package org.greg.fmea.helpers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.greg.fmea.utils.*;

public abstract class HttpHelper {

		public HttpServletResponse httpResponse;
		public HttpServletRequest httpRequest;
		
		public View execute(HttpServletRequest request, HttpServletResponse response, String action) {
			
			View userView;
			httpResponse = response;
			httpRequest  = request;
			
			switch (action) {
			case C.ACTION_VIEW:
				userView = doView();
				break;
			case C.ACTION_CREATE:
				userView = doCreate();
				break;
			case C.ACTION_READ:
				userView = doRead();
				break;
			case C.ACTION_UPDATE:
				userView = doUpdate();
				break;
			case C.ACTION_DELETE:
				userView = doDelete();
				break;
			default:
				userView = doView();
				break;
			}
			
			return (userView);
		}
		
		public abstract View doView();
		public abstract View doCreate();
		public abstract View doRead();
		public abstract View doUpdate();
		public abstract View doDelete();
		
		public void setSessionMsg(String msg, int result) {
			
			httpRequest.getSession().setAttribute("msg", msg);
			httpRequest.getSession().setAttribute("status", result);

		}
		
}
