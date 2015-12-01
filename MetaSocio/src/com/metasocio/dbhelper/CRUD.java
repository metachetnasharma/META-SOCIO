package com.metasocio.dbhelper;



public class CRUD {
	private static CRUD iCrud;

	private CRUD() {

	}

	public static CRUD getInstance() {

		if (iCrud == null) {
			iCrud = new CRUD();

		}
		return iCrud;
	}

	
	
	
	
	
	

	
}
