package fr.natan.cleanarchi_ms_address.domain.usecase;

import fr.natan.cleanarchi_ms_address.infra.output.model.AddressDto;

@SuppressWarnings("ALL")
public class AddressValidation {
    private AddressValidation(){}
    public static boolean areValidAddressTextFields(AddressDto addressDto){
        return !addressDto.getStreet().isBlank()
                && ! addressDto.getCity().isBlank()
                && ! addressDto.getCountry().isBlank()
                ;
    }

    public static boolean isValidNum(int num){
        return num>0;
    }

    public static boolean isValidPb(int pb){
        return pb>10000;
    }

    public static void addressFormatter(AddressDto addressDto){
        addressDto.setStreet(addressDto.getStreet().strip().toUpperCase());
        addressDto.setCity(addressDto.getCity().strip().toUpperCase());
        addressDto.setCountry(addressDto.getCountry().strip().toUpperCase());
    }
}
