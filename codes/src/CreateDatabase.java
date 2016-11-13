import java.util.List;
import java.util.ArrayList;

//a class to create a database of (station, coordinate) which can be searched (sweep line algorithm) in order to find the closest station to location
/*
 * remarks for later: use google api like: http://maps.google.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA to get
 * coordinates from address
 */
public class CreateDatabase {
	
class Entry{
	
	String name;
	double lon;
	double lat;	
	
	public Entry(String name, double lon, double lat){
		this.name = name;
		this.lon = lon;
		this.lat = lat;
	}
}

	private List<Entry> data = new ArrayList<Entry>();
	
	public static void main(String args[]){
		
	}
	
	public static void traverseTree(String root, String means){
		
	}
	
	
}
