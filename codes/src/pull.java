import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sun.corba.se.impl.javax.rmi.CORBA.Util;
import com.sun.xml.internal.ws.transport.http.WSHTTPConnection;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by emfuthal on 25/10/16.
 */
public class pull {

    public static void main(String [] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL("http://transport.opendata.ch/v1/stationboard?station=Aarau&limit=10");
        sbb sbb1 = objectMapper.readValue(url, sbb.class);
        System.out.println("output: " + sbb1.station);
    }
}
