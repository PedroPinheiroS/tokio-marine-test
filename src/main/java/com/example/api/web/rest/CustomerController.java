package com.example.api.web.rest;

import com.example.api.domain.Customer;
import com.example.api.exception.BadRequestException;
import com.example.api.exception.NotFoundException;
import com.example.api.service.AddressService;
import com.example.api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService service;

    private AddressService addressService;

    @Autowired
    public CustomerController(CustomerService service, AddressService addressService) {
        this.service = service;
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity findAll(@Nullable @RequestParam Integer itensPagina, @Nullable @RequestParam Integer numeroPagina) {

        if (itensPagina == null && numeroPagina == null) {
            return ResponseEntity.status(200).body(service.findAll());
        }

        return ResponseEntity.status(206).body(service.findAllPagination(itensPagina, numeroPagina));
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable Long id) throws NotFoundException {
        return service.findById(id);
    }

    @PostMapping("/new")
    public ResponseEntity newCustomer(@RequestBody Customer customerJson) throws BadRequestException {

        service.validarDados(customerJson);

        return ResponseEntity.ok().body(service.save(customerJson));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@RequestBody Customer customerJson, @PathVariable Long id) throws NotFoundException {

        Customer customer = service.updateById(id, customerJson);

        service.save(customer);

        return ResponseEntity.ok().body(customer);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) throws NotFoundException {

        Customer customer = service.findById(id);
        service.delete(customer);

        return ResponseEntity.noContent().build();

    }

}
