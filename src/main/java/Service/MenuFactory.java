package Service;

public class MenuFactory {

	public MenuService create(String typeMenu) {
		if (typeMenu.equals("Lister")) {
			return new ListerPizzasService();
		} else if (typeMenu.equals("Ajouter")) {
			return new AjouterPizzasService();
		} else if (typeMenu.equals("Modifier")) {
			return new ModifierPizzaService();
		} else if (typeMenu.equals("Supprimer")) {
			return new SupprimerPizzaService();
		} else if (typeMenu.equals("Sauvegarder")) {
			return new SauvegarderPizzasService();
		}
		return null;
	}
}
