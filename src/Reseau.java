import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Brian
 *
 */
public final class Reseau {

	private static Reseau reseau = null;
	private ArrayList<Jonction> jonctions;
	
	/**
	 * 
	 */
	private Reseau() {
		
	}
	
	public final static Reseau makeInstance(){
		if(Reseau.reseau == null)
			Reseau.reseau = new Reseau();
		return Reseau.reseau;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
