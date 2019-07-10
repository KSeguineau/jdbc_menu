package Diginamic.JDBC_menu;

import Diginamic.JDBC_menu.manager.ClientInterfaceManger;

/**
 * point d’entrée de l’application
 * 
 * @author Kevin.s
 *
 */
public class Main {

	/**
	 * Constructeur
	 * 
	 */
	public Main() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ClientInterfaceManger man = new ClientInterfaceManger();
		man.administrationMenu();

	}

}
