package histoire;

import personnages.Gaulois;
import personnages.Romain;

public class Scenario {
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		Romain coronavirus = new Romain("Coronavirus", 6);
		
		asterix.parler("Bonjour a tous");
		coronavirus.parler("UN GAU... UN GAUGAU...");
		
		asterix.frapper(coronavirus);

		asterix.frapper(coronavirus);

		asterix.frapper(coronavirus);

	}
}
