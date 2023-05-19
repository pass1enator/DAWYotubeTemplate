/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.dawgoogle.categories;

import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellDependent;
import asg.cliche.ShellFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;


/**
 *
 * @author Pedro
 */
public class CategoriesShellController implements ShellDependent {

    private Shell shell;
    private String name = "categorias";
     private CategoryShellController categoryshell;
    private CategoriesService service;

    public CategoriesShellController() {
        this.service = CategoriesService.getIntance();

    }

    @Command
    public void add(String name, String image_path) {
        Category c = new Category();
        c.setName(name);
        c.setImage_path(image_path);
        this.service.add(c);
    }

    @Command
    public List<Category> getAll() {
        return this.service.getAll();
    }

    @Command(description = "Devuelve una categoría por id")
    public Category get(
            @Param(name = "Id", description = "Id de la categoria") int id) {
        return this.service.getById(id);
    }

    @Command
    public void remove(String c) {
        this.service.remove(c);
    }

   @Command(description = "Selecciona una categoria en funcíon del nombre")
    public void select(String name) {
        Category c = this.service.getByName(name);
        if (c != null) {
            if (this.categoryshell == null) {
                try {
                    this.categoryshell = new CategoryShellController();
                    this.categoryshell.setSelected(c);
                    
                    ShellFactory.createSubshell("Category", this.shell, name,
                            this.categoryshell).commandLoop();
                } catch (IOException ex) {
                    Logger.getLogger(CategoriesShellController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    @Command
    public List<Category> findByName(String name) {
        return this.service.find(name);
    }
    @Command
    public void updateCategoryName(Category item) {
        this.service.update(item);

    }
    @Override
    public void cliSetShell(Shell shell) {
        this.shell = shell;
    }

}
