package net.map.domain;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
public class MapPoint {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(name="description", columnDefinition="TEXT")
    private String description;
    private double lat;
    private double lng;
    @ManyToOne
    private Category category;
    private String image;
    private String url;
    private String icon;

    @ManyToOne
    private Type type;

    @SuppressWarnings("unused")
    public MapPoint() {
    }

    public MapPoint(String name, String description, Category category, double lat, double lng) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.icon = category.getIcon();
        this.lat = lat;
        this.lng = lng;
    }

    public MapPoint(String name, String description, Category category, double lat, double lng, String image, String url, String icon) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.lat = lat;
        this.lng = lng;
        this.image = image;
        this.url = url;
        this.icon = icon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) { this.icon = icon; }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
        this.icon = type.getIcon(); // Rewrite category icon for type icon
    }


    @Override
    public String toString() {
        return "Map point: {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
