import java.io.IOException;

public class Testing {
	
	public static void main(String args[]) throws IOException{
		testStationQuery();
		testStationFromName();
	}
	
	public static void testStationQuery() throws IOException{
		StationQuery test = new StationQuery("Basel SBB");
		for (sbb.Station s : test.StationList){
			System.out.printf("%s ", s.name);
		}
		System.out.print("\n");
	}
	
	public static void testStationFromName() throws IOException{
		StationFromName test = new StationFromName("Schlieren");
		System.out.printf("%s, %f, %f \n", test.Station.name, test.Station.coordinate.x, test.Station.coordinate.y);
	}
}
