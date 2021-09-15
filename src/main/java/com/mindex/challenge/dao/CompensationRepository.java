package com.mindex.challenge.dao;

import com.mindex.challenge.data.Compensation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author mir00r on 15/9/21
 * @project IntelliJ IDEA
 */
@Repository
public interface CompensationRepository extends MongoRepository<Compensation, String> {

    Compensation findByEmployeeId(String employeeId);
}
