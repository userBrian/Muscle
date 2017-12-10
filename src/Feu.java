/**
 * 
 */

/**
 * @author Brian
 *
 */
public abstract class Feu implements Semaphore {

	protected Couleur coul;
	
	/**
	 * 
	 */
	public Feu(Couleur c) {
		this.coul = c;
		// TODO Auto-generated constructor stub
	}
	
	
	public void setCoul(Couleur c){
		this.coul = c;
	}
	
	public Couleur getCoul(){
		return this.coul;
	}

}
