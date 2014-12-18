/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gruppe7.admintool.view;
import org.gruppe7.admintool.view.GraphicalUserInterface;
import java.sql.*;
/**
 *
 * @author Paul
 */
public class AdminTool {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GraphicalUserInterface gui = new GraphicalUserInterface();
	gui.setVisible(true);
        
    }
}
