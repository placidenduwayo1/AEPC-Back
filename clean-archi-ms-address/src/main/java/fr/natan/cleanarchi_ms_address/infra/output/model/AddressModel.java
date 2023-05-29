package fr.natan.cleanarchi_ms_address.infra.output.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "addresses")
@AllArgsConstructor @NoArgsConstructor @Data @ToString
public class AddressModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressID;
    private int num;
    private String street;
    private int pb;
    private String city;
    private String country;
}
