package com.example.autopartsjavamongodb;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;

public class main {
    public static void main(String[] args){
        System.out.println("hello world");
        Client server = new Client();
        MongoClient client = MongoClients.create(server.getServerid());
        MongoDatabase db = client.getDatabase(server.getDatabaseName());

        while (true) {
            System.out.println("Welcome to AutoParts Database \nSelect from the following choices.");
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
