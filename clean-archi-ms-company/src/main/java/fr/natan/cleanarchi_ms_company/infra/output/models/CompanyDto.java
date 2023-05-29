package fr.natan.cleanarchi_ms_company.infra.output.models;

import fr.natan.cleanarchi_ms_company.domain.entity.CompanyType;

public class CompanyDto {
    private String companyName;
    private String agency;
    private CompanyType companyType;

    public CompanyDto() {
    }

    public CompanyDto(String companyName, CompanyType companyType, String agency) {
        this.companyName = companyName;
        this.companyType = companyType;
        this.agency = agency;
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

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }
}
