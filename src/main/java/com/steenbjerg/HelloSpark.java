package com.steenbjerg;

import spark.*;

/**
 * Created with IntelliJ IDEA.
 * User: dan
 * Date: 02-03-13
 * Time: 19:23
 * To change this template use File | Settings | File Templates.
 */
public class HelloSpark {
    public static void main( String[] args ) {
        Spark.get(new Route("/") {

            @Override
            public Object handle(Request request, Response response) {
                return "Hello World";
            }
        });
    }
}
