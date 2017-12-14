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
		super(id, 20);
	}
	
	//la vitesse ne peut pas etre superieur a ce qu'impose les semaphores
	
	@Override
	public void setVitesse(int vitesse){
		this.vitesse = (vitesse <= vitesseMax) ? vitesse : vitesseMax;
	}
	
	
	public static void main(String[] args) {
		//TEST CAPTEUR
		Voiture car = new Voiture("haha");
		Capteur capt = new CapteurVitesse("route du sale", 50);
		car.addObserver(capt);
		car.setPosition(50);	

	}
}
