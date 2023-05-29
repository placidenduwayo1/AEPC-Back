package fr.natan.cleanarchi_ms_company.domain.exceptions;

public enum ExceptionsWarnMsg {
    COMPANY_ALREADY_EXISTS_EXCEPTION("Company already exists exception"),
    COMPANY_NOT_FOUND_EXCEPTION("Company not found exception"),
    COMPANY_ASSOCIATED_PROJECT_EXCEPTION ("Company project associated exception"),
    COMPANY_FIELDS_EMPTY_EXCEPTION ("Company one or more fields invalid exception");

    private final String exception;

    ExceptionsWarnMsg(String exception) {
        this.exception = exception;
    }

    public String getException() {
        return exception;
    }
}
