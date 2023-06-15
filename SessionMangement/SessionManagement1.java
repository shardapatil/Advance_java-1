package com.day2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionManagementExample1
 */
@WebServlet("/SessionManagementExample1")
public class SessionManagementExample1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionManagementExample1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter write = response.getWriter();
		HttpSession session =request.getSession(true);
		int visitcount =1;
		String message =null;
		if(session.isNew())
		{
			message = "Welcome to CDAC...";
			session.setAttribute("count", visitcount);
		}
		else {
			message = "Welcome Again..";
			visitcount =(int) session.getAttribute("count");
			visitcount= visitcount+1;
			session.setAttribute("count",visitcount);
		}
		write.print("<h1>"+ message +"</h1>");
		write.print("\n");
		write.print("visit count " + visitcount);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
