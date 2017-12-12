/**
 * 
 */

/**
 * @author Brian
 *
 */
public class PanneauVitesse extends Semaphore implements LimiteVitesse {

	/**
	 */
	private final int vitesseLimite;
	
	
	public PanneauVitesse(int vitesse) {
		super();
		this.vitesseLimite = vitesse;
	}
	
	@Override
	public int vitesseLimite() {
		return vitesseLimite;
	}

}
