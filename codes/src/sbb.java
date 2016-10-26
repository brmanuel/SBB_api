import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by emfuthal on 25/10/16.
 */

public final class sbb {
    public final Station station;
    public final Stationboard stationboard[];

    @JsonCreator
    public sbb(@JsonProperty("station") Station station, @JsonProperty("stationboard") Stationboard[] stationboard){
        this.station = station;
        this.stationboard = stationboard;
    }

    public static final class Station {
        public final int id;
        public final String name;
        public final long score;
        public final Coordinate coordinate;
        public final double distance;

        @JsonCreator
        public Station(@JsonProperty("id") int id, @JsonProperty("name") String name, @JsonProperty("score") long score, @JsonProperty("coordinate") Coordinate coordinate, @JsonProperty("distance") double distance){
            this.id = id;
            this.name = name;
            this.score = score;
            this.coordinate = coordinate;
            this.distance = distance;
        }
    }

    @JsonIgnoreProperties({"subcategory", "capacity1st", "capacity2nd"})
    public static final class Stationboard {
        public final Stop stop;
        public final String name;
        public final String category;
        public final long categoryCode;
        public final int number;
        public final String operator;
        public final String to;
        public final PassList passList[];

        @JsonCreator
        public Stationboard(@JsonProperty("stop") Stop stop, @JsonProperty("name") String name, @JsonProperty("category") String category, @JsonProperty("categoryCode") long categoryCode, @JsonProperty("number") int number, @JsonProperty("operator") String operator, @JsonProperty("to") String to, @JsonProperty("passList") PassList[] passList){
            this.stop = stop;
            this.name = name;
            this.category = category;
            this.categoryCode = categoryCode;
            this.number = number;
            this.operator = operator;
            this.to = to;
            this.passList = passList;
        }

        @JsonIgnoreProperties({"realtimeAvailability", "arrivalTimestamp", "departureTimestamp"})
        public static final class Stop {
            public final Station station;
            public final String arrival;
            public final String departure;
            public final String delay;
            public final int platform;
            public final Prognosis prognosis;
            public final Location location;

            @JsonCreator
            public Stop(@JsonProperty("station") Station station, @JsonProperty("arrival") String arrival, @JsonProperty("departure") String departure, @JsonProperty("delay") String delay, @JsonProperty("platform") int platform, @JsonProperty("prognosis") Prognosis prognosis, @JsonProperty("location") Location location){
                this.station = station;
                this.arrival = arrival;
                this.departure = departure;
                this.delay = delay;
                this.platform = platform;
                this.prognosis = prognosis;
                this.location = location;
            }
        }

        @JsonIgnoreProperties({"arrivalTimestamp", "departureTimestamp", "delay", "realtimeAvailability", "capacity1st", "capacity2nd"})
        public static final class PassList {
            public final Station station;
            public final String arrival;
            public final String departure;
            public final int platform;
            public final Prognosis prognosis;
            public final Location location;

            @JsonCreator
            public PassList(@JsonProperty("station") Station station, @JsonProperty("arrival") String arrival, @JsonProperty("departure") String departure, @JsonProperty("platform") int platform, @JsonProperty("prognosis") Prognosis prognosis, @JsonProperty("location") Location location){
                this.station = station;
                this.arrival = arrival;
                this.departure = departure;
                this.platform = platform;
                this.prognosis = prognosis;
                this.location = location;
            }
        }
    }

    public static final class Coordinate {
        public final String type;
        public final double x;
        public final double y;

        @JsonCreator
        public Coordinate(@JsonProperty("type") String type, @JsonProperty("x") double x, @JsonProperty("y") double y){
            this.type = type;
            this.x = x;
            this.y = y;
        }
    }

    public static final class Location {
        public final String id;
        public final String name;
        public final String score;
        public final Coordinate coordinate;
        public final double distance;

        @JsonCreator
        public Location(@JsonProperty("id") String id, @JsonProperty("name") String name, @JsonProperty("score") String score, @JsonProperty("coordinate") Coordinate coordinate, @JsonProperty("distance") double distance){
            this.id = id;
            this.name = name;
            this.score = score;
            this.coordinate = coordinate;
            this.distance = distance;
        }
    }

    public static final class Prognosis {
        public final int platform;
        public final String arrival;
        public final String departure;
        public final int capacity1st;
        public final int capacity2nd;

        @JsonCreator
        public Prognosis(@JsonProperty("platform") int platform, @JsonProperty("arrival") String arrival, @JsonProperty("departure") String departure, @JsonProperty("capacity1st") int capacity1st, @JsonProperty("capacity2nd") int capacity2nd){
            this.platform = platform;
            this.arrival = arrival;
            this.departure = departure;
            this.capacity1st = capacity1st;
            this.capacity2nd = capacity2nd;
        }
    }
}