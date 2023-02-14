package personnages;
import java.util.Random;

public class Druide {
	private String nom;
	private int forcePotion = 1;
	private int effetPotionMin;
	private int effetPotionMax;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " a " + effetPotionMax + ".");	
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + texte );
	}

	private String prendreParole() {
		return "Le Druide "+ nom + " : " ;
	}
	
	public void preparerPotion() {
		Random random = new Random();
		forcePotion = random.nextInt(effetPotionMax-effetPotionMin)+effetPotionMin;
		if(forcePotion>7) {
			parler("J'ai préparé une super potion de force " + forcePotion + ".");
		}
		if(forcePotion<7) {
			parler("Je n'ai pas trouver tous les ingredients, ma potion est seulement de force " + forcePotion + ".");
		}
	}
	
	public void booste(Gaulois gaulois) {
		gaulois.effetPotion = forcePotion;
	}
	
	public static void main(String[] args) {
		Druide pano = new Druide("Panoramix", 5, 10);
		pano.preparerPotion();
	}
}
