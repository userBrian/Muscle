import java.util.Observer;
import java.util.Observable;

/**
 * 
 */

/**
 * @author Brian
 *
 */
public class Capteur implements Observer {

	private int position;
	private String id;
	
	/**
	 * 
	 */
	//Pas oublier quand on construit un capteur de le construire sur les deux segments!!!
	public Capteur( String id, int position) {
		this.position = position;
		this.id = id;
	}
	
	public int getPosition() {
		return position;
	}

	public String getId() {
		return id;
	}

	public void update(Observable obs, Object arg){
		if (obs instanceof Vehicule)
		{	
			Vehicule castObs = (Vehicule)obs;
			if(castObs.getPosition()>=this.position)
			System.out.println("Vehicule "+castObs.getId()+" detecte au capteur : "+ id);
		}
	}

}
