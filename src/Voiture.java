/**
 * 
 */

/**
 * @author Brian
 * 
 */
public class Voiture extends Vehicule {

	// R�fl�chir � l'id�e d'en faire un tableau pour avoir aussi le nom du segment
	
	/**
	 * 
	 */
	public Voiture(String id) {
		super(id);
	}
	
	//la vitesse ne peut pas etre superieur a ce qu'impose les semaphores
	@Override
	public void setVitesse(int vitesse){
		if (vitesse > this.getDest().getVitesseMax())
			vitesse = this.getDest().getVitesseMax();
		this.vitesse=vitesse;
	}

	
	
	@Override
	public String toString(){
		return "La voiture " + this.getId() + " roule sur le segment ... � une vitesse de " + vitesse;
	}
}
