package com.example.autopartsjavamongodb;

public class  Client {
    private final static String Serverid = "mongodb+srv://gjonathan:123@cluster0.nceor.mongodb.net/InventoryDB?retryWrites=true&w=majority";
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