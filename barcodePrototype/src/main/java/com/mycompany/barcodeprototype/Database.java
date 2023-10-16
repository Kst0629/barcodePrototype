/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.barcodeprototype;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author dmitr
 */
public class Database {
    public ArrayList<Data> items = new ArrayList<>();
    
    public Database(){
        connectToDatabase();
    }
    
    public Database(String barcode, String name){
        addNewItem(barcode,name);
    }
    
    private void connectToDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "AUT4events_!");
            System.out.println("Connected to Database");
//here sonoo is database name, root is username and password  
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from ITEMS");
            while (rs.next()) {
                System.out.println(rs.getLong(1) + "  " + rs.getString(2));
                Data item = new Data(rs.getString(1), rs.getString(2));
                this.items.add(item);
            }
            con.close();
        } catch (Exception e) {
            System.out.println("CAN\'T CONNECT TO DATABASE!! Using local data");
            items.add(new Data( "9415947039036", "Soft Notebook"));
            items.add(new Data("9414952106030", "Hard Notebook"));
        }
    }
    
    private void addNewItem(String barcode, String name){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "AUT4events_!");
            System.out.println("Connected to Database");
//here sonoo is database name, root is username and password  
            Statement stmt = con.createStatement();
            PreparedStatement prepStmt = con.prepareStatement("insert into items (itemID, itemName)"
                                               +" values (?, ?)");
            prepStmt.setString(1, barcode);
            prepStmt.setString(2, name);
            prepStmt.execute();
            //ResultSet rs = stmt.executeQuery("select * from ITEMS");
            /*while (rs.next()) {
                System.out.println(rs.getLong(1) + "  " + rs.getString(2));
                Data item = new Data(rs.getString(1), rs.getString(2));
                this.items.add(item);
            }*/
            System.out.println("Information added");
            con.close();
        } catch (Exception e) {
            System.out.println("CAN\'T CONNECT TO DATABASE!! Can\'t add new Item");
        }
    }
}
