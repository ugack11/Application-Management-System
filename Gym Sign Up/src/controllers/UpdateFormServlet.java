package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.UpdateFormQuery;


/**
 * Servlet implementation class UpdateItemServlet
 */
@WebServlet(description = "Controller which starts the actual book update to the database", urlPatterns = { "/updateForm" })
public class UpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFormServlet() {
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
		
		
		
		
		UpdateFormQuery umq = new UpdateFormQuery("application", "root", "");
		umq.doUpdate(username, password, type, fName, lName, sex, birthdate, maddress, city, state, zipcode, telephone, email);

		String url = "/members";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
