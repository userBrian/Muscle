/**
 * 
 */

/**
 * @author Brian
 *
 */
public class Voiture {

	private final String id;
	private int vitesse;
	private int sens;
	private int position;
	
	/**
	 * 
	 */
	public Voiture(String id) {
		this.id = id;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	public int getSens() {
		return sens;
	}

	public void setSens(int sens) {
		this.sens = sens;
	}

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}
}
