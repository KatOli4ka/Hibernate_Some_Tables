package entity;
import javax.persistence.*;


import java.util.Objects;
@Entity
@Table(name = "city")

public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "city_id",nullable = false)
    private long cityId;
    @Column (name = "city_name",nullable = false)
    private String cityName;

    public City(long cityId) {
    }

    public City(long cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public City() {

    }

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return cityId == city.cityId && Objects.equals(cityName, city.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId, cityName);
    }

    @Override
    public String toString() {
        return cityId +", cityName = " + cityName;
    }
}
