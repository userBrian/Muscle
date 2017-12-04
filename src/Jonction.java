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
	
	public Jonction(ArrayList<Segment> segs) {
		segments = new ArrayList<Segment>();
		
		while(!segs.isEmpty()){
			segments.add(segs.get(0));
			segs.remove(0);
		}
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
			str += " " + segments.get(i).getId();
		return str;
	}
}
