package WebServiceIntersog.domain;

import java.math.BigDecimal;

public class Distance {
    private String cityA;
    private String cityB;
    private BigDecimal distance;

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

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Distance distance1 = (Distance) o;

        if (cityA != null ? !cityA.equals(distance1.cityA) : distance1.cityA != null) return false;
        if (cityB != null ? !cityB.equals(distance1.cityB) : distance1.cityB != null) return false;
        if (distance != null ? !distance.equals(distance1.distance) : distance1.distance != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cityA != null ? cityA.hashCode() : 0;
        result = 31 * result + (cityB != null ? cityB.hashCode() : 0);
        result = 31 * result + (distance != null ? distance.hashCode() : 0);
        return result;
    }
}
