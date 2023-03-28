package personnages;

public class Gaulois {
	private String nom;
	private int force, nb_trophees;
	private int effetPotion = 1;
	private Equipement trophees[] = new Equipement[100];
	
	public Gaulois(String nom, int force, int effetPotion) {
		this.nom = nom;
		this.force = force;
		this.effetPotion = effetPotion;
	}
	
	public String getNom() {
		return nom;
	}
	

	public int getNb_trophees() {
		return nb_trophees;
	}
	public Equipement getEquipement(int n) {
		return trophees[nb_trophees];
	}
	

	public int getEffetPotion() {
		return effetPotion;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + texte );
	}

//	private String prendreParole() {
//		return "Le Gaulois "+ nom + " : " ;
//	}
	
	
	private String prendreParole() {
		String texte = "Le gaulois " + nom + " : ";
		return texte;
		}

	
	
//	public void frapper(Romain romain, int forcePotion) {
//		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
//		romain.recevoirCoup((force/3)*forcePotion);
//	}
	
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement trophees[] = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++,nb_trophees++) {
		this.trophees[nb_trophees] = trophees[i];
			}
		return;
		}

	
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public void boirePotion(int forcePotion) {
		parler("Merci Druide, je sens que ma force est "+ forcePotion + " fois decuplee.");
	}
	
	public void faireUneDonation(Musee musee) {
		if(nb_trophees>0) {
			System.out.println(prendreParole() + ": Je donne au musee tous mes trophees :");
			for(int i=0; i<nb_trophees; i++) {
				System.out.println("- " + trophees[i]);
			}
		}
	}
	
	public static void main(String [] args) {
		Gaulois asterix = new Gaulois("Asterix", 8, 5);
		asterix.parler("Salut");
		asterix.boirePotion(4);
	}
}
