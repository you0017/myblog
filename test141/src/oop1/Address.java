package oop1;

public class Address {
    private String privince;
    private String city;
    private int postCode;

    @Override
    public String toString() {
        return "Address{" +
                "privince='" + privince + '\'' +
                ", city='" + city + '\'' +
                ", Postcode=" + postCode +
                '}';
    }

    public Address() {
    }

    public Address(String privince, String city, int postcode) {
        this.privince = privince;
        this.city = city;
        this.postCode = postcode;
    }

    public String getPrivince() {
        return privince;
    }

    public void setPrivince(String privince) {
        this.privince = privince;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostcode() {
        return postCode;
    }

    public void setPostcode(int postcode) {
        this.postCode = postcode;
    }
}
