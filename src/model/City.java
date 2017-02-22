package model;

public class City {
    private String postalcode;
    private String name;

    public City(String postalcode, String name) {
        this.postalcode = postalcode;
        this.name = name;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
