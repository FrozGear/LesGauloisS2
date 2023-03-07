package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + texte );
	}

	private String prendreParole() {
		return "Le Romain "+ nom + " : " ;
	}
	
	public void recevoirCoup(int forceCoup) {
		assert forceCoup >= 0 : "La valeur rentree est negative";
		force -= forceCoup;
		if (force>0) {
			parler("Aie !");
		} else {
			parler("J'abandonne ...");
		}
		assert forceCoup > force-forceCoup: "post-condition"; 
	}
	
	public static void main(String [] args) {
		Romain coronavirus = new Romain("Coronavirus", 6);
		coronavirus.parler("Salut");
		coronavirus.recevoirCoup(4);
	}
}
