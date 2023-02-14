package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	

	public int getEffetPotion() {
		return effetPotion;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + texte );
	}

	private String prendreParole() {
		return "Le Gaulois "+ nom + " : " ;
	}
	
	public void frapper(Romain romain, int forcePotion) {
		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
		romain.recevoirCoup((force/3)*forcePotion);
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public void boirePotion(int forcePotion) {
		parler("Merci Druide, je sens que ma force est "+ forcePotion + " fois decuplee.");
	}
	
	public static void main(String [] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		asterix.parler("Salut");
		asterix.boirePotion(effetPotion);
	}
}
