package com.steenbjerg;

import com.mongodb.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: dan
 * Date: 02-03-13
 * Time: 19:48
 * To change this template use File | Settings | File Templates.
 */
public class HelloMongoSparkFreemarker {
    public static void main( String[] args ) throws UnknownHostException {
        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloFreemarker.class, "/");

        final MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));

        DB database = client.getDB("course");
        final DBCollection collection = database.getCollection("hello");

        Spark.get(new Route("/") {

            @Override
            public Object handle(Request request, Response response) {
                StringWriter writer = new StringWriter();

                try {
                    Template helloFreemarker = configuration.getTemplate("hello.ftl");

                    DBObject document = collection.findOne();

                    helloFreemarker.process(document, writer);

                } catch (Exception e) {
                    halt(500);
                    e.printStackTrace();
                }

                return writer;
            }
        });
    }
}
