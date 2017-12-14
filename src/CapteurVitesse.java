import java.util.Observable;


public class CapteurVitesse extends Capteur{

	/**
	 * @param args
	 */
	
	public CapteurVitesse(String id, int position){
		super(id, position);
	}
	
	@Override
	public void update(Observable obs, Object arg){
		if (obs instanceof Vehicule)
		{	
			Vehicule castObs = (Vehicule)obs;
			if(castObs.getPosition()>=this.getPosition())
			System.out.println("Vehicule "+castObs.getId()+", vitesse : "+castObs.getVitesse()+" a "+this.getId());
		}
	}

}
