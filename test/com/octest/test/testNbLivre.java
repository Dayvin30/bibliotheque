package com.octest.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.octest.beans.Livre;
import com.octest.beans.nbLivre;

class testNbLivre {

	@Test
	void testGetID() {
		
		nbLivre mesLivres = new nbLivre();
		mesLivres.setAuteur("Victor Hugo");
		mesLivres.setIsbn(0);
		mesLivres.setDate("22/02/1973");
		mesLivres.setEdition("hatier");
		mesLivres.setTitre("Les misérables");
		mesLivres.setNbexemplaire(3);
		
		assertEquals(0, mesLivres.getIsbn());
		
	}
	
	@Test
	void testGetTitre() {
		
		nbLivre mesLivres = new nbLivre();
		mesLivres.setAuteur("Victor Hugo");
		mesLivres.setIsbn(0);
		mesLivres.setDate("22/02/1973");
		mesLivres.setEdition("hatier");
		mesLivres.setTitre("Les misérables");

		
		assertEquals("Les misérables", mesLivres.getTitre());
		
	}
	
	@Test
	void testGetAuteur() {
		
		nbLivre mesLivres = new nbLivre();
		mesLivres.setAuteur("Victor Hugo");
		mesLivres.setIsbn(0);
		mesLivres.setDate("22/02/1973");
		mesLivres.setEdition("hatier");
		mesLivres.setTitre("Les misérables");
		
		assertEquals("Victor Hugo", mesLivres.getAuteur());
		
	}
	
	@Test
	void testGetDate() {
		
		nbLivre mesLivres = new nbLivre();
		mesLivres.setAuteur("Victor Hugo");
		mesLivres.setIsbn(0);
		mesLivres.setDate("22/02/1973");
		mesLivres.setEdition("hatier");
		mesLivres.setTitre("Les misérables");
		
		assertEquals("22/02/1973", mesLivres.getDate());
		
	}
	
	@Test
	void testGetEdition() {
		
		nbLivre mesLivres = new nbLivre();
		mesLivres.setAuteur("Victor Hugo");
		mesLivres.setIsbn(0);
		mesLivres.setDate("22/02/1973");
		mesLivres.setEdition("hatier");
		mesLivres.setTitre("Les misérables");
		
		assertEquals("hatier", mesLivres.getEdition());
		
	}
	@Test
	void testGetNbExemplaire() {
		
		nbLivre mesLivres = new nbLivre();
		mesLivres.setAuteur("Victor Hugo");
		mesLivres.setIsbn(0);
		mesLivres.setDate("22/02/1973");
		mesLivres.setEdition("hatier");
		mesLivres.setTitre("Les misérables");
		mesLivres.setNbexemplaire(3);
		
		assertEquals(3, mesLivres.getNbexemplaire());

	
	}
}
