/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package websiteapplet;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Meyer
 */
public class DisplayPanel extends JPanel {
      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         g.drawString( panelText, 0, 30 );
      }
       String panelText = "Please write your first name and birthday.";
       Font displayFont = new Font("Display", Font.BOLD, 16);
   }
