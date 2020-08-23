package com.example.api.service;

import com.example.api.domain.Address;
import com.example.api.exception.BadRequestViaCepException;
import com.example.api.repository.AddressRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> buscarViaCep(List<Address> lstAddress) {
        if (lstAddress != null) {

            lstAddress.forEach(address -> {

                RestTemplate restTemplate = new RestTemplate();
                String fooResourceUrl
                        = "https://viacep.com.br/ws/";

                try {
                    ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl + "/" + address.getCep() + "/json", String.class);

                    Gson gson = new Gson();
                    Address addressresponse = gson.fromJson(response.getBody(), Address.class);

                    address.setBairro(addressresponse.getBairro());
                    address.setComplemento(addressresponse.getComplemento());
                    address.setLocalidade(addressresponse.getLocalidade());
                    address.setUf(addressresponse.getUf());
                    address.setLogradouro(addressresponse.getLogradouro());
                } catch (HttpClientErrorException e) {
                    throw new BadRequestViaCepException("Cep Inválido: " + address.getCep());
                }


            });
        }
        return lstAddress;
    }

    public void salvarListaEndereco(List<Address> lstAddress) {

        lstAddress.forEach(adress -> {
            addressRepository.save(adress);
        });

    }

}