package com.andrews.services;

import com.andrews.dataobjects.*;
import com.andrews.repositories.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.*;

import java.nio.charset.*;
import java.util.*;

/**
 * Created by andrewssamuel on 8/24/16.
 */
@Service
public class ShortURLCreatorServiceImpl implements ShortURLCreatorService {

    @Autowired
    private URLMapperRepository urlMapperRepository;


    @Override
    public URLMapper createShortURL(String longURL, String contextPath) {

        URLMapper urlMapper = new URLMapper();
        urlMapper.setLongURL(longURL);
        urlMapper = urlMapperRepository.save(urlMapper);
        urlMapper.setEncodedId(base64Encode(urlMapper.getId().toString()));
        urlMapper.setShortURL(contextPath+"/"+urlMapper.getEncodedId());
        urlMapper = urlMapperRepository.save(urlMapper);

        return urlMapper;
    }

    @Override
    public URLMapper retrieveLongURL(String id) {

        URLMapper urlMapper = urlMapperRepository.findOne(Long.parseLong(base64Decode(id)));
        return urlMapper;
    }

    @Override
    public List<URLMapper> findAll() {
        return urlMapperRepository.findAll();
    }

    public static String base64Encode(String token) {
        byte[] encodedBytes = Base64.encode(token.getBytes());
        return new String(encodedBytes, Charset.forName("UTF-8"));
    }


    public static String base64Decode(String token) {
        byte[] decodedBytes = Base64.decode(token.getBytes());
        return new String(decodedBytes, Charset.forName("UTF-8"));
    }
}
