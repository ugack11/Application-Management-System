package controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Profile;
import dbHelpers.UploadQuery;

/**
 * Servlet implementation class ImageServlet
 */
@WebServlet("/UploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		HttpSession session = request.getSession();
		Profile profile = (Profile) session.getAttribute("profile");

		String username = profile.getUsername();

		Part filePart = request.getPart("file");
		InputStream filecontent = filePart.getInputStream();
		String path = session.getServletContext().getRealPath("/applications");
		String filename = getFilename(filePart);
		String fullPath = path + "/" + filename;
		copyStream(filecontent, fullPath);

		profile.setUsername(username);


		UploadQuery uq = new UploadQuery("application", "root", "", username);
		if(uq.doUpload(filename) ==  true) {
			profile.setApplication(filename);
			session.setAttribute("profile", profile);
		}

		System.out.println(profile.toString());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/application.jsp");
		dispatcher.forward(request, response);

	}

	/*
	 * Method: getFileName
	 * Purpose: extracts file name from the file part of the Multipart input
	 */
	private String getFilename(Part part) {
	    for (String cd : part.getHeader("content-disposition").split(";")) {
	    	 if (cd.trim().startsWith("filename")) {
	            String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
	            return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
	    	 }
	    }
	    return "hi";
	}

	/*
	 * Method: copyStrem
	 * Purpose: writes an inputStream to a location and file name specified
	 *          by the fullPath.
	 */
	  public static void copyStream(InputStream input, String fullPath)
		    throws IOException
		{
		    OutputStream output = new FileOutputStream(fullPath);
		    byte[] buffer = new byte[1024]; // Adjust if you want
		    int bytesRead;
		    while ((bytesRead = input.read(buffer)) != -1)
		    {
		        output.write(buffer, 0, bytesRead);
		    }
		    output.close();
		}


	// http://stackoverflow.com/questions/2422468/how-to-upload-files-to-server-using-jsp-servlet/2424824#2424824


}
