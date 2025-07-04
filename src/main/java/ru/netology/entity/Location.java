package ru.netology.entity;

public class Location {

    private final String city;

    private final Country country;

    private final String street;

    private final int building;

    public Location(String city, Country country, String street, int building) {
        this.city = city;
        this.country = country;
        this.street = street;
        this.building = building;
    }

    public String getCity() {
        return city;
    }

    public Country getCountry() {
        return country;
    }

    public String getStreet() {
        return street;
    }

    public int getBuilding() {
        return building;
    }

    @Override
    public boolean equals(Object obj) {
        Location l = (Location) obj;
        return (this.country == null && l.country == null || this.country.equals(l.country)) &&
               this.city.equals(l.city) &&
               (this.street == null && l.street == null ||  this.street.equals(l.street) )&&
               this.building == l.building;
    }
}
