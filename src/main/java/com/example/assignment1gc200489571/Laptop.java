package com.example.assignment1gc200489571;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class Laptop {
    /**
     * Create instance variables of our model class
     */
    private String brand, model, processorBrand, processorName;
    private int generation, ram, ssd, hdd;
    private String os;
    private int osBit;
    private double price;

    /**
     * Creating a constructor of model class
     * @param brand
     * @param model
     * @param processorBrand
     * @param processorName
     * @param generation
     * @param ram
     * @param ssd
     * @param hdd
     * @param os
     * @param osBit
     * @param price
     */
    public Laptop(String brand, String model, String processorBrand, String processorName, int generation, int ram, int ssd, int hdd, String os, int osBit, double price) {
        setBrand(brand);
        setModel(model);
        setProcessorBrand(processorBrand);
        setProcessorName(processorName);
        setGeneration(generation);
        setRam(ram);
        setSsd(ssd);
        setHdd(hdd);
        setOs(os);
        setOsBit(osBit);
        setPrice(price);
    }
    /**
     * Creating Getters methods for all instance variables
     */
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getProcessorBrand() {
        return processorBrand;
    }

    public String getProcessorName() {
        return processorName;
    }

    public int getGeneration() {
        return generation;
    }

    public int getRam() {
        return ram;
    }

    public int getSsd() {
        return ssd;
    }

    public int getHdd() {
        return hdd;
    }

    public String getOs() {
        return os;
    }

    public int getOsBit() {
        return osBit;
    }

    public double getPrice() {
        return price;
    }
    public String getPriceString()
    {
        Locale country = new Locale("en","IN");
        Currency rupees = Currency.getInstance(country);
        return NumberFormat.getCurrencyInstance(country).format(price);
    }

    /**
     * Creating set methods for all instance variables
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setProcessorBrand(String processorBrand) {
        this.processorBrand = processorBrand;
    }

    public void setProcessorName(String processorName) {
        this.processorName = processorName;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setSsd(int ssd) {
        this.ssd = ssd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setOsBit(int osBit) {
        this.osBit = osBit;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
