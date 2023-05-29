package fr.natan.cleanarchi_ms_address.infra.output.mapper;

import fr.natan.cleanarchi_ms_address.domain.entity.Address;
import fr.natan.cleanarchi_ms_address.infra.output.model.AddressDto;
import fr.natan.cleanarchi_ms_address.infra.output.model.AddressModel;
import org.springframework.beans.BeanUtils;

public class AddressMapper {
    private AddressMapper(){}

    public static AddressModel mapClassToModel(Address address){
        AddressModel addressModel = new AddressModel();
        BeanUtils.copyProperties(address, addressModel);

        return addressModel;
    }

    public static Address mapModelToClass(AddressModel addressModel){
        Address address = new Address();
        BeanUtils.copyProperties(addressModel, address);

        return address;
    }

    public static Address mapDtoToClass(AddressDto addressDto) {
        Address address = new Address();
        BeanUtils.copyProperties(addressDto, address);
        return  address;
    }
}
