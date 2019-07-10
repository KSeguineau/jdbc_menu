package Diginamic.JDBC_menu.manager;

import java.util.List;
import java.util.Scanner;

import Diginamic.JDBC_menu.dao.MenuDao;
import Diginamic.JDBC_menu.model.Menu;

/**
 * permet de gerer les choix de l’utilisateur
 * 
 * @author Kevin.s
 *
 */
public class ClientInterfaceManger {

	/** sc : Scanner */
	private Scanner sc = new Scanner(System.in);
	/** menuDao : MenuDao */
	MenuDao menuDao = new MenuDao();

	/**
	 * Constructeur
	 * 
	 */
	public ClientInterfaceManger() {
	}

	/**
	 * menu d’administration
	 */
	public void administrationMenu() {

		boolean continuer = true;
		while (continuer) {
			List<Menu> listeMenu = menuDao.recupererAll();

			listeMenu.forEach(m -> System.out.println(m.toString()));

			System.out.println("1 - ajouter Menu");
			System.out.println("2 - modifier Menu");
			System.out.println("3 - supprimer Menu");
			System.out.println("0 - sortir");
			String choix = sc.nextLine();

			switch (choix) {
			case "1":
				ajouterMenu();
				break;
			case "2":
				modifierMenu();
				break;
			case "3":
				supprimerMenu();
				break;
			case "0":
				continuer = false;
				break;
			default:
				System.out.println("choix inconnu");
			}
		}
	}

	/**
	 * permet de supprimer un menu
	 */
	private void supprimerMenu() {
		System.out.println("nom du menu à supprimer:");
		String nom = sc.nextLine();
		menuDao.deleteMenu(nom);
	}

	/**
	 * permet de modifier un menu
	 */
	private void modifierMenu() {
		System.out.println("id du menu à modifier:");
		Integer id = Integer.parseInt(sc.nextLine());
		System.out.println("nom :");
		String nom = sc.nextLine();
		System.out.println("prix:");
		Double prix = Double.parseDouble(sc.nextLine());
		System.out.println("quantite:");
		Integer quantite = Integer.parseInt(sc.nextLine());
		System.out.println("description:");
		String description = sc.nextLine();

		Menu menu = new Menu(id, nom, prix, quantite, description);
		menuDao.updateMenu(menu);

	}

	/**
	 * permet d’ajouter un menu
	 */
	private void ajouterMenu() {
		System.out.println("nom :");
		String nom = sc.nextLine();
		System.out.println("prix:");
		Double prix = Double.parseDouble(sc.nextLine());
		System.out.println("quantite:");
		Integer quantite = Integer.parseInt(sc.nextLine());
		System.out.println("description:");
		String description = sc.nextLine();

		Menu menu = new Menu(0, nom, prix, quantite, description);
		menuDao.insertMenu(menu);
	}
}
