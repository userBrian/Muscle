/**
 * 
 */

/**
 * @author Brian
 *
 */
public class PanneauVitesse extends Semaphore {

	/**
	 */
	private final int vitesseLimite;
	
	
	public PanneauVitesse(int vitesse) {
		super();
		this.vitesseLimite = vitesse;
	}
	
	public int getVitesseLimite() {
		return vitesseLimite;
	}
}
