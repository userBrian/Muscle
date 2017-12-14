/**
 * 
 */

/**
 * @author Brian
 *
 */
public class FeuBi extends Feu {

	/**
	 * 
	 */
	public FeuBi(Couleur c) {
		super(c);
	}

	public Couleur changeCouleur(){
			coul = (coul == Couleur.ROUGE)? Couleur.VERT : Couleur.ROUGE;
			return coul;
	}
}
