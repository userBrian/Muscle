import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Brian
 *
 */
public class Segment {

	private int longueur;
	private ArrayList<Semaphore> semaphores;
	private ArrayList<Capteur> capteurs;
	private Jonction jA;
	private Jonction jB;
	public char id;
	private static char lettre = 'A';
	
	/**
	 * 
	 */
	public Segment() {
		id = lettre;
		lettre++;
	}

	public Jonction getjA() {
		return jA;
	}

	public void setjA(Jonction jA) {
		this.jA = jA;
	}

	public Jonction getjB() {
		return jB;
	}

	public void setjB(Jonction jB) {
		this.jB = jB;
	}
	
	@Override
	public String toString(){
		if(jA != null && jB != null)
			return id + " complet";
		else
			return id + " incomplet";
	}
}
