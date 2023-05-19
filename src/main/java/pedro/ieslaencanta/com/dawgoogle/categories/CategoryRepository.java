/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.dawgoogle.categories;

import java.util.List;
import java.util.Map;
import pedro.ieslaencanta.com.dawgoogle.repositories.AMapRepository;

/**
 *
 * @author Pedro
 */
public class CategoryRepository extends AMapRepository<Category,String,Integer> {
    public CategoryRepository(){
        super();
    }

    @Override
    public List<Category> find(String find) {
         
        String find_low = ".*"+find.toString().toLowerCase()+".*";
        return this.getElements().entrySet().stream().
                filter(e -> {
                    return e.getValue().getName().toLowerCase().matches(find_low);
                })
                .map(Map.Entry::getValue)
                .toList();
    }

    @Override
    public List<Category> find(Object... arg) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Category item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
