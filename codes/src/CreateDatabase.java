import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

//a class to create a database of (station, coordinate) which can be searched (sweep line algorithm) in order to find the closest station to location
/*
 * remarks for later: use google api like: http://maps.google.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA to get
 * coordinates from address
 */
public class CreateDatabase {
	
static class Entry{
	
	String name;
	double lon;
	double lat;	
	
	public Entry(String name, double lon, double lat){
		this.name = name;
		this.lon = lon;
		this.lat = lat;
	}


	@Override
	public int hashCode() {
		return (int) (1000000*(this.lon + this.lat));
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Entry))
			return false;
		else {
			Entry ob = (Entry) obj;
			return (this.lat == ob.lat && this.lon == ob.lon);
		}
	}
}

	public CreateDatabase(){}

	private static List<Entry> data = new ArrayList<Entry>();
	private static int size = 0;
	
	public static void main(String args[]) throws IOException{
		StationFromName root = new StationFromName("Olten");
		sbb.Station a = root.Station;
		traverseTree(a);
	}
	
	
	// prohibit foreign destinations. how?
	public static void traverseTree(sbb.Station root) throws IOException{
		Entry rootEntry = new Entry(root.name, root.coordinate.x, root.coordinate.y);
		if (!data.contains(rootEntry)){
			data.add(rootEntry);
			System.out.printf("%s ", rootEntry.name);
			StationQuery query = new StationQuery(root.name);
			for (sbb.Station s : query.StationList) traverseTree(s);
		}
	}
	
	
}
