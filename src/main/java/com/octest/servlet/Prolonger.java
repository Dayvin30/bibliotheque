package com.octest.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Prolonger
 */
public class Prolonger extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prolonger() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titre = request.getParameter("titre");
		request.setAttribute("titre", titre);
		
		String prenom = request.getParameter("prenom");
		request.setAttribute("prenom", prenom);
		
		String nom = request.getParameter("nom");
		request.setAttribute("nom", nom);
		
		String date_debut = request.getParameter("date_debut");
		request.setAttribute("date_debut", date_debut);
		
		String date_fin = request.getParameter("date_fin");
		request.setAttribute("date_fin", date_fin);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Prolonger.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String titre = request.getParameter("titre");
		request.setAttribute("titre", titre);
		
		String prenom = request.getParameter("prenom");
		request.setAttribute("prenom", prenom);
		
		String nom = request.getParameter("nom");
		request.setAttribute("nom", nom);
		
		String date_debut = request.getParameter("date_debut");
		request.setAttribute("date_debut", date_debut);
		
		String id = request.getParameter("id");
		request.setAttribute("id", id);

		
		String dateFin = request.getParameter("dateFin");
		request.setAttribute("date_fin", dateFin);
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Prolonger.jsp").forward(request, response);
	}

}
