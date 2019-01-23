package org.rodrigez.service;

import com.google.gson.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.rodrigez.model.Document;
import org.rodrigez.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentService {

    @Autowired
    DocumentRepository documentRepository;

    private static OkHttpClient httpClient = new OkHttpClient();

    public void run() {
        String pageUrl = "https://lb-api-sandbox.prozorro.gov.ua/api/2.4/contracts/47fa8764e1b74f4db58f84c9db460566/documents";
        List<Document> documents = loadDocumentsFromPage(pageUrl);
        documentRepository.saveAll(documents);

    }

    private List<Document> loadDocumentsFromPage(String pageUrl) {
        String pageJson = getPageJson(pageUrl);
        JsonArray jsonArray = getJsonArray(pageJson);
        return getDocuments(jsonArray);
    }

    String getPageJson(String pageUrl){

        Request request = new Request.Builder()
                .url(pageUrl)
                .build();

        String pageJson = null;

        try (Response response = httpClient.newCall(request).execute()) {
            pageJson = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pageJson;
    }

    public JsonArray getJsonArray(String pageJson){
        JsonElement jsonElement = new JsonParser().parse(pageJson);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        return jsonObject.getAsJsonArray("data");
    }

    public List<Document> getDocuments(JsonArray jsonArray){
        List<Document> documents = new ArrayList<>();
        Gson gson = new Gson();
        for (JsonElement jsonDocument : jsonArray) {
            Document document = gson.fromJson(jsonDocument, Document.class);
            documents.add(document);
        }
        return documents;
    }
}