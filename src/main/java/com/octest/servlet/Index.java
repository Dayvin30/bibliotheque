package com.octest.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.octest.bdd.functionsBDD;

/**
 * Servlet implementation class Index
 */
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/Index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		request.setAttribute("email", email);
		
		String password = request.getParameter("password");
		request.setAttribute("login-password", email);
		
		functionsBDD bdd = new functionsBDD();
		
		String connexion = bdd.connexion(email, password);
		
		if (connexion=="true") {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Accueil.jsp");
	        rd.forward(request, response);
	        
		}else {
			
			String error ="Vos identifiants sont incorrects";
			request.setAttribute("error", error);
			this.getServletContext().getRequestDispatcher("/Index.jsp").forward(request, response);
		}
		

		
		HttpSession session = request.getSession();
		
		session.setAttribute("email", email);
	}

}
