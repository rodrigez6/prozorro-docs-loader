package org.rodrigez.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.print.Doc;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TransformingToJsonArrayTest {

    @Autowired
    DocumentService documentService;

    @Test
    public void test(){
        JsonParser jsonParser = new JsonParser();
        JsonArray expectedJsonArray = new JsonArray();
        expectedJsonArray.add(jsonParser.parse("{\"hash\": \"md5:787caaf33e54d10e6cd302bce098564c\", \"description\": \"\", \"format\": \"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet\", \"url\": \"https://public-docs-sandbox.prozorro.gov.ua/get/69966a5cbdf94ea9a7420ade7d97ca56?KeyID=1331dc52&Signature=7feOocmK9uCwci0%2FrHMXl4jScyfOTK7XQjnRsJLIZFN21Z9hRDjeZJrrVn4XXiqGjgOSQ6XKtTggvJHe6G8cDQ%253D%253D\", \"title\": \"\\u0414\\u043e\\u0434\\u0430\\u0442\\u043a\\u043e\\u0432\\u0430 \\u0443\\u0433\\u043e\\u0434\\u0430.xlsx\", \"documentOf\": \"tender\", \"datePublished\": \"2018-10-08T15:13:06.456131+03:00\", \"documentType\": \"contractSigned\", \"dateModified\": \"2018-10-08T15:13:06.456152+03:00\", \"id\": \"c973e26efa78408c8cf7adbb3c2b11e5\"}"));
        expectedJsonArray.add(jsonParser.parse("{\"hash\": \"md5:ba8ca1580920293ebb33a1dfdb4b74fe\", \"format\": \"application/vnd.openxmlformats-officedocument.wordprocessingml.document\", \"url\": \"https://public-docs-sandbox.prozorro.gov.ua/get/766cc889cc2343fbb7ce802022cabd9b?KeyID=1331dc52&Signature=UuYK9aRGFVDCJdIXNkZnbYPvrnlmSVkLZZmJ2l%252BII7Uc1btir26W0wbT4qFe4CpajDb81%252BI5kYZ5cOQ92uJlDw%253D%253D\", \"title\": \"\\u041f\\u0435\\u0440\\u0435\\u043b\\u0456\\u043a \\u0437\\u043c\\u0456\\u043d.docx\", \"documentOf\": \"change\", \"datePublished\": \"2018-10-17T11:53:01.587843+03:00\", \"documentType\": \"contractAnnexe\", \"dateModified\": \"2018-10-17T11:53:01.587874+03:00\", \"relatedItem\": \"028162fdf8634010ac1296b11e685602\", \"id\": \"3b6a91e9c7154f6ebf5e8a8d5c11a357\"}"));

        String pageJson = "{\"data\": [{\"hash\": \"md5:787caaf33e54d10e6cd302bce098564c\", \"description\": \"\", \"format\": \"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet\", \"url\": \"https://public-docs-sandbox.prozorro.gov.ua/get/69966a5cbdf94ea9a7420ade7d97ca56?KeyID=1331dc52&Signature=7feOocmK9uCwci0%2FrHMXl4jScyfOTK7XQjnRsJLIZFN21Z9hRDjeZJrrVn4XXiqGjgOSQ6XKtTggvJHe6G8cDQ%253D%253D\", \"title\": \"\\u0414\\u043e\\u0434\\u0430\\u0442\\u043a\\u043e\\u0432\\u0430 \\u0443\\u0433\\u043e\\u0434\\u0430.xlsx\", \"documentOf\": \"tender\", \"datePublished\": \"2018-10-08T15:13:06.456131+03:00\", \"documentType\": \"contractSigned\", \"dateModified\": \"2018-10-08T15:13:06.456152+03:00\", \"id\": \"c973e26efa78408c8cf7adbb3c2b11e5\"}, {\"hash\": \"md5:ba8ca1580920293ebb33a1dfdb4b74fe\", \"format\": \"application/vnd.openxmlformats-officedocument.wordprocessingml.document\", \"url\": \"https://public-docs-sandbox.prozorro.gov.ua/get/766cc889cc2343fbb7ce802022cabd9b?KeyID=1331dc52&Signature=UuYK9aRGFVDCJdIXNkZnbYPvrnlmSVkLZZmJ2l%252BII7Uc1btir26W0wbT4qFe4CpajDb81%252BI5kYZ5cOQ92uJlDw%253D%253D\", \"title\": \"\\u041f\\u0435\\u0440\\u0435\\u043b\\u0456\\u043a \\u0437\\u043c\\u0456\\u043d.docx\", \"documentOf\": \"change\", \"datePublished\": \"2018-10-17T11:53:01.587843+03:00\", \"documentType\": \"contractAnnexe\", \"dateModified\": \"2018-10-17T11:53:01.587874+03:00\", \"relatedItem\": \"028162fdf8634010ac1296b11e685602\", \"id\": \"3b6a91e9c7154f6ebf5e8a8d5c11a357\"}]}";

        Assert.assertEquals(expectedJsonArray, documentService.getJsonArray(pageJson));
    }
}
