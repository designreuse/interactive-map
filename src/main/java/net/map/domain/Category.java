package net.map.domain;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

/**
 * Created by pingwin on 06.11.16.
 */
@Entity
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String image;
    private String url;
    private String description;
    private String icon;

    @SuppressWarnings("unused")
    public Category(){}

    public Category(String name, String description, String icon){
        this.name = name;
        this.description = description;
        this.icon = icon;
    }

    public Category(String name, String description, String icon, String image, String url){
        this.name = name;
        this.description = description;
        this.icon = icon;
        this.image = image;
        this.url = url;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }


}
