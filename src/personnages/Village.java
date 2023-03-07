package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois = 0;
	private Gaulois[] villageois;

	public Village(String nom, Chef chef, int nbVillageoisMaximum) {
		this.nom = nom;
		this.chef = chef;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}
	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois newHabitant) {
		this.villageois[this.nbVillageois++] = newHabitant;
	}
	public Gaulois trouverHabitant(int reference) {
		return this.villageois[reference];
	}
	public void afficherVillageois() {
		System.out.println("Dans le village du chef " + this.chef.getNom() + " vivent les légendaires gaulois :");
		for(int i=0; i<nbVillageois; i++) {
			System.out.println("- " + trouverHabitant(i).getNom());
		}
	}
	
	public static void main(String[] args) {
		Village village_des_Irréductibles = new Village("Village des Irréductibles", null ,30);
		
		//Gaulois gaulois = village_des_Irréductibles.trouverHabitant(30);
		
		Chef chef = new Chef("Abraracourix", 6, 1, village_des_Irréductibles);
		village_des_Irréductibles.setChef(chef);
		
		Gaulois asterix = new Gaulois("Asterix", 8, 1);
		Gaulois obelix = new Gaulois("Obelix", 25, 1);
		
		village_des_Irréductibles.ajouterHabitant(asterix);
		village_des_Irréductibles.ajouterHabitant(obelix);
		
		//Gaulois gaulois = village_des_Irréductibles.trouverHabitant(1);
		//System.out.println(gaulois);
		
		village_des_Irréductibles.afficherVillageois();
	}
}
