/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.dawgoogle.categories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import pedro.ieslaencanta.com.dawgoogle.entities.IEntity;

/**
 *
 * @author Pedro
 */
public class Category implements IEntity<String, Integer> {

    private String name;
    private int id;
    private String image_path;

    public Category() {
    
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getKey() {
        return this.name;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

     @Override
    public String toString() {
        return "ID:" + this.id + " NAME:" + this.name + " IMAGE:" + this.image_path+ " Nº Videos:"+"?";
    }
}
