package com.zzping.serviceimpl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    private MongoTemplate mongoTemplate;
    public void test(){
     /*   Query query = new Query();
        query.addCriteria(Criteria.where("_id"));
        mongoTemplate.getCollection()
        org.bson.Document document = new org.bson.Document();
        //document
        document.put("name",new org.bson.Document().getBoolean())
        mongoTemplate.getCollection("").inser*/
    }

    @Autowired
    private RabbitTemplate rabbitTemplate;
}
