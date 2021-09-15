package com.mindex.challenge.service;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.CompensationDto;

/**
 * @author mir00r on 15/9/21
 * @project IntelliJ IDEA
 */
public interface CompensationService {
    Compensation create(CompensationDto dto);

    CompensationDto readByEmployeeId(String id);
}
