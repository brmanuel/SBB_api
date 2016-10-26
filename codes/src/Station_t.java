import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by emfuthal on 26/10/16.
 */
@JsonIgnoreProperties({ "id", "score", "distance" })
public final class Station_t {
    public final String name;
    public final Coordinate coordinate;

    @JsonCreator
    public Station_t(@JsonProperty("name") String name, @JsonProperty("coordinate") Station_t.Coordinate coordinate) {
        this.name = name;
        this.coordinate = coordinate;
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
}

