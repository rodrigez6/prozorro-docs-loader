package org.rodrigez.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "document_version_2", schema = "prozorro")
public class Document {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "description")
    private String description;

    @Column(name = "hash")
    private String hash;

    @Column(name = "language")
    private String language;

    @Column(name = "format")
    private String format;

    @Column(name = "url")
    private String url;

    @Column(name = "title")
    private String title;

    @Column(name = "document_of")
    private String documentOf;

    @Column(name = "document_type")
    private String documentType;

    @Column(name = "date_modified")
    private Date dateModified;

    @Column(name = "date_published")
    private Date datePublished;

    @Column(name = "related_item")
    private String relatedItem;

    public String getId() {
        return id;
    }

    public String getHash() {
        return hash;
    }

    public String getLanguage() {
        return language;
    }

    public String getFormat() {
        return format;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDocumentOf() {
        return documentOf;
    }

    public String getDocumentType() {
        return documentType;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public String getRelatedItem() {
        return relatedItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return id.equals(document.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Document{");
        sb.append("id='").append(id).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", hash='").append(hash).append('\'');
        sb.append(", language='").append(language).append('\'');
        sb.append(", format='").append(format).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", documentOf='").append(documentOf).append('\'');
        sb.append(", documentType='").append(documentType).append('\'');
        sb.append(", dateModified=").append(dateModified);
        sb.append(", datePublished=").append(datePublished);
        sb.append(", relatedItem='").append(relatedItem).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
