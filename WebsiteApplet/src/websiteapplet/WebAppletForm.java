/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package websiteapplet;

/**
 *
 * @author Meyer
 */
import javax.swing.JApplet;

public class WebAppletForm extends JApplet {
    @Override
    public void init() {  
        WebJPanel content = new WebJPanel();
        setContentPane(content);
   }
}
