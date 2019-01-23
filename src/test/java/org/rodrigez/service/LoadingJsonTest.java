package org.rodrigez.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class LoadingJsonTest {

    @Autowired
    DocumentService documentService;

    @Test
    public void test(){
        String pageUrl = "https://lb-api-sandbox.prozorro.gov.ua/api/2.4/contracts/23567e24f52746ef92c470be6059d193/documents";
        String pageJson = "{\"data\": [{\"hash\": \"md5:232dba893a22ac722249ad92f8bccf22\", \"format\": \"text/plain\", \"url\": \"https://public-docs-sandbox.prozorro.gov.ua/get/3500487074064bd98f1076c21fe69e9a?KeyID=1331dc52&Signature=w%252BTQLJCiU%2FDQXfp%2FxB0VfDNRzImPv7zch3e8H1jfVOZrDJZuam%2FOTVLlvpdUiz9WVLHdUzdMrQJclbl4Vs28CQ%253D%253D\", \"title\": \"11.09.2018.xlsx\", \"documentOf\": \"tender\", \"datePublished\": \"2018-09-19T13:12:21.136232+03:00\", \"documentType\": \"subContract\", \"dateModified\": \"2018-09-19T13:12:21.136263+03:00\", \"id\": \"4f6d6dc59d1844bb80143ccc2e727a2f\"}, {\"hash\": \"md5:ee80acf16c48f3b659a2132526ae9800\", \"format\": \"application/pkcs7-signature\", \"url\": \"https://public-docs-sandbox.prozorro.gov.ua/get/04a93d0ba3e44e7e93a104a1b1ec8aaf?KeyID=1331dc52&Signature=o1V0G3cmFYjuu7MqIJxTY9zhDAj7PTblieehL0PEG%2FA5uc0VZlpY%252BMhQy0ZxTPdymnkPvAVxivDEodSI4RFDCw%253D%253D\", \"title\": \"sign.p7s\", \"documentOf\": \"tender\", \"datePublished\": \"2018-09-19T13:13:07.776613+03:00\", \"dateModified\": \"2018-09-19T13:13:07.776633+03:00\", \"id\": \"a5ef4c3063d94b10a13630fa9cca90b9\"}, {\"hash\": \"md5:061044f40512fa72e03c2674d1539e0f\", \"format\": \"text/plain\", \"url\": \"https://public-docs-sandbox.prozorro.gov.ua/get/5e03ef2402bd42ddb7dc78d526c95f81?KeyID=1331dc52&Signature=VjKGxj7WlIe%252BqZpE4OJl1qtIt0VQJ%2FMff8n8KaJWVHDANkFZB%252BcZbsq%2Fr%252BzW6S81cqeSU9hYlLLnq1WGpJ%252BuCQ%253D%253D\", \"title\": \"\\u0442\\u0435\\u0441\\u0442.docx\", \"documentOf\": \"change\", \"datePublished\": \"2018-09-24T16:00:29.527286+03:00\", \"dateModified\": \"2018-09-24T16:00:29.527311+03:00\", \"relatedItem\": \"6167ab1f7a184f75881b166b9c2e9193\", \"id\": \"f58353848e744791ad72f9baf84b5734\"}]}";
        String expected = documentService.getPageJson(pageUrl);
        Assert.assertEquals(expected, pageJson);

    }

}
