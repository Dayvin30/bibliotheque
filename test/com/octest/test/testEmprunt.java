package com.octest.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.octest.beans.Emprunt;

class testEmprunt {

	@Test
	void testDate_debut() {
		
		Emprunt mesEmprunts = new Emprunt();
		mesEmprunts.setDate_debut("10/04/2022");
		mesEmprunts.setDate_fin("20/10/2022");
		mesEmprunts.setId(0);
		mesEmprunts.setNom("Victor");
		mesEmprunts.setPrenom("Hugo");
		mesEmprunts.setTitre("Les misérables");
		
		assertEquals("10/04/2022", mesEmprunts.getDate_debut());
		
		
		
		
	}
	
	@Test
	void testDate_fin() {
		
		Emprunt mesEmprunts = new Emprunt();
		mesEmprunts.setDate_debut("10/04/2022");
		mesEmprunts.setDate_fin("20/10/2022");
		mesEmprunts.setId(0);
		mesEmprunts.setNom("Victor");
		mesEmprunts.setPrenom("Hugo");
		mesEmprunts.setTitre("Les misérables");
		
		assertEquals("20/10/2022", mesEmprunts.getDate_fin());
		
		
		
		
	}
	
	@Test
	void testId() {
		
		Emprunt mesEmprunts = new Emprunt();
		mesEmprunts.setDate_debut("10/04/2022");
		mesEmprunts.setDate_fin("20/10/2022");
		mesEmprunts.setId(0);
		mesEmprunts.setNom("Victor");
		mesEmprunts.setPrenom("Hugo");
		mesEmprunts.setTitre("Les misérables");
		
		assertEquals(0, mesEmprunts.getId());
		
		
		
		
	}
	
	@Test
	void testNom() {
		
		Emprunt mesEmprunts = new Emprunt();
		mesEmprunts.setDate_debut("10/04/2022");
		mesEmprunts.setDate_fin("20/10/2022");
		mesEmprunts.setId(0);
		mesEmprunts.setNom("Victor");
		mesEmprunts.setPrenom("Hugo");
		mesEmprunts.setTitre("Les misérables");
		
		assertEquals("Victor", mesEmprunts.getNom());
		
		
		
		
	}
	
	@Test
	void testPrenom() {
		
		Emprunt mesEmprunts = new Emprunt();
		mesEmprunts.setDate_debut("10/04/2022");
		mesEmprunts.setDate_fin("20/10/2022");
		mesEmprunts.setId(0);
		mesEmprunts.setNom("Victor");
		mesEmprunts.setPrenom("Hugo");
		mesEmprunts.setTitre("Les misérables");
		
		assertEquals("Hugo", mesEmprunts.getPrenom());
		
		
		
		
	}
	
	@Test
	void testTitre() {
		
		Emprunt mesEmprunts = new Emprunt();
		mesEmprunts.setDate_debut("10/04/2022");
		mesEmprunts.setDate_fin("20/10/2022");
		mesEmprunts.setId(0);
		mesEmprunts.setNom("Victor");
		mesEmprunts.setPrenom("Hugo");
		mesEmprunts.setTitre("Les misérables");
		
		assertEquals("Les misérables", mesEmprunts.getTitre());
		
		
		
		
	}

}
