package fr.natan.cleanarchi_ms_employee.domain.entity;

import fr.natan.cleanarchi_ms_employee.infra.input.feignclient.models.AddressModel;

import java.time.LocalDateTime;

public class Employee {
    private String employeeID;
    private String firstname;
    private String lastname;
    private String email;
    private LocalDateTime hireDate;
    private EmployeeState employeeState;
    private EmployeeType employeeType;
    private Long addressID;
    private AddressModel address;

    public Employee() {
    }

    public Employee(String employeeID, String firstname, String lastname, String email,
                    LocalDateTime hireDate, EmployeeState state, EmployeeType employeeType,
                    Long addressID, AddressModel address) {
        this.employeeID = employeeID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.hireDate = hireDate;
        this.employeeState = state;
        this.employeeType = employeeType;
        this.addressID = addressID;
        this.address = address;
    }

    public LocalDateTime getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDateTime hireDate) {
        this.hireDate = hireDate;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getAddressID() {
        return addressID;
    }

    public void setAddressID(Long addressID) {
        this.addressID = addressID;
    }

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
    }

    public EmployeeState getEmployeeState() {
        return employeeState;
    }

    public void setEmployeeState(EmployeeState employeeState) {
        this.employeeState = employeeState;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }
}
