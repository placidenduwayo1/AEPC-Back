package fr.natan.cleanarchi_ms_company.domain.usecase;

import fr.natan.cleanarchi_ms_company.infra.output.models.CompanyDto;

@SuppressWarnings("BooleanMethodIsAlwaysInverted")
public class CompanyValidation {
    private CompanyValidation(){
        //private constructor to hide default public constructor
    }

    public static boolean areValidCompanyTextFields(CompanyDto companyDto) {
        return !companyDto.getCompanyName().isBlank()
                && !companyDto.getAgency().isBlank();
    }

    public static void companyFormatter(CompanyDto companyDto) {
        companyDto.setCompanyName(companyDto.getCompanyName().strip().toUpperCase());
        companyDto.setAgency(companyDto.getAgency().strip().toUpperCase());
    }
}
