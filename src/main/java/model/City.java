package model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private int cityId;
    @Column(name = "city_name")
    private String cityName;
    @OneToMany(mappedBy = "cityId", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public City(String cityName) {
        this.cityName = cityName;
    }

    public City() {

    }

    public int getCityId() {
        return cityId;
    }

    public City setCityId(int cityId) {
        this.cityId = cityId;
        return this;
    }

    public String getCityName() {
        return cityName;
    }

    public City setCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return cityId == city.cityId && cityName.equals(city.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId, cityName);
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
