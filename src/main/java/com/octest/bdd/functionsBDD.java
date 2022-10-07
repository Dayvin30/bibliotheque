package com.octest.bdd;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.octest.beans.Emprunt;
import com.octest.beans.Exemplaire;
import com.octest.beans.Livre;
import com.octest.beans.nbLivre;


public class functionsBDD {
	
	
	private Connection connexion;
	
	

	@Test
	void testConnexion() {
		
		functionsBDD bdd = new functionsBDD();
		
		String verifWorking = bdd.connexion("dayvin30@gmail.com", "55555");
		assertEquals("true", verifWorking);
		
		String verifNotWorking = bdd.connexion("toto@gmail.com", "12548");
		assertEquals("false", verifNotWorking);
		
	}
	public String connexion(String email, String password) {
		
		int i=0;
		java.sql.Statement statement = null;
		ResultSet resultat = null;
		
		String connect = "false";
loadDatabase();
		
		
try {
			
	connexion = DriverManager.getConnection("jdbc:mysql://eu-cdbr-west-03.cleardb.net/heroku_a336527e2b0c3fb","b2ea7648f925ee","7b4cd105");
			
			PreparedStatement pst = connexion.prepareStatement("select * from utilisateur where email = ? and mdp = ?");
			
			//execution de la requete
			pst.setString(1, email);
			pst.setString(2, password);
			
			resultat=pst.executeQuery();
			
			//recuperer les données
			while(resultat.next()) {
			
				i++;
				
				
				
			}
			
		} catch (SQLException e) {
			
		} finally {
			try {
				if(resultat != null)
					resultat.close();
				if(statement != null)
					statement.close();
				if(connexion != null)
					connexion.close();
				
			} catch (SQLException ignore) {
				// TODO: handle exception
			}
			
		}
		if(i>0) {
			
			connect = "true";
			
		}
		return(connect);
}


		
		
	
	
	
	
	public List<Livre> listerLivres(){
		
		
		
		List<Livre> livres = new ArrayList <Livre>(); 
		
		
	
		
		//connexion a la bdd
		
		
		
			java.sql.Statement statement = null;
			ResultSet resultat = null;
		
		loadDatabase();
		
		try {
			
			connexion = DriverManager.getConnection("jdbc:mysql://eu-cdbr-west-03.cleardb.net/heroku_a336527e2b0c3fb","b2ea7648f925ee","7b4cd105");
			
			statement = connexion.createStatement();
			
			//execution de la requete
			resultat = statement.executeQuery("Select livre.isbn, auteur.nom, auteur.prenom, titre, date_publication, editeur.nom from auteur, livre_auteur, livre, editeur \r\n"
					+ "where \r\n"
					+ "livre.editeur_id = editeur.id\r\n"
					+ "AND\r\n"
					+ "auteur.id = livre_auteur.auteur_id\r\n"
					+ "AND\r\n"
					+ "livre_auteur.isbn = livre.isbn order by livre.isbn");
			
			//recuperer les données
			while(resultat.next()) {
				int id = resultat.getInt("livre.isbn");
				String nom_auteur = resultat.getString("auteur.nom");
				String prenom_auteur = resultat.getString("auteur.prenom");
				String titre = resultat.getString("titre");
				String date = resultat.getString("date_publication");
				String editeur = resultat.getString("editeur.nom");
				Livre livre = new Livre();
				livre.setId(id);
				livre.setAuteur(prenom_auteur + " " + nom_auteur);
				livre.setEdition(editeur);
				livre.setTitre(titre);
				livre.setDate(date);
				
				livres.add(livre);
				
			}
			
		} catch (SQLException e) {
			
		} finally {
			try {
				if(resultat != null)
					resultat.close();
				if(statement != null)
					statement.close();
				if(connexion != null)
					connexion.close();
				
			} catch (SQLException ignore) {
				// TODO: handle exception
			}
			
		}
		return livres;
	}
	
	
	public void loadDatabase() {
		//connexion a la bdd
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e1) {
				}
				try {
					 connexion = DriverManager.getConnection("jdbc:mysql://eu-cdbr-west-03.cleardb.net/heroku_a336527e2b0c3fb","b2ea7648f925ee","7b4cd105");
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}	
	}
	
	
	
