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
	
	public Feu(){
		
	}
	public Feu(Couleur c) {
		super();
		this.coul = c;
		// TODO Auto-generated constructor stub
	}
	
	
	public void setCoul(Couleur c){
		this.coul = c;
	}
	
	public Couleur getCoul(){
		return this.coul;
	}
	
	public abstract Couleur changeCouleur();

}
