package com.example.autopartsjavamongodb;

import org.bson.Document;
import java.util.Scanner;

public class SearchDB extends Doc{
    private String selection;
    private String inputCheck;
    private boolean searchORadd; //ture = search. false = add
    private String sNum; //store number string
    private String sMake; //car manufacture string
    private String sYear;
    private String sModel;
    private String sPart;

    public SearchDB()
    {
    }
    public void createSearch()
    {
        Scanner input = new Scanner(System.in);
        boolean check = false;
        while (!check) {
            System.out.println("\n" +
                    "1. Search by store\n" +
                    "2. Search by Manufacture\n" +
                    "3. Search by car + part");
            inputCheck = input.nextLine();
            if (inputCheck.equals("1") || inputCheck.equals("2") || inputCheck.equals("3")) {
                check = true;
            }
        }
        boolean storeCheck = false;
        while (!storeCheck) {
            System.out.println("Enter store Number (4 digits):");
            sNum = input.nextLine();
            if (sNum.length() == 4){
                storeCheck = true;
            }
        }
        switch (inputCheck) {
            case "1": {break;} //All cases required storeCheck, so it was moved outside this scope.
            case "2": {
                System.out.println("Enter cars manufacture.");
                sMake = input.nextLine();
                sMake = sMake.toUpperCase();
                break;
            }
            case "3": {
                System.out.println("Enter car year");
                sYear = input.nextLine();
                System.out.println("Enter Manufacture");
                sMake = input.nextLine();
                sMake = sMake.toUpperCase();
                System.out.println("Enter Model");
                sModel = input.nextLine();
                sModel = sModel.toUpperCase();
                System.out.println("Enter Part");
                sPart = input.nextLine();
                sPart = sPart.toUpperCase();
                break;
            }
            default: System.out.println("wow its broken");
        }

    }
    public void createSelection()
    {
        Scanner input = new Scanner(System.in);
        boolean correct_selection = false;
        while (!correct_selection) {
            System.out.println("1. Search for car parts! \n2. Add parts to database!");
            selection = input.nextLine();
            if (selection.equals("1"))
            {
                searchORadd = true; //Option 1. Search
                correct_selection = true;
            }
            if (selection.equals("2"))
            {
                searchORadd = false; //Option 2. Add part
                correct_selection = true;
            }
        }
    }

    public Document searchDocAppend() {
        Document document = new Document();
        document.append("Year", sYear);
        document.append("Make", sMake);
        document.append("Model", sModel);
        document.append("Part", sPart);
        return document;
    }

    public String getSelection(){ return selection; }
    public boolean isSearchORadd(){ return searchORadd; }
    public String getsNum(){ return sNum; }
    public String getInputCheck() { return inputCheck; }

    public String getsMake() {
        return sMake;
    }
    public void setsMake(String sMake) {
        this.sMake = sMake;
    }

    public String getsYear() {
        return sYear;
    }

    public void setsYear(String sYear) {
        this.sYear = sYear;
    }

    public String getsModel() {
        return sModel;
    }

    public void setsModel(String sModel) {
        this.sModel = sModel;
    }

    public String getsPart() {
        return sPart;
    }

    public void setsPart(String sPart) {
        this.sPart = sPart;
    }

}
