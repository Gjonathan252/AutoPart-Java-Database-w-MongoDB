package com.example.autopartsjavamongodb;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;

public class main {
    public static void main(String[] args) {
        Client server = new Client();
        server.search();
    }
}