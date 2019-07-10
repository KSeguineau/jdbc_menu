package Diginamic.JDBC_menu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Diginamic.JDBC_menu.exception.TechnicalException;
import Diginamic.JDBC_menu.model.Menu;
import Diginamic.JDBC_menu.utils.ConnectionUtils;
import Diginamic.JDBC_menu.utils.UpdateQueryUtils;

/**
 * permet de manipuler la table repas de la bdd
 * 
 * @author Kevin.s
 *
 */
public class MenuDao {

	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(MenuDao.class);

	/**
	 * Constructeur
	 * 
	 */
	public MenuDao() {

	}

	/**
	 * recupere la liste des menu
	 * 
	 * @return
	 */
	public List<Menu> recupererAll() {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Menu> listeMenu = new ArrayList<Menu>();

		try {
			preparedStatement = ConnectionUtils.getInstance().prepareStatement(
					"select * from repas");
			resultSet = preparedStatement.executeQuery();
			ConnectionUtils.doCommit();
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String nom = resultSet.getString("nom");
				Double prix = resultSet.getDouble("prix");
				Integer quantite = resultSet.getInt("quantite");
				String description = resultSet.getString("description");
				Menu menu = new Menu(id, nom, prix, quantite, description);
				listeMenu.add(menu);
			}
			return listeMenu;
		} catch (SQLException e) {
			SERVICE_LOG.error("probleme de selection en base", e);
			throw new TechnicalException("probleme de selection en base", e);

		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					SERVICE_LOG.error("impossible de fermer le resultSet", e);
					throw new TechnicalException("impossible de fermer le resultSet", e);
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					SERVICE_LOG.error("impossible de fermer le statement", e);
					throw new TechnicalException("impossible de fermer le statement", e);
				}
			}
			ConnectionUtils.doClose();
		}
	}

	/**
	 * permet d’inserer un menu
	 * 
	 * @param menu
	 */
	public void insertMenu(Menu menu) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO `repas` (`nom`,`prix`,`quantite`,`description`) VALUES (");
		sb.append('"').append(menu.getNom()).append('"').append(",");
		sb.append(menu.getPrix()).append(",");
		sb.append(menu.getQuantité()).append(",");
		sb.append('"').append(menu.getDescription()).append('"').append(")");

		UpdateQueryUtils.updateQuery(sb.toString());
	}

	/**
	 * permet de modifier un menu
	 * 
	 * @param menu
	 */
	public void updateMenu(Menu menu) {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE repas SET ");
		sb.append("nom = ").append("'").append(menu.getNom()).append("',");
		sb.append("prix = ").append(menu.getPrix()).append(",");
		sb.append("quantite = ").append(menu.getQuantité()).append(",");
		sb.append("description = ").append("'").append(menu.getDescription()).append("' ");
		sb.append("WHERE id = ").append(menu.getId());

		UpdateQueryUtils.updateQuery(sb.toString());
	}

	/**
	 * permet de supprimer un menu à partir de son nom
	 * 
	 * @param nom
	 */
	public void deleteMenu(String nom) {
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM `repas` WHERE `nom` = ").append('"').append(nom).append('"');

		UpdateQueryUtils.updateQuery(sb.toString());

	}

}
