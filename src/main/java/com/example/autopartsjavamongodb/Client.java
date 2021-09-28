package com.example.autopartsjavamongodb;

import com.mongodb.client.*;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class  Client {
    private final static String Serverid = "mongodb+srv://gjonathan:123@cluster0.nceor.mongodb.net/InventoryDB?retryWrites=true&w=majority";
    private final static String DatabaseName = "InventoryDB";
    public String getServerid()
    {
        return Serverid;
    }
    public String getDatabaseName()
    {
        return DatabaseName;
    }
    MongoClient client = MongoClients.create(getServerid());
    MongoDatabase db = client.getDatabase(getDatabaseName());

    public Client()
    {
        MongoClient client = MongoClients.create(getServerid());
        MongoDatabase db = client.getDatabase(getDatabaseName());
    }
    public void search(){
        while (true) {
            System.out.println("\nWelcome to AutoParts Database \nSelect from the following choices.");
            SearchDB searchDB = new SearchDB(); //Creating Constructor.
            searchDB.createSelection(); //Making Selection
            if (searchDB.isSearchORadd()) //bool check = true. Running option 1. Searching parts in DB
            {
                searchDB.createSearch();
                MongoCollection<Document> SS = db.getCollection(searchDB.getsNum());// Gets store number
                if (searchDB.getInputCheck().equals("1"))
                {
                    try (MongoCursor<Document> cursor = SS.find().iterator()) {
                        while (cursor.hasNext()) {
                            System.out.println(cursor.next().toJson());
                        }
                    }
                }
                else if (searchDB.getInputCheck().equals("2")){
                    try (MongoCursor<Document> cursor = SS.find(eq("Make", searchDB.getsMake())).iterator()) {
                        while (cursor.hasNext()) {
                            System.out.println(cursor.next().toJson());
                        }
                    }
                }
                else if (searchDB.getInputCheck().equals("3"))
                {
                    Document document = searchDB.searchDocAppend();
                    try (MongoCursor<Document> cursor = SS.find(document).iterator()) {
                        while (cursor.hasNext()) {
                            System.out.println(cursor.next().toJson());
                        }
                    }
                }
                System.out.println("Document successfully searched");
            }
            else if (!searchDB.isSearchORadd()) //bool check = false. Running option 2. Adding part
            {
                searchDB.createTable(); //Collects Information for adding new part
                MongoCollection<Document> col = db.getCollection(searchDB.getStoreNum()); //Sets collection name.
                Document document = new Document(searchDB.DocAppend()); //Creates Doc in constructor. Appends all information.
                col.insertOne(document); //Pushes document to database.
                System.out.println("Document inserted successfully");
            }
        }
    }

}
