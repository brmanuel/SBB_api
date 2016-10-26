import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by emfuthal on 26/10/16.
 */
public final class connection {
        public final Connection connections[];
        public final Station from;
        public final Station to;
        public final Stations stations;

        @JsonCreator
        public connection(@JsonProperty("connections") Connection[] connections, @JsonProperty("from") Station from, @JsonProperty("to") Station to, @JsonProperty("stations") Stations stations){
            this.connections = connections;
            this.from = from;
            this.to = to;
            this.stations = stations;
        }

        @JsonIgnoreProperties({"service", "products"})
        public static final class Connection {
            public final Station_w from;
            public final Station_w to;
            public final String duration;
            public final int transfers;
            public final int capacity1st;
            public final int capacity2nd;
            public final Section sections[];

            @JsonCreator
            public Connection(@JsonProperty("from") Station_w from, @JsonProperty("to") Station_w to, @JsonProperty("duration") String duration, @JsonProperty("transfers") int transfers, @JsonProperty("capacity1st") int capacity1st, @JsonProperty("capacity2nd") int capacity2nd, @JsonProperty("sections") Section[] sections){
                this.from = from;
                this.to = to;
                this.duration = duration;
                this.transfers = transfers;
                this.capacity1st = capacity1st;
                this.capacity2nd = capacity2nd;
                this.sections = sections;
            }


            public static final class Section {
                public final Journey journey;
                public final double walk;
                public final Station_w departure;
                public final Station_w arrival;

                @JsonCreator
                public Section(@JsonProperty("journey") Journey journey, @JsonProperty("walk") double walk, @JsonProperty("departure") Station_w departure, @JsonProperty("arrival") Station_w arrival){
                    this.journey = journey;
                    this.walk = walk;
                    this.departure = departure;
                    this.arrival = arrival;
                }

                @JsonIgnoreProperties({"subcategory"})
                public static final class Journey {
                    public final String name;
                    public final String category;
                    public final long categoryCode;
                    public final String number;
                    public final String operator;
                    public final String to;
                    public final Station_w passList[];
                    public final int capacity1st;
                    public final int capacity2nd;

                    @JsonCreator
                    public Journey(@JsonProperty("name") String name, @JsonProperty("category") String category, @JsonProperty("categoryCode") long categoryCode, @JsonProperty("number") String number, @JsonProperty("operator") String operator, @JsonProperty("to") String to, @JsonProperty("passList") Station_w[] passList, @JsonProperty("capacity1st") int capacity1st, @JsonProperty("capacity2nd") int capacity2nd){
                        this.name = name;
                        this.category = category;
                        this.categoryCode = categoryCode;
                        this.number = number;
                        this.operator = operator;
                        this.to = to;
                        this.passList = passList;
                        this.capacity1st = capacity1st;
                        this.capacity2nd = capacity2nd;
                    }
                }
            }
        }

        public static final class Stations {
            public final Station from[];
            public final Station to[];

            @JsonCreator
            public Stations(@JsonProperty("from") Station[] from, @JsonProperty("to") Station[] to){
                this.from = from;
                this.to = to;
            }
        }

    public static final class Coordinate {
        public final String type;
        public final double x;
        public final double y;

        @JsonCreator
        public Coordinate(@JsonProperty("type") String type, @JsonProperty("x") double x, @JsonProperty("y") double y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }
    }

    @JsonIgnoreProperties({"arrivalTimestamp", "departureTimestamp", "realtimeAvailability"})
    public static final class Station_w {
        public final Station station;
        public final String arrival;
        public final String departure;
        public final double delay;
        public final String platform;
        public final Prognosis prognosis;
        public final Location location;


        @JsonCreator
        public Station_w(@JsonProperty("station") Station station, @JsonProperty("arrival") String arrival, @JsonProperty("departure") String departure, @JsonProperty("delay") double delay, @JsonProperty("platform") String platform, @JsonProperty("prognosis") Prognosis prognosis, @JsonProperty("location") Location location) {
            this.station = station;
            this.arrival = arrival;
            this.departure = departure;
            this.delay = delay;
            this.platform = platform;
            this.prognosis = prognosis;
            this.location = location;
        }
    }

    public static final class Station {
        public final String id;
        public final String name;
        public final int score;
        public final Coordinate coordinate;
        public final double distance;

        @JsonCreator
        public Station(@JsonProperty("id") String id, @JsonProperty("name") String name, @JsonProperty("score") int score, @JsonProperty("coordinate") Coordinate coordinate, @JsonProperty("distance") double distance) {
            this.id = id;
            this.name = name;
            this.score = score;
            this.coordinate = coordinate;
            this.distance = distance;
        }
    }

    public static final class Prognosis {
        public final String platform;
        public final String arrival;
        public final String departure;
        public final int capacity1st;
        public final int capacity2nd;

        @JsonCreator
        public Prognosis(@JsonProperty("platform") String platform, @JsonProperty("arrival") String arrival, @JsonProperty("departure") String departure, @JsonProperty("capacity1st") int capacity1st, @JsonProperty("capacity2nd") int capacity2nd){
            this.platform = platform;
            this.arrival = arrival;
            this.departure = departure;
            this.capacity1st = capacity1st;
            this.capacity2nd = capacity2nd;
        }
    }

    public static final class Location {
        public final String id;
        public final String name;
        public final int score;
        public final Coordinate coordinate;
        public final double distance;

        @JsonCreator
        public Location(@JsonProperty("id") String id, @JsonProperty("name") String name, @JsonProperty("score") int score, @JsonProperty("coordinate") Coordinate coordinate, @JsonProperty("distance") double distance){
            this.id = id;
            this.name = name;
            this.score = score;
            this.coordinate = coordinate;
            this.distance = distance;
        }
    }
}