public List<nbLivre> nbExemplaireByID() {
		
	List<nbLivre> nbLivres = new ArrayList<nbLivre>();
		int i=0;
		java.sql.Statement statement = null;
		ResultSet resultat = null;
		
		
loadDatabase();
		
		
try {
			
	connexion = DriverManager.getConnection("jdbc:mysql://eu-cdbr-west-03.cleardb.net/heroku_a336527e2b0c3fb","b2ea7648f925ee","7b4cd105");
	
	statement = connexion.createStatement();
	
	resultat = statement.executeQuery("select livre.isbn, livre.titre, auteur.nom, auteur.prenom, editeur.nom, livre.date_publication, count(exemplaire.id) as nbexemplaire from exemplaire, livre, auteur, livre_auteur, editeur where livre.isbn = livre_auteur.isbn AND livre_auteur.auteur_id = auteur.id AND editeur.id=livre.editeur_id AND exemplaire.isbn=livre.isbn and exemplaire.id not in(SELECT pret.exemplaire_id from pret where pret.date_fin>=now()) AND livre.isbn=exemplaire.isbn group by livre.titre order by livre.titre;");
			
			//execution de la requete
			
			
	
			
			//recuperer les données
			while(resultat.next()) {
				
				nbLivre nbLivre = new nbLivre();
				
				int id = resultat.getInt("livre.isbn");
				String titre = resultat.getString("livre.titre");
				String auteur = resultat.getString("auteur.nom") + " " + resultat.getString("auteur.prenom");
				String editeur = resultat.getString("editeur.nom");
				String date = resultat.getString("livre.date_publication");
				int count = resultat.getInt("nbexemplaire");
				
				nbLivre.setIsbn(id);
				nbLivre.setAuteur(auteur);
				nbLivre.setDate(date);
				nbLivre.setEdition(editeur);
				nbLivre.setNbexemplaire(count);
				nbLivre.setTitre(titre);
				
				nbLivres.add(nbLivre);
				
				
				
				
			}
			
		} catch (SQLException e) {
			
		} finally {
			try {
				if(resultat != null)
					resultat.close();
				if(statement != null)
					statement.close();
				if(connexion != null)
					connexion.close();
				
			} catch (SQLException ignore) {
				// TODO: handle exception
			}
			
		}
		
		return(nbLivres);
 
}


public void emprunterLivre(String dateDebut, String dateFin, String renouvele, int idUtilisateur, int idExemplaire) {
	
	java.sql.Statement statement = null;
	ResultSet resultat = null;
	loadDatabase();
	
	try {
		
		connexion = DriverManager.getConnection("jdbc:mysql://eu-cdbr-west-03.cleardb.net/heroku_a336527e2b0c3fb","b2ea7648f925ee","7b4cd105");
				
				PreparedStatement pst = connexion.prepareStatement("insert into pret (date_debut, date_fin, renouvele, utilisateur_id, exemplaire_id) values (?, ?, ?, ?, ?)");
				
				//execution de la requete
				pst.setString(1, dateDebut);
				pst.setString(2, dateFin);
				pst.setString(3, renouvele);
				pst.setInt(4, idUtilisateur);
				pst.setInt(5, idExemplaire);
				
				
				pst.executeUpdate();
				
				//recuperer les données
	
				
			} catch (SQLException e) {
				
			} finally {
				try {
					if(resultat != null)
						resultat.close();
					if(statement != null)
						statement.close();
					if(connexion != null)
						connexion.close();
					
				} catch (SQLException ignore) {
					// TODO: handle exception
				}
				
			}

	
	

	
	
}



public int getIdExemplaireByISBN_bibliotheque(int isbn, String bibliotheque){
	
	
	java.sql.Statement statement = null;
	ResultSet resultat = null;
	loadDatabase();
	int id=0;
	
	
	try {
		
		connexion = DriverManager.getConnection("jdbc:mysql://eu-cdbr-west-03.cleardb.net/heroku_a336527e2b0c3fb","b2ea7648f925ee","7b4cd105");
				
				PreparedStatement pst = connexion.prepareStatement("select id from exemplaire where isbn = ? and bibliotheque = ?");
				
				//execution de la requete
				pst.setInt(1, isbn);
				pst.setString(2, bibliotheque);
				
				resultat=pst.executeQuery();
				
				//recuperer les données
				while(resultat.next()) {
				
					id = resultat.getInt("id");
				
					
				}
				
			} catch (SQLException e) {
				
			} finally {
				try {
					if(resultat != null)
						resultat.close();
					if(statement != null)
						statement.close();
					if(connexion != null)
						connexion.close();
					
				} catch (SQLException ignore) {
					// TODO: handle exception
				}
				
			}
	return id;


}



