package com.steenbjerg;

import com.mongodb.*;

import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 * User: dan
 * Date: 02-03-13
 * Time: 18:57
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorld {
    public static void main( String[] args ) throws UnknownHostException {
        MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));

        DB database = client.getDB("course");
        DBCollection collection = database.getCollection("hello");

        DBObject document = collection.findOne();
        System.out.println(document);
    }
}
