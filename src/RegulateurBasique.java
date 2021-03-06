import java.util.ArrayList;


public class RegulateurBasique extends Regulateur {
	//ne prendra pas en compte le traffic, et ne fonctionne qu'avec 
	//un nombre quelconque de feux bicolors
	/**
	 * @param args
	 */
	private int nbFeux;
	
	//initialise tous les feux à rouge, sauf le premier qui est mis à vert
	public RegulateurBasique(Jonction j){
		super(j);
		nbFeux = j.getSegments().size();
		for (int i = 0 ; i<nbFeux ; i++)
		{
				//On considère que le sémaphore récupéré est forcément un Feu
				Feu feu = (Feu)getJonction().getSegments().get(i)
				.getSemaphores().get(getJonction().getSegments().get(i).getSemaphores().size()-1);
			
			if (i != 0)
				feu.setCoul(Couleur.ROUGE);
			
			else
			{
				feu.setCoul(Couleur.VERT);
				this.setPriorite(getJonction().getSegments().get(i));
			}
			
		}
		
	}
	
	
	@Override
	public void checkTraffic(){
		//C'est un régulateur de base qui ne prends pas en compte l'état du reseau
		//la fonction ne fait donc rien
	}
	
	@Override
	public void changeState(){

		for (int i = 0 ; i<nbFeux ; i++)
		{
			//On considère que le sémaphore récupéré est forcément un Feu
			Feu feu = (Feu)getJonction().getSegments().get(i)
					.getSemaphores().get(getJonction().getSegments().get(i).getSemaphores().size()-1);
			
			if (!(feu.getCoul().equals(Couleur.ROUGE)))
			{
				Couleur coul = feu.changeCouleur();
				System.out.println(coul);
				if(coul.equals(Couleur.ROUGE))
				{
					System.out.println(coul);
					System.out.println("ok");
					if (i == nbFeux-1)
							i=-1;
					
					feu = (Feu)getJonction().getSegments().get(i+1)
						.getSemaphores().get(getJonction().getSegments().get(i+1).getSemaphores().size()-1);
					feu.setCoul(Couleur.VERT);
					this.setPriorite(getJonction().getSegments().get(i+1));
				}
				
				break;
			}
			
		}		
		
		setChrono(0);
	}
	

	
	@Override
	public void updateJonction(){
		incrementeChrono();
		if (this.getChrono() == 2)
		{
			changeState();
			this.setChrono(0);
		}
	}
	
	@Override
	public void printEtatJonction(){
		Feu feu;
		for (int i= 0 ; i<nbFeux ; i++)
		{
			feu = (Feu)getJonction().getSegments().get(i)
				.getSemaphores().get(getJonction().getSegments().get(i).getSemaphores().size()-1);
			
			System.out.println("Le feu n."+i+" est "+feu.getCoul());
			
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creation d'une jonction basique
		ArrayList<Segment> seg = new ArrayList<Segment>();
		Feu feu;
		for (int i= 0 ; i<3 ; i++)
		{
			seg.add(new Segment(50));
			seg.get(i).getSemaphores().add(new FeuTri(Couleur.ROUGE));
			feu = (Feu)seg.get(i).getSemaphores().get(0);
			System.out.println(feu.getCoul());
		}
		
		Jonction jonc = new Jonction(seg);
		RegulateurBasique meh = new RegulateurBasique(jonc);
		System.out.println("\n");
		meh.printEtatJonction();
		
		//Evolution en fonction du temps
		for (int i= 1 ; i<15 ; i++)
		{
			meh.nextStep();
			
		}
	}

}
