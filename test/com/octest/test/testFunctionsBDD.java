package com.octest.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.mysql.cj.xdevapi.Statement;
import com.octest.bdd.functionsBDD;
import com.octest.beans.Livre;
import com.octest.beans.nbLivre;

class testFunctionsBDD {
	Connection connexion;

	@Test
	void testConnexion() {
		
		functionsBDD bdd = new functionsBDD();
		
		String verifWorking = bdd.connexion("dayvin30@gmail.com", "55555");
		assertEquals("true", verifWorking);
		
		String verifNotWorking = bdd.connexion("toto@gmail.com", "12548");
		assertEquals("false", verifNotWorking);
		
	}
	
	@Test
	void testGetIdExemplaire() {
		
		functionsBDD bdd = new functionsBDD();
		int verif = bdd.getIdExemplaireByISBN_bibliotheque(1965471532, "Bibliothèque municipale de Bordeaux");
		
		assertEquals(1, verif);
		
		
	}
	


}
