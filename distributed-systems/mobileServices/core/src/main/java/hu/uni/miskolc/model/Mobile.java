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

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof  Mobile)){
            return false;
        }
        return model.equals(((Mobile)obj).model) && releaseDate.equals(((Mobile)obj).releaseDate);
    }
}