public List <Emprunt> ListerEmpruntByEmail(String email){
	
	List <Emprunt> MesEmprunts = new ArrayList <Emprunt>();
	
	java.sql.Statement statement = null;
	ResultSet resultat = null;
	
	loadDatabase();
	
	try {
		
		connexion = DriverManager.getConnection("jdbc:mysql://eu-cdbr-west-03.cleardb.net/heroku_a336527e2b0c3fb","b2ea7648f925ee","7b4cd105");
				
				PreparedStatement pst = connexion.prepareStatement("select pret.id, livre.titre, auteur.nom, auteur.prenom, pret.date_debut, pret.date_fin from livre, livre_auteur, auteur, pret, exemplaire where livre.isbn = livre_auteur.isbn AND livre_auteur.auteur_id = auteur.id AND livre.isbn = exemplaire.isbn AND pret.exemplaire_id = exemplaire.id and pret.utilisateur_id = (select distinct pret.utilisateur_id from pret, utilisateur where pret.utilisateur_id = utilisateur.id and utilisateur.email=?)");
				
				//execution de la requete
				pst.setString(1, email);

				
				resultat=pst.executeQuery();
				
				//recuperer les données
				while(resultat.next()) {
					
					int id = resultat.getInt("id");
					String titre = resultat.getString("livre.titre");
					String nom_auteur = resultat.getString("auteur.nom");
					String prenom_auteur = resultat.getString("auteur.prenom");
					String date_debut = resultat.getString("pret.date_debut");
					String date_fin = resultat.getString("pret.date_fin");
					
					Emprunt emprunt = new Emprunt();
					
					emprunt.setId(id);
					emprunt.setDate_debut(date_debut);
					emprunt.setDate_fin(date_fin);
					emprunt.setNom(nom_auteur);
					emprunt.setPrenom(prenom_auteur);
					emprunt.setTitre(titre);
					MesEmprunts.add(emprunt);
					
				}
				
			} catch (SQLException e) {
				
			} finally {
				try {
					if(resultat != null)
						resultat.close();
					if(statement != null)
						statement.close();
					if(connexion != null)
						connexion.close();
					
				} catch (SQLException ignore) {
					// TODO: handle exception
				}
				
			}
	
	return(MesEmprunts);
}




public void prolongerLivreByID(String date_fin, int id) {
	
	
	java.sql.Statement statement = null;
	ResultSet resultat = null;
	
	loadDatabase();
		
	
	
	try {
		
		connexion = DriverManager.getConnection("jdbc:mysql://eu-cdbr-west-03.cleardb.net/heroku_a336527e2b0c3fb","b2ea7648f925ee","7b4cd105");
				
				PreparedStatement pst = connexion.prepareStatement("update pret set pret.date_fin = ? where pret.id = ?");
				
				//execution de la requete
				pst.setString(1, date_fin);
				pst.setInt(2, id);
				
				
				pst.executeUpdate();
				
				
				
			} catch (SQLException e) {
				
			} finally {
				try {
					if(resultat != null)
						resultat.close();
					if(statement != null)
						statement.close();
					if(connexion != null)
						connexion.close();
					
				} catch (SQLException ignore) {
					// TODO: handle exception
				}
				
			}

	
	

	

}








public String livreLePlusLu() {
	
	
	
	java.sql.Statement statement = null;
	ResultSet resultat = null;
	
	loadDatabase();
	int max=0;
	int min=9999;
	String livreLeMoinsLu="aucun";
	String livreLePlusLu="aucun";
	String statistiques="aucune statistiques";
	try {
		
		connexion = DriverManager.getConnection("jdbc:mysql://eu-cdbr-west-03.cleardb.net/heroku_a336527e2b0c3fb","b2ea7648f925ee","7b4cd105");
		
		statement = connexion.createStatement();
		
		resultat = statement.executeQuery("select count(livre.titre) as nombre , livre.titre from livre, pret, exemplaire where livre.isbn = exemplaire.isbn and exemplaire.id = pret.exemplaire_id group by titre;");
				
				//execution de la requete
				
				

				
				//recuperer les données
				while(resultat.next()) {

					
					int i = resultat.getInt("nombre");
					if(max<=i) {
						max=i;
						livreLePlusLu=resultat.getString("livre.titre");
						
					}
					
					
					
					
				}
				
			} catch (SQLException e) {
				
			} finally {
				try {
					if(resultat != null)
						resultat.close();
					if(statement != null)
						statement.close();
					if(connexion != null)
						connexion.close();
					
				} catch (SQLException ignore) {
					// TODO: handle exception
				}
				
			}
	
	
	
	
	
try {
		
		connexion = DriverManager.getConnection("jdbc:mysql://eu-cdbr-west-03.cleardb.net/heroku_a336527e2b0c3fb","b2ea7648f925ee","7b4cd105");
		
		statement = connexion.createStatement();
		
		resultat = statement.executeQuery("select count(livre.titre) as nombre , livre.titre from livre, pret, exemplaire where livre.isbn = exemplaire.isbn and exemplaire.id = pret.exemplaire_id group by titre;");
				
				//execution de la requete
				
				

				
				//recuperer les données
				while(resultat.next()) {

					
					int i = resultat.getInt("nombre");
					if(min>=i) {
						min=i;
						livreLeMoinsLu=resultat.getString("livre.titre");
						
					}
					
					
					
					
				}
				
			} catch (SQLException e) {
				
			} finally {
				try {
					if(resultat != null)
						resultat.close();
					if(statement != null)
						statement.close();
					if(connexion != null)
						connexion.close();
					
				} catch (SQLException ignore) {
					// TODO: handle exception
				}
				
			}

statistiques="Notre livre le plus lu est \"" + livreLePlusLu.toUpperCase() + "\" avec déja "+ String.valueOf(max) + " lecteurs qui ont emprunté ce livre !  Notre livre le moins lu est \"" +livreLeMoinsLu.toUpperCase() + "\" avec seulement " + String.valueOf(min) + " lecteur(s) qui ont emprunté ce livre.";	
	return(statistiques);
}







