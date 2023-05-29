package fr.natan.cleanarchi_ms_address.domain.entity;

public class Address {
    private Long addressID;
    private int num;
    private String street;
    private int pb;
    private String city;
    private String country;

    public Address(Long id, int num, String street, int pb, String city, String country) {
        this.addressID = id;
        this.num = num;
        this.street = street;
        this.pb = pb;
        this.city = city;
        this.country = country;
    }

    public Address() {
    }

    public Long getAddressID() {
        return addressID;
    }

    public int getNum() {
        return num;
    }

    public String getStreet() {
        return street;
    }

    public int getPb() {
        return pb;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public void setAddressID(Long addressID) {
        this.addressID = addressID;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setPb(int pb) {
        this.pb = pb;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
