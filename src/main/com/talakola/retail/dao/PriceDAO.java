package com.talakola.retail.dao;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.talakola.retail.model.PriceModel;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.mongodb.client.model.Filters.eq;

@Component
public class PriceDAO {

    @Autowired
    MongoCollection<Document> collection;

    public PriceModel getPriceData(int id) {
        Bson bsonFilter = eq("_id", id);
        collection.find(bsonFilter);
    }

}
