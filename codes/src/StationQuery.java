import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

/* This class allows to easily get a list of an arbitrary number of stations which can be reached from a station
 */

public class StationQuery {
	
	private static int depth = 100;
	public String Station; 
	public List<sbb.Station> StationList;
	
	public StationQuery(String station, List<String> means)throws IOException{
		this.Station = station;	
		this.StationList = reachableStations(Station, means);
	}
	
	public StationQuery(String station)throws IOException{
		this.Station = station;	
		List<String> beta = new ArrayList<String>();
		beta.add("Bus");
		beta.add("S");
		beta.add("Train");
		beta.add("Tram");
		this.StationList = reachableStations(Station, beta);
	}
	
	public static sbb pullRequest(String depart) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		URL url = new URL("http://transport.opendata.ch/v1/stationboard?station=" + depart + "&limit=" + depth);
		sbb sbb1 = mapper.readValue(url, sbb.class);
		return sbb1;
	}
	  
	public static List<sbb.Station> reachableStations(String a, List<String> means) throws IOException{
		List<sbb.Station> result = new ArrayList<sbb.Station>();
		sbb request = pullRequest(a);
		for (sbb.Stationboard b : request.stationboard){
			if (means.contains(b.category)) {
				for (sbb.Stationboard.PassList s : b.passList){
					sbb.Station t = s.station;
					if (!result.contains(t)) result.add(t);
				}
			}
		}
		return result;
	}
	  
}
