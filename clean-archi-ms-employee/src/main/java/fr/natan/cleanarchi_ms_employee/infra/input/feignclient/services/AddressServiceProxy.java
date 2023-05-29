package fr.natan.cleanarchi_ms_employee.infra.input.feignclient.services;

import fr.natan.cleanarchi_ms_employee.infra.input.feignclientfallback.AddressServiceProxyFallback;
import fr.natan.cleanarchi_ms_employee.infra.input.feignclient.models.AddressModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CLEAN-ARCHI-BS-MS-ADDRESS", fallback = AddressServiceProxyFallback.class)
@Qualifier("address-service-proxy")
public interface AddressServiceProxy {
    @GetMapping(value = "/addresses/{addressID}", produces = "application/json")
    AddressModel getAddressById(@PathVariable(name = "addressID") Long addressID);
}
