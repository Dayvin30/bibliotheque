package com.octest.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.octest.bdd.functionsBDD;

/**
 * Servlet implementation class Statistique
 */
public class Statistique extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Statistique() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		functionsBDD bdd = new functionsBDD();
		String statistiquesLivres = bdd.livreLePlusLu();
		request.setAttribute("statistiquesLivres", statistiquesLivres);
		
		String statistiquesAuteurs = bdd.auteurLePlusLu();
		request.setAttribute("statistiquesAuteurs", statistiquesAuteurs);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Statistique.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
