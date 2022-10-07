package com.octest.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.octest.beans.Livre;

class testLivre {

	@Test
	void testGetID() {
		
		Livre mesLivres = new Livre();
		mesLivres.setAuteur("Victor Hugo");
		mesLivres.setId(0);
		mesLivres.setDate("22/02/1973");
		mesLivres.setEdition("hatier");
		mesLivres.setTitre("Les misérables");
		
		assertEquals(0, mesLivres.getId());
		
	}
	
	@Test
	void testGetTitre() {
		
		Livre mesLivres = new Livre();
		mesLivres.setAuteur("Victor Hugo");
		mesLivres.setId(0);
		mesLivres.setDate("22/02/1973");
		mesLivres.setEdition("hatier");
		mesLivres.setTitre("Les misérables");
		
		assertEquals("Les misérables", mesLivres.getTitre());
		
	}
	
	@Test
	void testGetAuteur() {
		
		Livre mesLivres = new Livre();
		mesLivres.setAuteur("Victor Hugo");
		mesLivres.setId(0);
		mesLivres.setDate("22/02/1973");
		mesLivres.setEdition("hatier");
		mesLivres.setTitre("Les misérables");
		
		assertEquals("Victor Hugo", mesLivres.getAuteur());
		
	}
	
	@Test
	void testGetDate() {
		
		Livre mesLivres = new Livre();
		mesLivres.setAuteur("Victor Hugo");
		mesLivres.setId(0);
		mesLivres.setDate("22/02/1973");
		mesLivres.setEdition("hatier");
		mesLivres.setTitre("Les misérables");
		
		assertEquals("22/02/1973", mesLivres.getDate());
		
	}
	
	@Test
	void testGetEdition() {
		
		Livre mesLivres = new Livre();
		mesLivres.setAuteur("Victor Hugo");
		mesLivres.setId(0);
		mesLivres.setDate("22/02/1973");
		mesLivres.setEdition("hatier");
		mesLivres.setTitre("Les misérables");
		
		assertEquals("hatier", mesLivres.getEdition());
		
	}

}
