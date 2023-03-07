package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipement;
	private int nbEquipement=0;
	
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
	
	public void sEquiper(Equipement stuffs) {
		switch (Equipement) {
		case nbEquipement==2:
			System.out.println("Le soldat"+ nom +"est deja bien protege !");
		}
	}
	
	public static void main(String [] args) {
		Romain coronavirus = new Romain("Coronavirus", 6);
		coronavirus.parler("Salut");
		coronavirus.recevoirCoup(4);
		
		//System.out.println(Equipement.CASQUE);
		//System.out.println(Equipement.BOUCLIER);
	}
}
