package org.greg.fmea.helpers;

import org.greg.fmea.dao.OccStyleDAO;
import org.greg.fmea.dao.OccurrenceDAO;
import org.greg.fmea.utils.*;

public class OccsHelper extends HttpHelper {

	@Override
	public View doView() {
		httpRequest.setAttribute("allOccStyles", OccStyleDAO.getAll());
		httpRequest.setAttribute("allOccGroups", OccurrenceDAO.getOccurrenceGroups());
		return (new View(C.FORWARD, C.OCCS_JSP));
	}

	@Override
	public View doCreate() {
		int value = Integer.parseInt(httpRequest.getParameter("value"));
		int occStyleId = Integer.parseInt(httpRequest.getParameter("occStyleId"));
		String description = httpRequest.getParameter("description");
		
		int rows = OccurrenceDAO.addOccurrence(value, description, occStyleId);
		
		if (rows == 1) {
			setSessionMsg("Occurrence (" + value + ", " + description + ") added successfully.", 1);
		} else {
			setSessionMsg("Error: Occurrence (" + value + ", " + description + ") NOT added successfully.", 0);
		}

		return (new View(C.REDIRECT, C.OCCS_SERVLET));
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
		int rows = OccurrenceDAO.deleteOccurrence(id);
		
		if (rows == 1) {
			setSessionMsg("Occurrence " + id + " removed successfully.", 1);
		} else {
			setSessionMsg("Error: Occurrence " + id + " NOT removed successfully.", 0);
		}

		return (new View(C.REDIRECT, C.OCCS_SERVLET));
	}

}
