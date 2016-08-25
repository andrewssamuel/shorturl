package com.andrews.services;

import com.andrews.dataobjects.*;
import com.andrews.repositories.*;

import java.util.*;

/**
 * Created by andrewssamuel on 8/24/16.
 */
public interface  ShortURLCreatorService {

    public URLMapper createShortURL(String longURL, String contextPath);

    public URLMapper retrieveLongURL(String id);

    public List<URLMapper> findAll();

}
