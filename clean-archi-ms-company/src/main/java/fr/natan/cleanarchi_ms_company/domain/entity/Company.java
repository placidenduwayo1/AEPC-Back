package fr.natan.cleanarchi_ms_company.domain.entity;

import java.time.LocalDateTime;

public class Company {
    private String companyID;
    private String companyName;
    private String agency;
    private CompanyType companyType;
    private LocalDateTime connectedDate;

    public Company() {
    }

    public Company(String companyID, String companyName, CompanyType companyType, LocalDateTime connectedDate, String agency) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.companyType = companyType;
        this.connectedDate = connectedDate;
        this.agency = agency;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }

    public LocalDateTime getConnectedDate() {
        return connectedDate;
    }

    public void setConnectedDate(LocalDateTime connectedDate) {
        this.connectedDate = connectedDate;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }
}
