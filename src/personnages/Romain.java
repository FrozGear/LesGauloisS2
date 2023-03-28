package personnages;

public class Romain {
	private String nom;
	private int force;
	private int nbEquipement=0;
	private Equipement[] equipements;
	private String texte;
	
	public Romain(String nom, int force, int nbEquipementMax) {
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[nbEquipementMax];
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
	

	private int CalculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (!(nbEquipement == 0)) {
		texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
		for (int i = 0; i < nbEquipement;) {
		if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) == true) {
		resistanceEquipement += 8;
			} 
		else{
		System.out.println("Equipement casque");
		resistanceEquipement += 5;
			}
		i++;
		}
		texte =+ resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
		}
	
	
		private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom.toString() + "s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
		if (equipements[i] == null) {
		continue;
		} 
		else{
		equipementEjecte[nbEquipementEjecte] = equipements[i];
		nbEquipementEjecte++;
		equipements[i] = null;
			}
		}
		return equipementEjecte;
		}
	
	
//	public void recevoirCoup(int forceCoup) {
//		assert forceCoup >= 0 : "La valeur rentree est negative";
//		force -= forceCoup;
//		if (force>0) {
//			parler("Aie !");
//		} else {
//			parler("J'abandonne ...");
//		}
//		assert forceCoup > force-forceCoup: "post-condition"; 
//	}
	
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = CalculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("Aïe");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		switch (force) {
		case 0:
		parler("Aïe");
		default:
		equipementEjecte = ejecterEquipement();
		parler("J'abandonne...");
		break;
			}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
		}


	public void sEquiper(Equipement stuffs) {
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat "+ nom +" est deja bien protege !");
		case 1:
			if(equipements[0] == Equipement.CASQUE) {
				System.out.println("Le soldat " + nom +" possede deja un casque" );
				System.out.println("Le soldat " + nom +" s'equipe d'un bouclier" );
				this.equipements[this.nbEquipement++] = Equipement.BOUCLIER;
				break;
			}
			else if(equipements[0] == Equipement.BOUCLIER) {
				System.out.println("Le soldat " + nom +" possede deja un bouclier" );
				System.out.println("Le soldat " + nom +" s'equipe d'un casque" );
				this.equipements[this.nbEquipement++] = Equipement.CASQUE;
				break;
			}
		case 0:
			System.out.println("Le soldat " + nom +" s'equipe d'un bouclier" );
			this.equipements[this.nbEquipement++] = Equipement.BOUCLIER;
			System.out.println("Le soldat " + nom +" s'equipe d'un casque" );
			this.equipements[this.nbEquipement++] = Equipement.CASQUE;
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


