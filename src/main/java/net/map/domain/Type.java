package net.map.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by pingwin on 06.11.16.
 */
@Entity
public class Type {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String icon;

    @SuppressWarnings("unused")
    public Type(){}

    public Type(String name, String icon){
        this.name = name;
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


    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }


}
