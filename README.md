# AutoPart-Java-Database-w-MongoDB
Quick database project created using Java. Maven was used to intall MongoDB dependencies. This is a test project, testing mongodb tools with java.

This project was created with the intention of testing a few MongoDB tools with my database.
The Java code provided is not perfect as you can see there are many repeating values withing the classes.

If you are to use this here are few things you can do to improve the program. Clean the controctor classes.
Set Client so that the other constroctors classes extent its class.

Constructor 1 extends client {
Collects information for either searching database or adding to database
create all getters and setters
}

Constructor 2 extends (client or constructor 1) {
You can either use client constructor or this constructor to search and add to database.
Personally I would add this to client so that the client add directly to the database instead of using main to set up all this. 
I think it would also be best to create connection to dabase withing the constructor class. So when its created in main it is already connected if you want to add or search.
}
