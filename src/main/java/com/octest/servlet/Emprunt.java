package com.octest.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.octest.bdd.functionsBDD;

/**
 * Servlet implementation class Emprunt
 */
public class Emprunt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Emprunt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<com.octest.beans.Emprunt> MesEmprunts = new ArrayList<com.octest.beans.Emprunt>();
		functionsBDD bdd = new functionsBDD();
		
		HttpSession session = request.getSession(true);
		String email = (String) session.getAttribute("email");
		request.setAttribute("email", email);
		
		
		MesEmprunts = bdd.ListerEmpruntByEmail(email);
		request.setAttribute("MesEmprunts", MesEmprunts);
		
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Emprunt.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
