/**
 * 
 */

/**
 * @author Brian
 *
 */
public abstract class Feu extends Semaphore {

	protected Couleur coul;
	
	/**
	 * 
	 */
	public Feu(Couleur c) {
		super();
		this.coul = c;
	}
	
	public void setCoul(Couleur c){
		this.coul = c;
	}
	
	public Couleur getCoul(){
		return this.coul;
	}
	
	public abstract Couleur changeCouleur();

}
