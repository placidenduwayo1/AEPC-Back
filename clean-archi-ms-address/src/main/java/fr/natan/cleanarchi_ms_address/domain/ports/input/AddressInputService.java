package fr.natan.cleanarchi_ms_address.domain.ports.input;

import fr.natan.cleanarchi_ms_address.domain.entity.Address;
import fr.natan.cleanarchi_ms_address.domain.exceptions.*;
import fr.natan.cleanarchi_ms_address.infra.input.feignclient.entity.EmployeeModel;
import fr.natan.cleanarchi_ms_address.infra.output.model.AddressDto;

import java.util.List;
import java.util.Optional;

public interface AddressInputService {
    List<Address> getAllAddresses();
    Address createAddress(AddressDto addressDto) throws AddressFieldsEmptyException, AddressAlreadyExistsException,
            AddressNumInvalidException, AddressPBInvalidException;
    List<Address> getAddressByInfo(AddressDto addressDto);
    void deleteAddress (Long addressID) throws AddressNotFoundException, AddressAssignedEmployeesException;
    Optional<Address> getAddressByID(Long addressID) throws  AddressNotFoundException;
    Address updateAddress(Long addressID, AddressDto addressDto) throws AddressNotFoundException, AddressFieldsEmptyException,
            AddressPBInvalidException, AddressNumInvalidException, AddressAlreadyExistsException;
    List<EmployeeModel> getEmployeesLivingAtAddressThis(Long addressID) throws AddressNotFoundException;
}
