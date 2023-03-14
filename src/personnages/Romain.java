package personnages;

public class Romain {
	private String nom;
	private int force;
	private int nbEquipement=0;
	private Equipement[] equipement;
	
	public Romain(String nom, int force, int nbEquipementMax) {
		this.nom = nom;
		this.force = force;
		this.equipement = new Equipement[nbEquipementMax];
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
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat "+ nom +" est deja bien protege !");
		case 1:
			if(equipement[0] == Equipement.CASQUE) {
				System.out.println("Le soldat " + nom +" possede deja un casque" );
				System.out.println("Le soldat " + nom +" s'equipe d'un bouclier" );
				this.equipement[this.nbEquipement++] = Equipement.BOUCLIER;
				break;
			}
			else if(equipement[0] == Equipement.BOUCLIER) {
				System.out.println("Le soldat " + nom +" possede deja un bouclier" );
				System.out.println("Le soldat " + nom +" s'equipe d'un casque" );
				this.equipement[this.nbEquipement++] = Equipement.CASQUE;
				break;
			}
		case 0:
			System.out.println("Le soldat " + nom +" s'equipe d'un bouclier" );
			this.equipement[this.nbEquipement++] = Equipement.BOUCLIER;
			System.out.println("Le soldat " + nom +" s'equipe d'un casque" );
			this.equipement[this.nbEquipement++] = Equipement.CASQUE;
			break;
		}
	}
	
	public static void main(String [] args) {
		Romain coronavirus = new Romain("Coronavirus", 6, 2);
		coronavirus.parler("Salut");
		coronavirus.recevoirCoup(4);
		
		//System.out.println(Equipement.CASQUE);
		//System.out.println(Equipement.BOUCLIER);
		coronavirus.sEquiper(Equipement.CASQUE);
	}
}


