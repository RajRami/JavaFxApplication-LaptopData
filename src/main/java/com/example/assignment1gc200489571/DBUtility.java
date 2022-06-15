package com.example.assignment1gc200489571;

import javafx.scene.chart.XYChart;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class DBUtility {
    private static String user = DBCredentials.user;
    private static String password = DBCredentials.password;

    //AWS connection
    private static String connectURL = "jdbc:mysql://172.31.22.43:3306/Raj200489571";

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

    /**
     * It will return a laptops by brand and their price
     * @return
     */
    public static XYChart.Series<String, Double> getLaptopsByBrand() {
        XYChart.Series<String, Double> series = new XYChart.Series<>();
        series.setName("Brands");

        String sql = "SELECT brand, price FROM LaptopData " +
                "WHERE brand IN ('HP','Lenovo','Acer','ASUS','DELL','LG') " +
                "ORDER BY brand;";

        try(
                Connection conn = DriverManager.getConnection(connectURL,user,password);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            while (resultSet.next())
            {
                String brand = resultSet.getString("brand");
                double price = resultSet.getDouble("price");

                series.getData().add(new XYChart.Data<>(brand, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return series;
    }
}
