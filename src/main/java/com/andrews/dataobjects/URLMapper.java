package com.andrews.dataobjects;

import javax.persistence.*;

/**
 * Created by andrewssamuel on 8/24/16.
 */
@Entity
public class URLMapper  {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;

    String shortURL;

    String longURL;

    String encodedId;

    public String getEncodedId() {
        return encodedId;
    }

    public void setEncodedId(String encodedId) {
        this.encodedId = encodedId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortURL() {
        return shortURL;
    }

    public void setShortURL(String shortURL) {
        this.shortURL = shortURL;
    }

    public String getLongURL() {
        return longURL;
    }

    public void setLongURL(String longURL) {
        this.longURL = longURL;
    }
}
