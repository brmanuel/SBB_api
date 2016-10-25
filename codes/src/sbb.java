import com.fasterxml.jackson.annotation.JsonCreator;
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
        public final String id;
        public final String name;
        public final long score;
        public final Coordinate coordinate;
        public final Distance distance;

        @JsonCreator
        public Station(@JsonProperty("id") String id, @JsonProperty("name") String name, @JsonProperty("score") long score, @JsonProperty("coordinate") Coordinate coordinate, @JsonProperty("distance") Distance distance){
            this.id = id;
            this.name = name;
            this.score = score;
            this.coordinate = coordinate;
            this.distance = distance;
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

        public static final class Distance {

            @JsonCreator
            public Distance(){
            }
        }
    }

    public static final class Stationboard {
        public final Stop stop;
        public final String name;
        public final String category;
        public final String subcategory;
        public final long categoryCode;
        public final String number;
        public final String operator;
        public final String to;
        public final PassList passList[];

        @JsonCreator
        public Stationboard(@JsonProperty("stop") Stop stop, @JsonProperty("name") String name, @JsonProperty("category") String category, @JsonProperty("subcategory") String subcategory, @JsonProperty("categoryCode") long categoryCode, @JsonProperty("number") String number, @JsonProperty("operator") String operator, @JsonProperty("to") String to, @JsonProperty("passList") PassList[] passList){
            this.stop = stop;
            this.name = name;
            this.category = category;
            this.subcategory = subcategory;
            this.categoryCode = categoryCode;
            this.number = number;
            this.operator = operator;
            this.to = to;
            this.passList = passList;
        }

        public static final class Stop {
            public final Station station;
            public final Arrival arrival;
            public final ArrivalTimestamp arrivalTimestamp;
            public final String departure;
            public final long departureTimestamp;
            public final Delay delay;
            public final String platform;
            public final Prognosis prognosis;
            public final RealtimeAvailability realtimeAvailability;
            public final Location location;

            @JsonCreator
            public Stop(@JsonProperty("station") Station station, @JsonProperty("arrival") Arrival arrival, @JsonProperty("arrivalTimestamp") ArrivalTimestamp arrivalTimestamp, @JsonProperty("departure") String departure, @JsonProperty("departureTimestamp") long departureTimestamp, @JsonProperty("delay") Delay delay, @JsonProperty("platform") String platform, @JsonProperty("prognosis") Prognosis prognosis, @JsonProperty("realtimeAvailability") RealtimeAvailability realtimeAvailability, @JsonProperty("location") Location location){
                this.station = station;
                this.arrival = arrival;
                this.arrivalTimestamp = arrivalTimestamp;
                this.departure = departure;
                this.departureTimestamp = departureTimestamp;
                this.delay = delay;
                this.platform = platform;
                this.prognosis = prognosis;
                this.realtimeAvailability = realtimeAvailability;
                this.location = location;
            }

            public static final class Station {
                public final String id;
                public final String name;
                public final Score score;
                public final Coordinate coordinate;
                public final Distance distance;

                @JsonCreator
                public Station(@JsonProperty("id") String id, @JsonProperty("name") String name, @JsonProperty("score") Score score, @JsonProperty("coordinate") Coordinate coordinate, @JsonProperty("distance") Distance distance){
                    this.id = id;
                    this.name = name;
                    this.score = score;
                    this.coordinate = coordinate;
                    this.distance = distance;
                }

                public static final class Score {

                    @JsonCreator
                    public Score(){
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

                public static final class Distance {

                    @JsonCreator
                    public Distance(){
                    }
                }
            }

            public static final class Arrival {

                @JsonCreator
                public Arrival(){
                }
            }

            public static final class ArrivalTimestamp {

                @JsonCreator
                public ArrivalTimestamp(){
                }
            }

            public static final class Delay {

                @JsonCreator
                public Delay(){
                }
            }

            public static final class Prognosis {
                public final Platform platform;
                public final Arrival arrival;
                public final Departure departure;
                public final long capacity1st;
                public final long capacity2nd;

                @JsonCreator
                public Prognosis(@JsonProperty("platform") Platform platform, @JsonProperty("arrival") Arrival arrival, @JsonProperty("departure") Departure departure, @JsonProperty("capacity1st") long capacity1st, @JsonProperty("capacity2nd") long capacity2nd){
                    this.platform = platform;
                    this.arrival = arrival;
                    this.departure = departure;
                    this.capacity1st = capacity1st;
                    this.capacity2nd = capacity2nd;
                }

                public static final class Platform {

                    @JsonCreator
                    public Platform(){
                    }
                }

                public static final class Arrival {

                    @JsonCreator
                    public Arrival(){
                    }
                }

                public static final class Departure {

                    @JsonCreator
                    public Departure(){
                    }
                }
            }

            public static final class RealtimeAvailability {

                @JsonCreator
                public RealtimeAvailability(){
                }
            }

            public static final class Location {
                public final String id;
                public final String name;
                public final Score score;
                public final Coordinate coordinate;
                public final Distance distance;

                @JsonCreator
                public Location(@JsonProperty("id") String id, @JsonProperty("name") String name, @JsonProperty("score") Score score, @JsonProperty("coordinate") Coordinate coordinate, @JsonProperty("distance") Distance distance){
                    this.id = id;
                    this.name = name;
                    this.score = score;
                    this.coordinate = coordinate;
                    this.distance = distance;
                }

                public static final class Score {

                    @JsonCreator
                    public Score(){
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

                public static final class Distance {

                    @JsonCreator
                    public Distance(){
                    }
                }
            }
        }

        public static final class PassList {
            public final Station station;
            public final String arrival;
            public final long arrivalTimestamp;
            public final String platform;
            public final Prognosis prognosis;
            public final Location location;

            @JsonCreator
            public PassList(@JsonProperty("station") Station station, @JsonProperty("arrival") String arrival, @JsonProperty("arrivalTimestamp") long arrivalTimestamp, @JsonProperty("platform") String platform, @JsonProperty("prognosis") Prognosis prognosis, @JsonProperty("location") Location location){
                this.station = station;
                this.arrival = arrival;
                this.arrivalTimestamp = arrivalTimestamp;
                this.platform = platform;
                this.prognosis = prognosis;
                this.location = location;
            }

            public static final class Station {
                public final String id;
                public final String name;
                public final Score score;
                public final Coordinate coordinate;
                public final Distance distance;

                @JsonCreator
                public Station(@JsonProperty("id") String id, @JsonProperty("name") String name, @JsonProperty("score") Score score, @JsonProperty("coordinate") Coordinate coordinate, @JsonProperty("distance") Distance distance){
                    this.id = id;
                    this.name = name;
                    this.score = score;
                    this.coordinate = coordinate;
                    this.distance = distance;
                }

                public static final class Score {

                    @JsonCreator
                    public Score(){
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

                public static final class Distance {

                    @JsonCreator
                    public Distance(){
                    }
                }
            }

            public static final class Prognosis {
                public final Platform platform;
                public final Arrival arrival;
                public final Departure departure;
                public final Capacity1st capacity1st;
                public final Capacity2nd capacity2nd;

                @JsonCreator
                public Prognosis(@JsonProperty("platform") Platform platform, @JsonProperty("arrival") Arrival arrival, @JsonProperty("departure") Departure departure, @JsonProperty("capacity1st") Capacity1st capacity1st, @JsonProperty("capacity2nd") Capacity2nd capacity2nd){
                    this.platform = platform;
                    this.arrival = arrival;
                    this.departure = departure;
                    this.capacity1st = capacity1st;
                    this.capacity2nd = capacity2nd;
                }

                public static final class Platform {

                    @JsonCreator
                    public Platform(){
                    }
                }

                public static final class Arrival {

                    @JsonCreator
                    public Arrival(){
                    }
                }

                public static final class Departure {

                    @JsonCreator
                    public Departure(){
                    }
                }

                public static final class Capacity1st {

                    @JsonCreator
                    public Capacity1st(){
                    }
                }

                public static final class Capacity2nd {

                    @JsonCreator
                    public Capacity2nd(){
                    }
                }
            }

            public static final class Location {
                public final String id;
                public final String name;
                public final Score score;
                public final Coordinate coordinate;
                public final Distance distance;

                @JsonCreator
                public Location(@JsonProperty("id") String id, @JsonProperty("name") String name, @JsonProperty("score") Score score, @JsonProperty("coordinate") Coordinate coordinate, @JsonProperty("distance") Distance distance){
                    this.id = id;
                    this.name = name;
                    this.score = score;
                    this.coordinate = coordinate;
                    this.distance = distance;
                }

                public static final class Score {

                    @JsonCreator
                    public Score(){
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

                public static final class Distance {

                    @JsonCreator
                    public Distance(){
                    }
                }
            }
        }
    }
}