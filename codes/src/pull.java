import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by emfuthal on 25/10/16.
 */
public class pull {

    public static void main(String [] args) throws IOException {
        ObjectMapper mapper1 = new ObjectMapper();
        URL url = new URL("http://transport.opendata.ch/v1/connections?from=Lausanne&to=Genève");
        connection test = mapper1.readValue(url, connection.class);
        for (connection.Station_w a : test.connections[0].sections[0].journey.passList)
            System.out.println(a.station.name);
    }
    
    /* in: String departure: specifies the station of departure eg. Zurich 
     * in: String means: train/bus/tram...
     * prints the next few connections from this location 
     */
    public static void printConnections(String departure, String means) throws IOException {
        List<sbb.Stationboard> test = nextDeps(departure, means);
        for(sbb.Stationboard a : test){
            System.out.printf("from %10s to %20s Platform %5s at %s \n", a.stop.station.name, a.to, a.stop.platform, a.toTime(a.stop.departure) );
        }
    }

    /* in: String depart: specify the train station
     * out: a sbb object containing the next 10 connections from this train station     * 
     */
    public static sbb pullRequest(String depart) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        URL url = new URL("http://transport.opendata.ch/v1/stationboard?station=" + depart + "&limit=10");
        sbb sbb1 = mapper.readValue(url, sbb.class);
        return sbb1;
    }

    /* in: String depart: specify the train station
     * in: int limit: requests the next 'limit' connections from this station
     * out: an sbb object containing the next 'limit' connections from this statin.
     */
    public static sbb pullRequest(String depart, int limit) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        URL url = new URL("http://transport.opendata.ch/v1/stationboard?station=" + depart + "&limit=" + limit);
        sbb sbb1 = mapper.readValue(url, sbb.class);
        return sbb1;
    }

    /* in: String depart: specify the train station
     * in: String means: specify the means of transport 
     * out: List of the next connections from this station
     */
    public static List<sbb.Stationboard> nextDeps(String depart, String means) throws IOException {
        int searchDepth = 100;
        List<sbb.Stationboard> result = new LinkedList<sbb.Stationboard>();
        sbb request = pullRequest(depart, searchDepth);
        for(sbb.Stationboard a : request.stationboard) {
            if (a.category.equals(means)) {
                result.add(a);
            }
        }
        return result;
    }
}
