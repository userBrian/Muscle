/**
 * 
 */

/**
 * @author Brian
 * 
 */
public class Voiture extends Vehicule {
	
	/**
	 * 
	 */
	public Voiture(String id) {
		super(id);
	}
	
	//la vitesse ne peut pas etre superieur a ce qu'impose les semaphores
	
	@Override
	public void setVitesse(int vitesse){
		if(vitesse <= getSeg().getVitesseMax() && vitesse <= vitesseMax)
			this.vitesse = vitesse;
		else
			this.vitesse = Math.min(getSeg().getVitesseMax(), vitesseMax);
	}

	@Override
	public String toString(){
		return "La voiture " + this.getId() + " roule sur le segment " + getSeg() + " a une vitesse de " + vitesse + " m/s.";
	}
	
	
	public static void main(String[] args) {
		//TEST CAPTEUR
		Voiture car = new Voiture("haha");
		Capteur capt = new CapteurVitesse("route du sale", 50);
		car.addObserver(capt);
		car.setPosition(50);	

	}
}
