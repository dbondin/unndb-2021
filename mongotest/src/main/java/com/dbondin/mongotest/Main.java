package com.dbondin.mongotest;

import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.codecs.BsonCodec;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class Main {

	public static void main(String[] args) throws Throwable {
		MongoClient mongoClient = MongoClients.create("mongodb://root:example@localhost:27017");
		
		MongoDatabase database = mongoClient.getDatabase("test");
		
		Bson filter = BsonDocument.parse("{age : {$gt : 3}}");
		
		FindIterable<Document> c = database.getCollection("cats").find(filter);
		
		MongoCursor<Document> cur = c.cursor();
		
		while(cur.hasNext()) {
			Document d = cur.next();
			
			System.out.println( String.format("name=%s age=%s",d.get("name"), d.get("age")));
		}
	}

}
