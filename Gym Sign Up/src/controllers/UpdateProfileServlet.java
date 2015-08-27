package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Profile;
import dbHelpers.UpdateQuery;

/**
 * Servlet implementation class UpdateItemServlet
 */
@WebServlet(description = "Controller which starts the actual book update to the database", urlPatterns = { "/updateProfile" })
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfileServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String sex = request.getParameter("sex");
		String birthdate = request.getParameter("birthdate");
		String maddress = request.getParameter("maddress");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		int zipcode = Integer.parseInt(request.getParameter("zipcode"));
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		
		
				
		Profile profile = new Profile();
		profile.setUsername(username);
		profile.setPassword(password);
		profile.setType(type);
		profile.setFirstName(fName);
		profile.setLastName(lName);
		profile.setSex(sex);
		profile.setBirthDate(birthdate);
		profile.setMAddress(maddress);
		profile.setCity(city);
		profile.setState(state);
		profile.setZipCode(zipcode);
		profile.setTelephone(telephone);
		profile.setEmail(email);

		
		UpdateQuery uq = new UpdateQuery("application", "root", "");
		if(uq.doUpdate(profile) ==  true) {
			HttpSession session = request.getSession();
			session.setAttribute("profile", profile);
		}
		
		String url = "/settings";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