public String auteurLePlusLu() {
	
	
	
	java.sql.Statement statement = null;
	ResultSet resultat = null;
	
	loadDatabase();
	int max=0;
	int min=9999;
	String auteurLeMoinsLu="aucun";
	String auteurLePlusLu="aucun";
	String statistiques="aucune statistiques";
	try {
		
		connexion = DriverManager.getConnection("jdbc:mysql://eu-cdbr-west-03.cleardb.net/heroku_a336527e2b0c3fb","b2ea7648f925ee","7b4cd105");
		
		statement = connexion.createStatement();
		
		resultat = statement.executeQuery("select auteur.nom, auteur.prenom, count(auteur.nom) as nbAuteur from pret, exemplaire, livre, livre_auteur, auteur WHERE pret.exemplaire_id = exemplaire.id AND livre.isbn = exemplaire.isbn AND livre.isbn = livre_auteur.isbn AND livre_auteur.auteur_id=auteur.id group by auteur.nom;");
				
				//execution de la requete
				
				

				
				//recuperer les données
				while(resultat.next()) {

					
					int i = resultat.getInt("nbAuteur");
					if(max<=i) {
						max=i;
						auteurLePlusLu=resultat.getString("auteur.prenom").toUpperCase() + " " + resultat.getString("auteur.nom").toUpperCase();
						
					}
					
					
					
					
				}
				
			} catch (SQLException e) {
				
			} finally {
				try {
					if(resultat != null)
						resultat.close();
					if(statement != null)
						statement.close();
					if(connexion != null)
						connexion.close();
					
				} catch (SQLException ignore) {
					// TODO: handle exception
				}
				
			}
	
	
	
	
	
try {
		
		connexion = DriverManager.getConnection("jdbc:mysql://eu-cdbr-west-03.cleardb.net/heroku_a336527e2b0c3fb","b2ea7648f925ee","7b4cd105");
		
		statement = connexion.createStatement();
		
		resultat = statement.executeQuery("select auteur.nom, auteur.prenom, count(auteur.nom) as nbAuteur from pret, exemplaire, livre, livre_auteur, auteur WHERE pret.exemplaire_id = exemplaire.id AND livre.isbn = exemplaire.isbn AND livre.isbn = livre_auteur.isbn AND livre_auteur.auteur_id=auteur.id group by auteur.nom;");
				
				//execution de la requete
				
				

				
				//recuperer les données
				while(resultat.next()) {

					
					int i = resultat.getInt("nbAuteur");
					if(min>=i) {
						min=i;
						auteurLeMoinsLu=resultat.getString("auteur.prenom").toUpperCase() + " " + resultat.getString("auteur.nom").toUpperCase();
						
					}
					
					
					
					
				}
				
			} catch (SQLException e) {
				
			} finally {
				try {
					if(resultat != null)
						resultat.close();
					if(statement != null)
						statement.close();
					if(connexion != null)
						connexion.close();
					
				} catch (SQLException ignore) {
					// TODO: handle exception
				}
				
			}

statistiques="Notre auteur le plus lu est \"" + auteurLePlusLu + "\" avec déja "+ String.valueOf(max) + " lecteurs qui ont emprunté un de ses livres!  Notre auteur le moins lu est \"" + auteurLeMoinsLu + "\" avec seulement " + String.valueOf(min) + " lecteur(s) qui ont emprunté un de ses livres.";	
	return(statistiques);
}

















	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
