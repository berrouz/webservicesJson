package shevchik.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Distance {

    private String cityA;
    private String cityB;
    private int distance;

    public String getCityA() {
        return cityA;
    }

    public void setCityA(String cityA) {
        this.cityA = cityA;
    }

    public String getCityB() {
        return cityB;
    }

    public void setCityB(String cityB) {
        this.cityB = cityB;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Distance)) return false;

        Distance distance1 = (Distance) o;

        if (distance != distance1.distance) return false;
        if (!cityA.equals(distance1.cityA)) return false;
        if (!cityB.equals(distance1.cityB)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cityA.hashCode();
        result = 31 * result + cityB.hashCode();
        result = 31 * result + distance;
        return result;
    }

    @Override
    public String toString() {
        return "Distance{" +
                "cityA='" + cityA + '\'' +
                ", cityB='" + cityB + '\'' +
                ", distance=" + distance +
                '}';
    }
}