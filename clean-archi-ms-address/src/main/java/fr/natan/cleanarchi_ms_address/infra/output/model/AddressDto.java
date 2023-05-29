package fr.natan.cleanarchi_ms_address.infra.output.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class AddressDto {
    private int num;
    private String street;
    private int pb;
    private String city;
    private String country;
}
