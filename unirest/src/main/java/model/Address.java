package model;

import java.util.Objects;

public class Address {

    public String street;
    public String suite;
    public String city;
    public String zipcode;
    public Geo geo;

    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public Geo getGeo() {
        return geo;
    }

    public Address(String street, String suite, String city, String zipcode, Geo geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", suite='" + suite + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", geo=" + geo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(street, address.street)
                && Objects.equals(suite, address.suite)
                && Objects.equals(city, address.city)
                && Objects.equals(zipcode, address.zipcode)
                && Objects.equals(geo, address.geo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, suite, city, zipcode, geo);
    }
}
