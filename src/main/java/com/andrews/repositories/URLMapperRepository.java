package com.andrews.repositories;

import com.andrews.dataobjects.*;
import org.springframework.data.repository.*;

import java.util.*;


/**
 * Created by andrewssamuel on 8/24/16.
 */

public interface URLMapperRepository extends CrudRepository<URLMapper,Long> {

    List<URLMapper> findAll();
}
