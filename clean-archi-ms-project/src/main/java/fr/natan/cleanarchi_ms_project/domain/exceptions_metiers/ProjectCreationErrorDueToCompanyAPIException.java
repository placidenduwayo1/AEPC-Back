package fr.natan.cleanarchi_ms_project.domain.exceptions_metiers;

public class ProjectCreationErrorDueToCompanyAPIException extends Exception {
    public ProjectCreationErrorDueToCompanyAPIException(String message) {
        super(message);
    }
}
