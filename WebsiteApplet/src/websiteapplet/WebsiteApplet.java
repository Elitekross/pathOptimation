/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package websiteapplet;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Meyer
 */
public class WebsiteApplet {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        JFrame window = new JFrame("GUI Test");
        WebJPanel content = new WebJPanel();
        window.setContentPane(content);
        window.setPreferredSize(new Dimension(content.getPreferredSize().height, content.getPreferredSize().width));
        window.setMinimumSize(new Dimension(content.getPreferredSize().height, content.getPreferredSize().width));
        window.setMaximumSize(new Dimension(content.getPreferredSize().height, content.getPreferredSize().width));
        window.setSize(window.getPreferredSize());
        window.setLocation(100,100);
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        window.setVisible(true);
    }
    
}
