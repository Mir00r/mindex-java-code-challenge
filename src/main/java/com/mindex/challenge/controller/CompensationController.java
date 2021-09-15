package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.CompensationDto;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author mir00r on 15/9/21
 * @project IntelliJ IDEA
 */
@RestController
public class CompensationController {
    private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);

    private final CompensationService compensationService;

    @Autowired
    public CompensationController(CompensationService compensationService) {
        this.compensationService = compensationService;
    }

    @PostMapping("/compensation")
    public Compensation create(@RequestBody CompensationDto dto) {
        LOG.debug("Received employee compensation create request for [{}]", dto);

        return this.compensationService.create(dto);
    }

    @GetMapping("/compensation/employee/{id}")
    public CompensationDto read(@PathVariable String id) {
        LOG.debug("Received employee compensation create request for id [{}]", id);

        return this.compensationService.readByEmployeeId(id);
    }
}
