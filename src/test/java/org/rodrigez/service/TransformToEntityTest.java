package org.rodrigez.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.rodrigez.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TransformToEntityTest {

    @Autowired
    DocumentService documentService;

    @Test
    public void test() throws ParseException {
        JsonParser jsonParser = new JsonParser();
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(jsonParser.parse("{\"hash\": \"md5:ba8ca1580920293ebb33a1dfdb4b74fe\", \"format\": \"application/vnd.openxmlformats-officedocument.wordprocessingml.document\", \"url\": \"https://public-docs-sandbox.prozorro.gov.ua/get/766cc889cc2343fbb7ce802022cabd9b?KeyID=1331dc52&Signature=UuYK9aRGFVDCJdIXNkZnbYPvrnlmSVkLZZmJ2l%252BII7Uc1btir26W0wbT4qFe4CpajDb81%252BI5kYZ5cOQ92uJlDw%253D%253D\", \"title\": \"\\u041f\\u0435\\u0440\\u0435\\u043b\\u0456\\u043a \\u0437\\u043c\\u0456\\u043d.docx\", \"documentOf\": \"change\", \"datePublished\": \"2018-10-17T11:53:01.587843+03:00\", \"documentType\": \"contractAnnexe\", \"dateModified\": \"2018-10-17T11:53:01.587874+03:00\", \"relatedItem\": \"028162fdf8634010ac1296b11e685602\", \"id\": \"3b6a91e9c7154f6ebf5e8a8d5c11a357\"}"));

        List<Document> documents = documentService.getDocuments(jsonArray);
        Document document = documents.get(0);

        Assert.assertEquals("md5:ba8ca1580920293ebb33a1dfdb4b74fe", document.getHash());
        Assert.assertEquals("application/vnd.openxmlformats-officedocument.wordprocessingml.document", document.getFormat());

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
        Date date = dateFormat.parse("2018-10-17 11:53:01.587");
        Assert.assertEquals(date, document.getDateModified());

        Assert.assertNull(document.getDescription());

    }
}
