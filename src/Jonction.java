import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Brian
 *
 */
public class Jonction {

	private ArrayList<Segment> segments;
	
	/**
	 * 
	 * @param segments
	 * @param nb
	 */
	public Jonction(ArrayList<Segment> segments, int nb) {
		try{
			this.segments = new ArrayList<Segment>();
			
			for(int i = 0; i < nb; i++){
				if(segments.get(i).getjA() == null){
					this.segments.add(segments.get(i));
					this.segments.get(i).setjA(this);
				}
				else if(segments.get(i).getjB() == null){
					this.segments.add(segments.get(i));
					this.segments.get(i).setjB(this);
				}
				else{
					segments.remove(i);
					i--;
				}
			}
		} catch(IndexOutOfBoundsException e){
			System.err.println("Au moins un des segments est déjà associé à deux jonctions.");
		}
	}
	
	/**
	 * 
	 * @param s Le segment à associer à la jonction
	 */
	public Jonction(Segment s){
		segments = new ArrayList<Segment>();
		segments.add(s);
		if(s.getjA() == null)
			s.setjA(this);
		else
			s.setjB(this);
	}
	
	public ArrayList<Segment> getSegments() {
		return segments;
	}

	public void setSegments(ArrayList<Segment> segments) {
		this.segments = segments;
	}

	@Override
	public String toString(){
		String str =  "Cette jonction relie " + segments.size() + " voies.";
		for(int i = 0; i < segments.size(); i++)
			str += " " + segments.get(i).id;
		return str;
	}
}
