package com.example.autopartsjavamongodb;

import org.bson.Document;
import java.util.Scanner;

public class Doc {
    private String Make;
    private String Model;
    private String Part;
    private String StoreNum;
    private String Year;

    public Doc()
    {
    }
    public Doc(String Cmake, String Cyear, String Dmodel, String Dpart, String DstoreNum)
    {
        Make = Cmake;
        Year = Cyear;
        Model = Dmodel;
        Part = Dpart;
        StoreNum = DstoreNum;
    }
    public Document DocAppend()
    {
        Document document = new Document();
        document.append("Year", Year);
        document.append("Make", Make);
        document.append("Model", Model);
        document.append("Part", Part);
        return document;
    }
    public void createTable()
    {
        Scanner input = new Scanner(System.in);
        boolean storeCheck = false;
        while (!storeCheck) {
            System.out.println("Location of parts \nStore Number (4 digits):");
            StoreNum = input.nextLine();
            if (StoreNum.length() == 4){
                storeCheck = true;
            }
        }
        boolean yearCheck = false;
        while (!yearCheck) {
            System.out.println("Year of car (4 digits):");
            Year = input.nextLine();
            if (Year.length() == 4){
                yearCheck = true;
            }
        }
        System.out.println("Make");
        Make = input.nextLine();
        Make = Make.toUpperCase();
        System.out.println("Model");
        Model = input.nextLine();
        Model = Model.toUpperCase();
        System.out.println("Part");
        Part = input.nextLine();
        Part = Part.toUpperCase();
    }

    public String getMake() { return Make; }
    public void setMake(String Make) { this.Make = Make; }

    public String getModel() { return Model; }
    public void setModel(String Model) { this.Model = Model; }

    public String getPart() { return Part; }
    public void setPart(String Part) { this.Part = Part; }

    public String getStoreNum() { return StoreNum; }
    public void setStoreNum(String StoreNum){ this.StoreNum = StoreNum; }

    public String getYear() { return Year; }
    public void setYear(String Year) { this.Year = Year; }




}
