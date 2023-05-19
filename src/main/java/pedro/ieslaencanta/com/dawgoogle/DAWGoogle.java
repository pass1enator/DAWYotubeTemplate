/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pedro.ieslaencanta.com.dawgoogle;

import asg.cliche.Command;
import asg.cliche.Shell;
import asg.cliche.ShellDependent;
import asg.cliche.ShellFactory;
import java.io.IOException;
import pedro.ieslaencanta.com.dawgoogle.categories.CategoriesShellController;

/**
 *
 * @author Pedro
 */
public class DAWGoogle implements ShellDependent {

     private Shell shell;
    private CategoriesShellController categoriescontroller;

    @Command
   public void categories() throws IOException{
       if(this.categoriescontroller==null)
           this.categoriescontroller=new CategoriesShellController();
       ShellFactory.createSubshell("Categories", this.shell, "Categories",
               this.categoriescontroller).commandLoop();
       
   }

    public static void main(String[] args) throws IOException {
        ShellFactory.createConsoleShell("DAW>", "?list to list all commands\\\"", new DAWGoogle())
                .commandLoop(); // and three.
    }

    @Override
    public void cliSetShell(Shell shell) {
        this.shell = shell;
    }
}
