package fr.natan.cleanarchi_ms_project.infra.input.feignclientsfallback;

import fr.natan.cleanarchi_ms_project.domain.exceptions_metiers.ExceptionWarnMsg;
import fr.natan.cleanarchi_ms_project.infra.input.feignclients.entities.CompanyModel;
import fr.natan.cleanarchi_ms_project.infra.input.feignclients.services.CompanyServiceProxy;
import org.springframework.stereotype.Component;

@Component
public class CompanyServiceProxyFallback implements CompanyServiceProxy {
    @Override
    public CompanyModel getCompanyByID(String companyID) {
        CompanyModel emptyCompany = new CompanyModel();
        emptyCompany.setCompanyID(ExceptionWarnMsg.COMPANY_API_ERROR.toString());
        emptyCompany.setCompanyName(ExceptionWarnMsg.COMPANY_API_ERROR.toString());
        emptyCompany.setCompanyType(null);
        return emptyCompany;
    }
}
