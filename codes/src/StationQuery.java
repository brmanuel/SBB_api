import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	//possible means:
	// Trains: IR, IC, R, S, ICN, RE, SN
	// Buses: NFB, BUS, NB
	// trams: NFT
	//
	public StationQuery(String station)throws IOException{
		this.Station = station;
		this.StationList = reachableStations(Station, defMeans);
	}
	
	public static sbb pullRequest(String depart) throws MalformedURLException {
		depart = depart.replaceAll("\\s", "-");
		ObjectMapper mapper = new ObjectMapper();
		URL url = new URL("http://transport.opendata.ch/v1/stationboard?station=" + depart + "&limit=" + depth);
		sbb sbb1 = null;
		try {
			sbb1 = mapper.readValue(url, sbb.class);
		}
		catch (IOException e) {
			System.out.println("couldn't handle pullRequest of argument: " + depart);
		}
		return sbb1;
	}
	  
	public static List<sbb.Station> reachableStations(String a, List<String> means) throws MalformedURLException {
		List<sbb.Station> result = new ArrayList<sbb.Station>();
		sbb request = pullRequest(a);
		for (sbb.Stationboard b : request.stationboard){
			if (means.contains(b.category)) {
				for (sbb.Stationboard.PassList s : b.passList){
					sbb.Station t = s.station;
					if (!result.contains(t) && !t.name.equals(a)) result.add(t);
				}
			}
		}
		return result;
	}

	private static List<String> defMeans = Arrays.asList("ICN"); //"IR", "R", "RE",  "ICE", "S"
}
