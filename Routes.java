public class Routes {

    private String source;
    private String destination;
    private int distance;
    private String time;
    private String airFare;


    public Routes(String source, String destination, int distance, String time, String airFare) {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.time = time;
        this.airFare = airFare;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAirFare() {
        return airFare;
    }

    public void setAirFare(String airFare) {
        this.airFare = airFare;
    }

    @Override
    public String toString() {
        return "Routes{" +
                "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", distance=" + distance +
                ", time='" + time + '\'' +
                ", airFare='" + airFare + '\'' +
                '}';
    }
}
