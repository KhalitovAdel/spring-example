package com.example.lal;

import java.util.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface LalRepository extends CrudRepository<Lal, Long> {
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.definition
    Page<Lal> findByNameContaining(String name, Pageable pageable);
 
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.at-query
    @Query("select u from Lal u where u.type in :t")
    Lal[] findByType(@Param("t") List<Lal.LalType> types);
}
