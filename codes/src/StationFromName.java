import java.io.IOException;
import java.net.URL;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StationFromName {
	
	public sbb.Station Station;

	public StationFromName(String name) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		URL url = new URL("http://transport.opendata.ch/v1/stationboard?station=" + name + "&limit=1");
		sbb sbb1 = mapper.readValue(url, sbb.class);
		this.Station = sbb1.station;
	}
}
