/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.dawgoogle.categories;

import java.util.ArrayList;
import java.util.List;
import pedro.ieslaencanta.com.dawgoogle.services.ValidateError;

/**
 *
 * @author Administrador
 */
public class CategoriesService {

    private static CategoriesService service;

    private CategoryRepository repository;

    private CategoriesService() {
        super();
        this.repository = new CategoryRepository();

        this.init();
    }

    private void init() {
        Category tempo;

        tempo = new Category();
        tempo.setImage_path("uno.png");
        tempo.setName("tendencias");
        tempo.setId(tempo.getName().hashCode());
        this.add(tempo);

        //nueva categoria
        tempo = new Category();
        tempo.setImage_path("dos.png");
        tempo.setName("música");
        tempo.setId(tempo.getName().hashCode());
        this.add(tempo);
        //nueva categoria
        tempo = new Category();
        tempo.setImage_path("dos.png");
        tempo.setName("películas");
        tempo.setId(tempo.getName().hashCode());
        this.add(tempo);
        //nueva categoria
        tempo = new Category();
        tempo.setImage_path("tres.png");
        tempo.setName("videojuegos");
        tempo.setId(tempo.getName().hashCode());
        this.add(tempo);
    }

    public static CategoriesService getIntance() {
        if (service == null) {
            service = new CategoriesService();
        }
        return service;
    }

    public List<Category> getAll() {
        return this.repository.getAll();
    }

    public Category getById(int id) {
        return this.repository.getById(id);
    }

    public Category getByName(String name) {
        return this.repository.getByKey(name);
    }

    public List<ValidateError> add(Category item) {
        ArrayList<ValidateError> errors = new ArrayList();
        if (item.getImage_path() == null) {
            errors.add(new ValidateError("ImagePath", " is null"));
        }
        if (item.getName() == null) {
            errors.add(new ValidateError("Name", " is null"));
        }
        if (errors.isEmpty()) {
            item.setId(item.getName().hashCode());
            this.repository.add(item);
        }
        return errors;
    }

    public List<Category> find(String s) {

        return this.repository.find(s);
    }

    public int count() {
        return this.repository.count();
    }

    public void remove(Category item) {

        this.repository.remove(item);

    }

    public void remove(String name) {
        Category item = this.repository.getByKey(name);
        if (item != null) {
            this.repository.removeByKey(name);

        }
    }

    public void update(Category item) {
        this.repository.removeById(item.getId());
        this.repository.add(item);
    }

}
