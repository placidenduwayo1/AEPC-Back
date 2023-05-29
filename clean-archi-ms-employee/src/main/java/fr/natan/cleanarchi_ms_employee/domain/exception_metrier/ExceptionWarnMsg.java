package fr.natan.cleanarchi_ms_employee.domain.exception_metrier;

public enum ExceptionWarnMsg {
    EMPLOYEE_ALREADY_EXISTS_EXCEPTION ("Employee already exists exception"),
    EMPLOYEE_NOT_FOUND_EXCEPTION ("Employee not found exception"),
    EMPLOYEE_FIELDS_EMPTY_EXCEPTION ("Employee one ore more fields invalid exception"),
    EMPLOYEE_ASSOCIATED_PROJECTS_EXCEPTION("Employee project associated exception"),
    ADDRESS_API_ERROR("Address API error");

    private final String exception;

    ExceptionWarnMsg(String exception) {
        this.exception = exception;
    }

    public String getException() {
        return exception;
    }
}
