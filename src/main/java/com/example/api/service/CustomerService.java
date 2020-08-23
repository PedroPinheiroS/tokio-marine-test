package com.example.api.service;

import com.example.api.domain.Address;
import com.example.api.domain.Customer;
import com.example.api.exception.BadRequestException;
import com.example.api.exception.BadRequetDeleteException;
import com.example.api.exception.NotFoundException;
import com.example.api.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository repository;
    private AddressService addressService;

    @Autowired
    public CustomerService(CustomerRepository repository, AddressService addressService) {
        this.addressService = addressService;
        this.repository = repository;
    }

    public List<Customer> findAll() {
        return repository.findAllByOrderByNameAsc();
    }

    public Customer findById(Long id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Customer não encontrado por Id"));
    }


    public Customer updateById(Long id, Customer customerJson) throws NotFoundException {

        Customer customer = repository.findById(id).orElseThrow(() -> new NotFoundException("Customer não encontrado por Id"));

        customer.setName(customerJson.getName());
        customer.setEmail(customerJson.getEmail());

        return customer;

    }

    public List<Customer> findAllPagination(Integer itensPagina, Integer numeroPagina) {

        List<Customer> lstCustomer = findAll();

        Integer calculoOffset = (numeroPagina - 1) * itensPagina;
        Integer adicionadosAoRetorno = 0;

        List<Customer> lstRetorno = new ArrayList<>();


        for (int i = calculoOffset; adicionadosAoRetorno < itensPagina && i < lstCustomer.size(); i++) {
            lstRetorno.add(lstCustomer.get(i));
            adicionadosAoRetorno++;
        }

        return repository.findAllByOrderByNameAsc();
    }

    public Customer save(Customer customer) {

        customer.setAddressList(addressService.buscarViaCep(customer.getAddressList()));

        repository.save(customer);

        for (Address address : customer.getAddressList()) {
            address.setId_customer(customer);
        }
        addressService.salvarListaEndereco(customer.getAddressList());


        return customer;
    }

    public void delete(Customer customer) {
        try {
            repository.deleteById(customer.getId());
        } catch (DataIntegrityViolationException e) {
            throw new BadRequetDeleteException("Não é possível deletar um usuario com Endereços Registrados.");
        }
    }

    public void validarDados(Customer customer) throws BadRequestException {
        if (customer.getEmail() == null || customer.getEmail().isEmpty()) {
            throw new BadRequestException("Email não pode ser vazio ou nulo.");
        }

        if (customer.getName() == null || customer.getName().isEmpty()) {
            throw new BadRequestException("Nome não pode ser vazio ou nulo.");
        }
    }

}
