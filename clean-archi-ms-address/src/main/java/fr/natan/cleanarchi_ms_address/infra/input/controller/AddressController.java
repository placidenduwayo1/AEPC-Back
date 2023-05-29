package fr.natan.cleanarchi_ms_address.infra.input.controller;

import fr.natan.cleanarchi_ms_address.domain.entity.Address;
import fr.natan.cleanarchi_ms_address.domain.exceptions.*;
import fr.natan.cleanarchi_ms_address.domain.ports.input.AddressInputService;
import fr.natan.cleanarchi_ms_address.infra.input.feignclient.entity.EmployeeModel;
import fr.natan.cleanarchi_ms_address.infra.output.model.AddressDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class
AddressController {
    private final AddressInputService addressInputService;
        public AddressController(AddressInputService addressInputService) {
        this.addressInputService = addressInputService;
    }

    @GetMapping(value = "/addresses", produces = "application/json")
    public List<Address> getAllAddresses(){
        return addressInputService.getAllAddresses();
    }

    @PostMapping(value = "/addresses")
    public Address createAddress(@RequestBody AddressDto addressDto) throws AddressFieldsEmptyException, AddressAlreadyExistsException, AddressPBInvalidException, AddressNumInvalidException {
        return addressInputService.createAddress(addressDto);
    }

    @DeleteMapping(value = "/addresses/{addressID}")
    public void deleteAddress(@PathVariable(name = "addressID") Long addressID) throws AddressNotFoundException, AddressAssignedEmployeesException {
        addressInputService.deleteAddress(addressID);
    }

    @PutMapping(value = "/addresses/{addressID}")
    public Address updateAddress(@PathVariable(name = "addressID") Long addressID, @RequestBody AddressDto addressDto)
            throws AddressFieldsEmptyException, AddressNotFoundException, AddressPBInvalidException, AddressNumInvalidException,
            AddressAlreadyExistsException {
        return addressInputService.updateAddress(addressID, addressDto);
    }

    @GetMapping(value = "/addresses/{addressID}", produces = "application/json")
    public Optional<Address> getAddress(@PathVariable(name = "addressID") Long addressID) throws AddressNotFoundException {
        return addressInputService.getAddressByID(addressID);
    }
    @GetMapping(value = "/employees/addresses/{addressID}", produces = "application/json")
    public   List<EmployeeModel> employeesAtAddressThis(@PathVariable(name = "addressID") Long addressID) throws AddressNotFoundException {
        return addressInputService.getEmployeesLivingAtAddressThis(addressID);
    }
}
