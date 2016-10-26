import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sun.corba.se.impl.javax.rmi.CORBA.Util;
import com.sun.org.apache.bcel.internal.classfile.Field;
import com.sun.xml.internal.ws.transport.http.WSHTTPConnection;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by emfuthal on 25/10/16.
 */
public class pull {

    public static void main(String [] args) throws IOException {
        sbb test = pullRequest("Schlieren");
        for(int i = 0; i < test.stationboard.length; i++){
            System.out.println(test.stationboard[i].to);
        }
    }

    public static sbb pullRequest(String depart) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        URL url = new URL("http://transport.opendata.ch/v1/stationboard?station=" + depart + "&limit=10");
        sbb sbb1 = mapper.readValue(url, sbb.class);
        return sbb1;
    }
}
