package org.greg.fmea.helpers;

import org.greg.fmea.beans.User;
import org.greg.fmea.dao.UserDAO;
import org.greg.fmea.utils.*;

public class LoginHelper extends HttpHelper {

	@Override
	public View doView() {
		String username = httpRequest.getParameter("username");
		String pwd = httpRequest.getParameter("password");
		String msg;
		
		boolean authenticated = false;
		
		User user = UserDAO.getByUsername(username);
		if (null == user) {
			msg = "Error: User (" + username + ") unknown.";
		} else {
			if (!user.getPassword().equals(pwd)) {
				msg = "Error:  Password incorrect.";
			} else {
				msg = user.getUsername() + " logged in successfully.";
				authenticated = true;
				httpRequest.getSession().setAttribute("user", user);
			}
		}
		
		if (authenticated) {
			setSessionMsg(msg, 1);
			return (new View(C.REDIRECT, C.HOME_SERVLET));
		} else {
			setSessionMsg(msg, 0);
			return (new View(C.REDIRECT, C.LOGIN_JSP));
		}

	}

	@Override
	public View doCreate() {
		
		return (doView());
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

		return (doView());
	}

}
