package com.mindex.challenge.data;

/**
 * @author mir00r on 15/9/21
 * @project IntelliJ IDEA
 */
public class ReportingStructure {
    private String type;
    private Employee employee;
    private long numberOfReports;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public long getNumberOfReports() {
        return numberOfReports;
    }

    public void setNumberOfReports(long numberOfReports) {
        this.numberOfReports = numberOfReports;
    }
}
