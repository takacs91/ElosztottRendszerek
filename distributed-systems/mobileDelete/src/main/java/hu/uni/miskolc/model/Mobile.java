package hu.uni.miskolc.model;

public class Mobile {
    private String model;
    private String releaseDate;
    private Brand brand;

    public Mobile(String model, String releaseDate, Brand brand) {
        this.model = model;
        this.releaseDate = releaseDate;
        this.brand = brand;
    }

    public Mobile() {}

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
