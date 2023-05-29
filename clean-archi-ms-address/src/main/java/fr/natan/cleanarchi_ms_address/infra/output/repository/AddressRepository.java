package fr.natan.cleanarchi_ms_address.infra.output.repository;

import fr.natan.cleanarchi_ms_address.infra.output.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<AddressModel, Long> {
    List<AddressModel> findByOrderByAddressIDAsc();
    List<AddressModel> findByNumAndStreetAndPbAndCityAndCountry(int num, String street, int pb, String city, String country);
}
