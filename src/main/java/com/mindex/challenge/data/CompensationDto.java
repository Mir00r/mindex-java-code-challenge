package com.mindex.challenge.data;

import javax.validation.constraints.NotNull;

/**
 * @author mir00r on 15/9/21
 * @project IntelliJ IDEA
 */
public class CompensationDto {
    @NotNull
    private String employeeId;
    @NotNull
    private Long salary;
    @NotNull
    private Long effectiveDate;

    private Employee employee;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Long getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Long effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

