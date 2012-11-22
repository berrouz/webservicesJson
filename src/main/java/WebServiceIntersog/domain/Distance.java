package WebServiceIntersog.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
public class Distance {

    @Id
    private int id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Distance)) return false;

        Distance distance1 = (Distance) o;

        if (distance != distance1.distance) return false;
        if (id != distance1.id) return false;
        if (cityA != null ? !cityA.equals(distance1.cityA) : distance1.cityA != null) return false;
        if (cityB != null ? !cityB.equals(distance1.cityB) : distance1.cityB != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (cityA != null ? cityA.hashCode() : 0);
        result = 31 * result + (cityB != null ? cityB.hashCode() : 0);
        result = 31 * result + distance;
        return result;
    }

    @Override
    public String toString() {
        return "Distance{" +
                "id=" + id +
                ", cityA='" + cityA + '\'' +
                ", cityB='" + cityB + '\'' +
                ", distance=" + distance +
                '}';
    }
}
