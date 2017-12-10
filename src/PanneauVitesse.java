/**
 * 
 */

/**
 * @author Brian
 *
 */
public class PanneauVitesse implements Semaphore {

	/**
	 */
	private final int vitesseLimite;
	
	
	public PanneauVitesse(int vitesse) {
		this.vitesseLimite = vitesse;
	}
	
	public int getVitesseLimite() {
		return vitesseLimite;
	}
}
