package Diginamic.JDBC_menu.model;

/**
 * represente un menu
 * 
 * @author Kevin.s
 *
 */
public class Menu {

	/** id : Integer */
	private Integer id;
	/** nom : String */
	private String nom;
	/** prix : Double */
	private Double prix;
	/** quantité : Integer */
	private Integer quantité;
	/** description : String */
	private String description;

	/**
	 * Constructeur
	 * 
	 */
	public Menu() {
	}

	/**
	 * Constructeur
	 * 
	 * @param id
	 * @param nom
	 * @param prix
	 * @param quantité
	 * @param description
	 */
	public Menu(Integer id, String nom, Double prix, Integer quantité, String description) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.quantité = quantité;
		this.description = description;
	}

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setters
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter
	 * 
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setters
	 * 
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter
	 * 
	 * @return the prix
	 */
	public Double getPrix() {
		return prix;
	}

	/**
	 * Setters
	 * 
	 * @param prix
	 *            the prix to set
	 */
	public void setPrix(Double prix) {
		this.prix = prix;
	}

	/**
	 * Getter
	 * 
	 * @return the quantité
	 */
	public Integer getQuantité() {
		return quantité;
	}

	/**
	 * Setters
	 * 
	 * @param quantité
	 *            the quantité to set
	 */
	public void setQuantité(Integer quantité) {
		this.quantité = quantité;
	}

	/**
	 * Getter
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Setters
	 * 
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "[" + nom + "]" + " id=" + id + " prix=" + prix + " quantité=" + quantité + " description="
				+ description;
	}

}
