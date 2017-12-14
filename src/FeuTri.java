/**
 * 
 */

/**
 * @author Brian
 *
 */
public class FeuTri extends Feu {

	/**
	 * 
	 */
	public FeuTri(Couleur c) {
		super(c);
	}

	public Couleur changeCouleur(){
		if (coul == Couleur.ROUGE)
			coul = Couleur.VERT;
		
		else
		{
			if (coul == Couleur.VERT)
				coul = Couleur.ORANGE;
			
			else
			{
				if (coul == Couleur.ORANGE)
					coul = Couleur.ROUGE;
			}
		}
		
		return coul;
	}
}
