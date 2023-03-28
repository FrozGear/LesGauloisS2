package personnages;

public class Musee {
	private Trophee[] trophees;
	private int nbrTrophees;
	
	public Musee(Trophee[] trophees, int nbrTrophees) {
		this.trophees = new Trophee[200];
		this.nbrTrophees = nbrTrophees;
	}
	
	private int donnerTrophees(Gaulois gaulois) {
		if(gaulois.getNb_trophees()>0) {
			for(int i=0; i<gaulois.getNb_trophees(); i++) {
				nbrTrophees++;
				this.trophees[nbrTrophees] = gaulois.getEquipement(i);   
			}
		}
		return nbrTrophees;
	}
	
	
}
