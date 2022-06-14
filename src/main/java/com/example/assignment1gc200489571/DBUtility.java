package com.example.assignment1gc200489571;

import javafx.scene.chart.XYChart;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class DBUtility {
    private static String user = DBCredentials.user;
    private static String password = DBCredentials.password;
    private static String connectURL = "jdbc:mysql://localhost:3306/assignment1";

    /**
     * It will return a list of all the laptop in the Database
     */
    public static ArrayList<Laptop> getLaptopsFromDB()
    {
        ArrayList<Laptop> laptops = new ArrayList<>();

        String sql = "SELECT * FROM LaptopData;";

        try(
                Connection conn = DriverManager.getConnection(connectURL,user,password);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            while (resultSet.next())
            {
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                String processorBrand = resultSet.getString("processorBrand");
                String processorName = resultSet.getString("processorName");
                int generation = resultSet.getInt("generation");
                int ram = resultSet.getInt("ram");
                int ssd = resultSet.getInt("ssd");
                int hdd = resultSet.getInt("hdd");
                String os = resultSet.getString("os");
                int osBit = resultSet.getInt("osBit");
                double price = resultSet.getDouble("price");

                laptops.add(new Laptop(brand,model,processorBrand,processorName,generation,ram,ssd,hdd,os,osBit, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return laptops;
    }


    }
