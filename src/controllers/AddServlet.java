package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Profile;
import dbHelpers.AddQuery;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the data
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String type = request.getParameter("type");
		String sex = request.getParameter("sex");
		String birthdate = request.getParameter("birthdate");
		String maddress = request.getParameter("maddress");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		int zipcode = Integer.parseInt(request.getParameter("zipcode"));
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		//set up a book object
		Profile profile = new Profile();
		profile.setUsername(username);
		profile.setPassword(password);
		profile.setFirstName(fName);
		profile.setLastName(lName);
		profile.setType(type);
		profile.setSex(sex);
		profile.setBirthDate(birthdate);
		profile.setMAddress(maddress);
		profile.setCity(city);
		profile.setState(state);
		profile.setZipCode(zipcode);
		profile.setTelephone(telephone);
		profile.setEmail(email);
		//set up an addquery object
		AddQuery aq = new AddQuery("application","root","");
		
		//pass the book to addquery to add to the database
		aq.doAdd(profile);
		//pass execution control to the BrowseServlet
		String url = "/browse";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request,response);
	}

}
