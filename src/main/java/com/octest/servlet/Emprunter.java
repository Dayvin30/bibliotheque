package com.octest.servlet;
import com.octest.beans.Exemplaire;
import com.octest.beans.Livre;
import com.octest.beans.nbLivre;
import com.octest.bdd.functionsBDD;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class Emprunter
 */
public class Emprunter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Emprunter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String isbn = request.getParameter("isbn");
		request.setAttribute("isbn", isbn);
		
		String titre = request.getParameter("titre");
		request.setAttribute("titre", titre);
		
		String auteur = request.getParameter("auteur");
		request.setAttribute("auteur", auteur);
		
		String edition = request.getParameter("edition");
		request.setAttribute("edition", edition);
		
		String nbexemplaire = request.getParameter("nbexemplaire");
		request.setAttribute("nbexemplaire", nbexemplaire);
		
		
		
		
		
		
		
		
		
		functionsBDD bdd = new functionsBDD();
		List<Livre> listelivres = new ArrayList<Livre>();
		listelivres=bdd.listerLivres();
		request.setAttribute("ListeLivre", listelivres);
		
		
		
		int i=0;
		
		
		List<nbLivre> nbLivre = new ArrayList<nbLivre>();
		nbLivre = bdd.nbExemplaireByID();
		
		request.setAttribute("nbLivre", nbLivre);
		


		
		
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Emprunter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
