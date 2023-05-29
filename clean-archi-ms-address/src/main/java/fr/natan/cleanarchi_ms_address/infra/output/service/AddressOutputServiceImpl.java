package fr.natan.cleanarchi_ms_address.infra.output.service;

import fr.natan.cleanarchi_ms_address.domain.entity.Address;
import fr.natan.cleanarchi_ms_address.domain.exceptions.AddressNotFoundException;
import fr.natan.cleanarchi_ms_address.domain.ports.output.AddressOutputService;
import fr.natan.cleanarchi_ms_address.infra.input.feignclient.entity.EmployeeModel;
import fr.natan.cleanarchi_ms_address.infra.input.feignclient.service.EmployeeServiceProxy;
import fr.natan.cleanarchi_ms_address.infra.output.mapper.AddressMapper;
import fr.natan.cleanarchi_ms_address.infra.output.model.AddressDto;
import fr.natan.cleanarchi_ms_address.infra.output.model.AddressModel;
import fr.natan.cleanarchi_ms_address.infra.output.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressOutputServiceImpl implements AddressOutputService {

    private final AddressRepository addressRepository;
    private final EmployeeServiceProxy employeeServiceProxy;

    public AddressOutputServiceImpl(AddressRepository addressRepository, EmployeeServiceProxy employeeServiceProxy) {
        this.addressRepository = addressRepository;
        this.employeeServiceProxy = employeeServiceProxy;
    }

    @Override
    public List<Address> getAllAddresses() {
        List<AddressModel> addressModels = addressRepository.findByOrderByAddressIDAsc();

        return addressModels.stream()
                .map(AddressMapper::mapModelToClass)
                .toList();
    }

    @Override
    public Address createAddress(Address address) {

        AddressModel addressModel = AddressMapper.mapClassToModel(address);
        AddressModel savedAddress = addressRepository.save(addressModel);

        return AddressMapper.mapModelToClass(savedAddress);
    }

    @Override
    public List<Address> getAddressByInfo(AddressDto addressDto) {
        List<AddressModel> addressModels = addressRepository.findByNumAndStreetAndPbAndCityAndCountry(
                addressDto.getNum(), addressDto.getStreet(), addressDto.getPb(), addressDto.getCity(), addressDto.getCountry());
        return addressModels.stream()
                .map(AddressMapper::mapModelToClass)
                .toList();
    }

    @Override
    public void deleteAddress(Long addressID) {
        addressRepository.deleteById(addressID);
    }

    @Override
    public Optional <Address> getAddressByID(Long addressID) throws AddressNotFoundException {
       AddressModel addressModel = addressRepository.findById(addressID).orElseThrow(
               AddressNotFoundException::new
       );

       return Optional.of(AddressMapper.mapModelToClass(addressModel));
    }

    @Override
    public void updateAddress(Address address) {
        AddressModel addressModel = AddressMapper.mapClassToModel(address);
        AddressModel savedAddress = addressRepository.save(addressModel);
        AddressMapper.mapModelToClass(savedAddress);
    }

    @Override
    public List<EmployeeModel> getEmployeesLivingAtAddress(Long addressID) {
        return employeeServiceProxy.getEmployeesLivingAtGivenAddress(addressID);
    }
}
