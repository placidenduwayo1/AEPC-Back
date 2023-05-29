package fr.natan.cleanarchi_ms_project.domain.exceptions_metiers;

public enum ExceptionWarnMsg {
    PROJECT_NOT_FOUND_EXCEPTION("Project not found exception"),
    PROJECT_ALREADY_EXISTS_EXCEPTION("Project already exists exception"),
    PROJECT_FIELDS_EMPTY_EXCEPTION("Project one or more fields invalid exception"),
    EMPLOYEE_API_ERROR("Project, employee associated to project exception"),
    EMPLOYEE_STATE_NOT_ACCEPTED_EXCEPTION("Project, employee state invalid exception "),
    EMPLOYEE_IS_ASSOCIATED_TO_PROJECT_EXCEPTION("Project, employee already associated project exception"),
    COMPANY_IS_ASSOCIATED_TO_PROJECT_EXCEPTION("Project, company already associated exception"),
    COMPANY_API_ERROR("Project, company error");

    private final String exception;

    ExceptionWarnMsg(String exception) {
        this.exception = exception;
    }

    public String getException() {
        return exception;
    }
}
