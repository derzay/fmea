package org.greg.fmea.helpers;

import org.greg.fmea.dao.DetStyleDAO;
import org.greg.fmea.dao.DetectabilityDAO;
import org.greg.fmea.utils.*;

public class DetsHelper extends HttpHelper {

	@Override
	public View doView() {
		httpRequest.setAttribute("allDetStyles", DetStyleDAO.getAll());
		httpRequest.setAttribute("allDetGroups", DetectabilityDAO.getDetectabilityGroups());
		return (new View(C.FORWARD, C.DETS_JSP));
	}

	@Override
	public View doCreate() {
		int value = Integer.parseInt(httpRequest.getParameter("value"));
		int detStyleId = Integer.parseInt(httpRequest.getParameter("detStyleId"));
		String description = httpRequest.getParameter("description");
		
		int rows = DetectabilityDAO.addDetectability(value, description, detStyleId);
		
		if (rows == 1) {
			setSessionMsg("Detectability (" + value + ", " + description + ") added successfully.", 1);
		} else {
			setSessionMsg("Error: Detectability (" + value + ", " + description + ") NOT added successfully.", 0);
		}

		return (new View(C.REDIRECT, C.DETS_SERVLET));
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
		int rows = DetectabilityDAO.deleteDetectability(id);
		
		if (rows == 1) {
			setSessionMsg("Detectability " + id + " removed successfully.", 1);
		} else {
			setSessionMsg("Error: Detectability " + id + " NOT removed successfully.", 0);
		}

		return (new View(C.REDIRECT, C.DETS_SERVLET));
	}

}
