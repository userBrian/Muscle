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

	public void changeCouleur(){
			coul = (coul == Couleur.ROUGE)? Couleur.VERT : Couleur.ROUGE;
	}
}
