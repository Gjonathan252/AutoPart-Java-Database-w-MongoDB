package com.example.autopartsjavamongodb;

public class  Client {
    private final static String Serverid = "";
    private final static String DatabaseName = "InventoryDB";
    public Client()
    {
    }
    //    public Client(String server, String DBN)
//    {
//        Serverid = server;
//        DatabaseName = DBN;
//    }
    public String getServerid()
    {
        return Serverid;
    }
    public String getDatabaseName()
    {
        return DatabaseName;
    }
}
