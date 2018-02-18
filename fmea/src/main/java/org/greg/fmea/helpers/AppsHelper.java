package org.greg.fmea.helpers;

import org.greg.fmea.dao.ApplicationDAO;
import org.greg.fmea.utils.*;

public class AppsHelper extends HttpHelper {

	@Override
	public View doView() {
		httpRequest.setAttribute("allApps", ApplicationDAO.getAll());
		return (new View(C.FORWARD, C.APPS_JSP));
	}

	@Override
	public View doCreate() {
		String app = httpRequest.getParameter("name");
		int rows = ApplicationDAO.addApplication(app);
		
		if (rows == 1) {
			setSessionMsg("Application " + app + " added successfully.", 1);
		} else {
			setSessionMsg("Error: Application " + app + " NOT added successfully.", 0);
		}

		return (new View(C.REDIRECT, C.APPS_SERVLET));
	}

	@Override
	public View doRead() {

		return (doView());
	}

	@Override
	public View doUpdate() {
	
		return null;
	}

	@Override
	public View doDelete() {

		int id = Integer.parseInt(httpRequest.getParameter("id"));
		int rows = ApplicationDAO.deleteApplication(id);
		
		if (rows == 1) {
			setSessionMsg("Application " + id + " removed successfully.", 1);
		} else {
			setSessionMsg("Error: Application " + id + " NOT removed successfully.", 0);
		}

		return (new View(C.REDIRECT, C.APPS_SERVLET));
	}

}
