package fr.natan.cleanarchi_ms_employee.infra.input.feignclientfallback;

import fr.natan.cleanarchi_ms_employee.domain.exception_metrier.ExceptionWarnMsg;
import fr.natan.cleanarchi_ms_employee.infra.input.feignclient.models.AddressModel;
import fr.natan.cleanarchi_ms_employee.infra.input.feignclient.services.AddressServiceProxy;
import org.springframework.stereotype.Component;

@Component
public class AddressServiceProxyFallback implements AddressServiceProxy {
    @Override
    public AddressModel getAddressById(Long addressID) {
        AddressModel errorAddress = new AddressModel();
        errorAddress.setAddressID(0L);
        errorAddress.setStreet(ExceptionWarnMsg.ADDRESS_API_ERROR.toString());
        errorAddress.setCity(ExceptionWarnMsg.ADDRESS_API_ERROR.toString());
        errorAddress.setCountry(ExceptionWarnMsg.ADDRESS_API_ERROR.toString());
        return errorAddress;
    }
}
