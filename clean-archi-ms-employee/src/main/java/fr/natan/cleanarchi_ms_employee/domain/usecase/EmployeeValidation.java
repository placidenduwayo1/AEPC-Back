package fr.natan.cleanarchi_ms_employee.domain.usecase;

import fr.natan.cleanarchi_ms_employee.domain.exception_metrier.ExceptionWarnMsg;
import fr.natan.cleanarchi_ms_employee.infra.input.feignclient.models.AddressModel;
import fr.natan.cleanarchi_ms_employee.infra.output.model.EmployeeDto;

@SuppressWarnings("ALL")
public class EmployeeValidation {
    private EmployeeValidation(){}
    public static boolean areValidEmployeeRequiredFields(EmployeeDto employeeDto) {
        return !employeeDto.getFirstname().isBlank()
                && !  employeeDto.getLastname().isBlank()
                && employeeDto.getAddressID()>0
                ;
    }

    public static void employeeFormatter(EmployeeDto employeeDto){
        employeeDto.setFirstname(employeeDto.getFirstname().strip().toUpperCase());
        employeeDto.setLastname(employeeDto.getLastname().strip().toUpperCase());
    }
    public static String buildEmployeeProfessionalEmail(String firstname, String lastname, String domain){
        lastname = lastname.strip();
        firstname = firstname.strip();
         lastname = lastname.replaceAll("\\s","-").toLowerCase();
        firstname = firstname.replaceAll("\\s","-").toLowerCase();

        return firstname+"."+lastname+"@"+domain+".fr";
    }

    public static boolean isValidAddressAPI(AddressModel addressModel){
        Long addressID = addressModel.getAddressID();
        return !String.valueOf(addressID).equals(ExceptionWarnMsg.ADDRESS_API_ERROR.toString());
    }
}
