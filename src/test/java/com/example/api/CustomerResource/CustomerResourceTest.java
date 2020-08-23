package com.example.api.CustomerResource;


import com.example.api.domain.Address;
import com.example.api.domain.Customer;
import com.example.api.exception.BadRequestException;
import com.example.api.exception.BadRequestViaCepException;
import com.example.api.exception.NotFoundException;
import com.example.api.repository.AddressRepository;
import com.example.api.repository.CustomerRepository;
import com.example.api.service.AddressService;
import com.example.api.service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CustomerResourceTest {

    @InjectMocks
    private CustomerService service;

    @InjectMocks
    private AddressService addressService;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private AddressRepository addressRepository;

    @Test
    public void case2() {

        Customer customer = new Customer();

        customer.setEmail("");
        customer.setName("Pedro 123");

        Assertions.assertThrows(BadRequestException.class, () -> service.validarDados(customer));

        customer.setEmail("123123");
        customer.setName("");

        Assertions.assertThrows(BadRequestException.class, () -> service.validarDados(customer));

    }

    @Test
    public void case3() throws BadRequestException {

        List<Address> lstAddress = new ArrayList<>();
        Address address = new Address();
        address.setCep("1231231123");
        lstAddress.add(address);

        Customer customer = new Customer();

        customer.setEmail("123123");
        customer.setName("Pedro 123");
        customer.setAddressList(lstAddress);

        Assertions.assertThrows(BadRequestViaCepException.class, () -> addressService.buscarViaCep(lstAddress));
    }

    @Test
    public void case4() throws BadRequestException {

        CustomerService customerService = new CustomerService(this.customerRepository, this.addressService);

        List<Address> lstAddress = new ArrayList<>();
        Address address = new Address();
        address.setCep("19801287");
        lstAddress.add(address);

        Customer customer = new Customer();

        customer.setEmail("123123");
        customer.setName("Pedro 123");
        customer.setAddressList(lstAddress);

        Assertions.assertDoesNotThrow(() -> customerService.save(customer));
    }

    @Test
    public void case5() throws BadRequestException, NotFoundException {

        List<Address> lstAddress = new ArrayList<>();
        Address address = new Address();
        address.setCep("19801287");
        lstAddress.add(address);

        Customer customer = new Customer();

        customer.setId(1L);
        customer.setEmail("123123");
        customer.setName("Pedro 123");
        customer.setAddressList(lstAddress);

        Assertions.assertThrows(NotFoundException.class, () -> service.findById(customer.getId()));
    }

    @Test
    public void case6() throws BadRequestException, NotFoundException {
        Assertions.assertDoesNotThrow(() -> service.findAllPagination(5, 1));
    }

}
