package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.CompensationDto;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @author mir00r on 15/9/21
 * @project IntelliJ IDEA
 */
@Service
public class CompensationServiceImpl implements CompensationService {

    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    private final EmployeeRepository employeeRepository;
    private final CompensationRepository compensationRepository;

    @Autowired
    public CompensationServiceImpl(EmployeeRepository employeeRepository, CompensationRepository compensationRepository) {
        this.employeeRepository = employeeRepository;
        this.compensationRepository = compensationRepository;
    }

    @Override
    public Compensation create(CompensationDto dto) {
        this.validate(dto);

        Compensation entity = new Compensation();
        LOG.debug("Creating employee compensation with [{}]", dto);

        entity.setId(UUID.randomUUID().toString());
        entity.setType(Compensation.class.getSimpleName());
        entity.setSalary(dto.getSalary());
        entity.setEffectiveDate(new Date(dto.getEffectiveDate()));
        entity.setEmployeeId(dto.getEmployeeId());
        return this.compensationRepository.save(entity);
    }

    private void validate(CompensationDto dto) {
        Employee employee = this.employeeRepository.findByEmployeeId(dto.getEmployeeId());
        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + dto.getEmployeeId());
        }
        if (dto.getSalary() != null && dto.getSalary() < 0)
            throw new RuntimeException("Invalid salary amount: " + dto.getSalary());
    }

    @Override
    public CompensationDto readByEmployeeId(String id) {
        Compensation compensation = this.compensationRepository.findByEmployeeId(id);
        if (compensation == null) throw new RuntimeException("Compensation not found with employee id: " + id);

        Employee employee = this.employeeRepository.findByEmployeeId(id);
        if (employee == null) {
            throw new RuntimeException("Employee not found with id: " + id);
        }

        CompensationDto dto = new CompensationDto();
        dto.setEmployee(employee);
        dto.setEmployeeId(id);
        dto.setSalary(compensation.getSalary());
        dto.setEffectiveDate(compensation.getEffectiveDate().getTime());
        return dto;
    }
}
