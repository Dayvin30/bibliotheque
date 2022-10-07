package com.octest.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class EmprunterForm
 */
public class EmprunterForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmprunterForm() {
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
		
		String date = request.getParameter("date");
		request.setAttribute("date", date);
		
		String dateFin = request.getParameter("dateFin");
		request.setAttribute("dateFin", dateFin);
		
		
		String nbexemplaire = request.getParameter("nbexemplaire");
		request.setAttribute("nbexemplaire", nbexemplaire);
		this.getServletContext().getRequestDispatcher("/WEB-INF/EmprunterForm.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		String dateFin = request.getParameter("dateFin");
		request.setAttribute("dateFin", dateFin);
		
		String isbn = request.getParameter("isbn");
		request.setAttribute("isbn", isbn);
		
		String bibliotheque = request.getParameter("bibliotheque");
		request.setAttribute("bibliotheque", bibliotheque);
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/EmprunterForm.jsp").forward(request, response);
		
	}

}
