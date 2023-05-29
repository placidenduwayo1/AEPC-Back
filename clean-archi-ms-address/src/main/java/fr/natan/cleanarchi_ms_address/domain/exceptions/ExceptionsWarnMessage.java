package fr.natan.cleanarchi_ms_address.domain.exceptions;

public enum ExceptionsWarnMessage {
    ADDRESS_ALREADY_EXISTS_EXCEPTION("Address already exists exception"),
    ADDRESS_NOT_FOUND_EXCEPTION ("Address not found exception"),
    FIELDS_EMPTY_EXCEPTION("Address one or more fields invalid exception"),
    ADDRESS_NUM_INVALID_EXCEPTION("Address number invalid exception"),
    ADDRESS_ASSIGNED_EMPLOYEES_EXCEPTION("Address employee assigned exception"),
    ADDRESS_PB_INVALID_EXCEPTION ("Address Po Box invalid exception");
    private final String exception;
    ExceptionsWarnMessage(String exception) {
        this.exception = exception;
    }

    public String getException() {
        return exception;
    }
}
