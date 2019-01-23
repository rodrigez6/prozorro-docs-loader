package org.rodrigez.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class DocumentDTO {

    @SerializedName("id")
    private String id;

    @SerializedName("hash")
    private String hash;

    @SerializedName("language")
    private String language;

    @SerializedName("format")
    private String format;

    @SerializedName("url")
    private String url;

    @SerializedName("title")
    private String title;

    @SerializedName("documentOF")
    private String documentOf;

    @SerializedName("documentType")
    private String documentType;

    @SerializedName("dateModified")
    private Date dateModified;

    @SerializedName("datePublished")
    private Date datePublished;

    @SerializedName("relatedItem")
    private String relatedItem;



}
