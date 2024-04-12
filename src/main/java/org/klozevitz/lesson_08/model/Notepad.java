package org.klozevitz.lesson_08.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Notepad {
    private Integer id;
    private String brand;
    private String model;
    private int pageAmount;
    private String cover;
    private String country;
    private String pageType;

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getPageAmount() {
        return pageAmount;
    }

    public String getCover() {
        return cover;
    }

    public String getCountry() {
        return country;
    }

    public String getPageType() {
        return pageType;
    }

    public Notepad(String brand, String model, int pageAmount, String cover, String country, String pageType) {
        this.brand = brand;
        this.model = model;
        this.pageAmount = pageAmount;
        this.cover = cover;
        this.country = country;
        this.pageType = pageType;
    }

    public Notepad(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.brand = resultSet.getString("brand");
        this.model = resultSet.getString("model");
        this.pageAmount = resultSet.getInt("pageAmount");
        this.cover = resultSet.getString("cover");
        this.country = resultSet.getString("country");
        this.pageType = resultSet.getString("pageType");
    }

    @Override
    public String toString() {
        return "Notepad{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", pagesAmount=" + pageAmount +
                ", cover='" + cover + '\'' +
                ", country='" + country + '\'' +
                ", pageType='" + pageType + '\'' +
                '}';
    }
}
