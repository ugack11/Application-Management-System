package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbHelpers.LoginCheck;
import model.*;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet(
		description = "Controller for reading the profile table", 
		urlPatterns = { 
				"/LoginServlet", 
				"/login"
		})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private int loginAttempts;
	private String url;
	private Profile profile; 
	private String adminTestString = "admin";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");							//Get user input for Username
        String password = request.getParameter("password");							//Get user input for Password
		String account = request.getParameter("account");							//Either 'login' or 'create'
		String testVariable = "login";
		this.session = request.getSession();
		
		//String encryptPassword =  Integer.toString(password.hashCode());
		
		
		
        /*if(session.getAttribute("loginAttempts") == null){							//get the number of logins
            loginAttempts = 0;
        }*/
        
        if(loginAttempts > 2){														//exceeded logins
            String errorMessage = "<div><p>Error: Number of Login Attempts Exceeded</p></div>";
            request.setAttribute("errorMessage", errorMessage);
            url = "index.jsp";
        } else {
        	if(account.equals(testVariable)) {
				LoginCheck lc = new LoginCheck("application","root", "", username, password);
		
				if(lc.doCheck() == true) {
					
					profile = lc.getProfile();
					//this.session = request.getSession(); <-- called at the top to prevent "!" on dynamic web project.
					session.setAttribute("profile", profile);
					if(profile.getType().equals(adminTestString)){url = "/browse";} else {url = "/settings";}
				} else {
					url = "/index.jsp";
					
					//track login attempts (combats: brute force attacks)
		        	//session.setAttribute("loginAttempts", loginAttempts++);
					loginAttempts++;
		        	String errorMessage = "<div><p>Error: Unrecognized Username or Password, You have " + (3-loginAttempts) + " Login Attempts Left</p></div>";
		        	request.setAttribute("errorMessage", errorMessage);
				}
			
			} else {
				
				url = "/AddAccountServlet";
			}
        }
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}