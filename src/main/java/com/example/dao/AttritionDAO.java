package com.example.dao;

import com.example.domain.Attrition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by palsulea on 11/8/2016.
 */
@Repository
public interface AttritionDAO extends CrudRepository<Attrition,Long> {

}
