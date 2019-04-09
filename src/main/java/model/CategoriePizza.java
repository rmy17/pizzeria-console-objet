package model;

public enum CategoriePizza {

	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans_Viande");

	private String nom;

	private CategoriePizza(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public static CategoriePizza recupCat(String name) {
		CategoriePizza[] cat = values();

		for (CategoriePizza c : cat) {
			if (c.getNom().equalsIgnoreCase(name)) {
				return c;
			}
		}
		return null;
	}

}
