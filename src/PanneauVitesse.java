/**
 * 
 */

/**
 * @author Brian
 *
 */
public class PanneauVitesse extends Panneau {

	private int vitesseMax;
	
	/**
	 * 
	 */
	public PanneauVitesse(int vitesseMax, int sens) {
		super(sens);
		this.vitesseMax = vitesseMax;
	}

	public int getVitesseMax(){
		return vitesseMax;
	}
	
}
