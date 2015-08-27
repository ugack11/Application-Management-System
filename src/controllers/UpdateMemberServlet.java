package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Profile;
import dbHelpers.ReadRecord;



/**
 * Servlet implementation class UpdateItemServlet
 */
@WebServlet(description = "Controller which starts the actual book update to the database", urlPatterns = { "/updateMember" })
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberServlet() {
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
		
		ReadRecord rr = new ReadRecord("application", "root", "", username);
		rr.doRead();
		Profile userProfile = rr.getProfile();
		
		request.setAttribute("username", userProfile.getUsername());
		request.setAttribute("password", userProfile.getPassword());
		request.setAttribute("type", userProfile.getType());
		request.setAttribute("fName", userProfile.getFirstName());
		request.setAttribute("lName", userProfile.getLastName());
		request.setAttribute("sex", userProfile.getSex());
		request.setAttribute("birthdate", userProfile.getBirthDate());
		request.setAttribute("maddress", userProfile.getMAddress());
		request.setAttribute("city", userProfile.getCity());
		request.setAttribute("state", userProfile.getState());
		request.setAttribute("zipcode", userProfile.getZipCode());
		request.setAttribute("telephone", userProfile.getTelephone());
		request.setAttribute("email", userProfile.getEmail());
				
		String url = "/updateMember.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
