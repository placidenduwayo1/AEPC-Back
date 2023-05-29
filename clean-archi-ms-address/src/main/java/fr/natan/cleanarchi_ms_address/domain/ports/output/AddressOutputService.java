package fr.natan.cleanarchi_ms_address.domain.ports.output;

import fr.natan.cleanarchi_ms_address.domain.entity.Address;
import fr.natan.cleanarchi_ms_address.domain.exceptions.AddressNotFoundException;
import fr.natan.cleanarchi_ms_address.infra.input.feignclient.entity.EmployeeModel;
import fr.natan.cleanarchi_ms_address.infra.output.model.AddressDto;

import java.util.List;
import java.util.Optional;

public interface AddressOutputService {
    List<Address> getAllAddresses();
    Address createAddress(Address address);
    List<Address> getAddressByInfo(AddressDto addressDto);
    void deleteAddress (Long addressID);
    Optional<Address> getAddressByID(Long addressID) throws AddressNotFoundException;
    void updateAddress(Address address);
    List<EmployeeModel> getEmployeesLivingAtAddress(Long addressID);
}
