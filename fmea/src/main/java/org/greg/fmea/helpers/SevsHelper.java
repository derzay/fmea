package org.greg.fmea.helpers;

import org.greg.fmea.dao.SevStyleDAO;
import org.greg.fmea.dao.SeverityDAO;
import org.greg.fmea.utils.*;

public class SevsHelper extends HttpHelper {

	@Override
	public View doView() {
		httpRequest.setAttribute("allSevStyles", SevStyleDAO.getAll());
		httpRequest.setAttribute("allSevGroups", SeverityDAO.getSeverityGroups());
		return (new View(C.FORWARD, C.SEVS_JSP));
	}

	@Override
	public View doCreate() {
		int value = Integer.parseInt(httpRequest.getParameter("value"));
		int sevStyleId = Integer.parseInt(httpRequest.getParameter("sevStyleId"));
		String description = httpRequest.getParameter("description");
		
		int rows = SeverityDAO.addSeverity(value, description, sevStyleId);
		
		if (rows == 1) {
			setSessionMsg("Severity (" + value + ", " + description + ") added successfully.", 1);
		} else {
			setSessionMsg("Error: Severity (" + value + ", " + description + ") NOT added successfully.", 0);
		}

		return (new View(C.REDIRECT, C.SEVS_SERVLET));
	}

	@Override
	public View doRead() {

		return (doView());
	}

	@Override
	public View doUpdate() {
	
		return (doView());
	}

	@Override
	public View doDelete() {

		int id = Integer.parseInt(httpRequest.getParameter("id"));
		int rows = SeverityDAO.deleteSeverity(id);
		
		if (rows == 1) {
			setSessionMsg("Severity " + id + " removed successfully.", 1);
		} else {
			setSessionMsg("Error: Severity " + id + " NOT removed successfully.", 0);
		}

		return (new View(C.REDIRECT, C.SEVS_SERVLET));
	}

}
