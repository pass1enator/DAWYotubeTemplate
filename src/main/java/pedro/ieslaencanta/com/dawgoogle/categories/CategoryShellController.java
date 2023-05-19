/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.dawgoogle.categories;


import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellDependent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 *
 * @author Pedro
 */
public class CategoryShellController implements ShellDependent {

    private Shell shell;
    private String name = "categoria";
    private CategoryService service;
   
    public CategoryShellController() {
        this.service = CategoryService.getIntance();
       
    }

   
    public void setSelected(Category c) {
        this.service.setSelected(c);
        this.name = c.getName();
       
    }

    @Command
    public Category getSelected() {
        return service.getSelected();
    }

  

    @Override
    public void cliSetShell(Shell shell) {
        this.shell = shell;
         this.shell.setAppName(this.name);
    }

}
