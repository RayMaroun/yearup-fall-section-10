package com.pluralsight.demoapi.controllers;

import com.pluralsight.demoapi.models.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // Marks this class as a controller where every method returns a domain object instead of a view.
public class CustomerController {

    @RequestMapping(path = "/customers", method = RequestMethod.GET)
    public List<Customer> getCustomers(@RequestParam(required = false) String name) {
        // This method handles GET requests to "/customers".
        // It returns a list of customers. If a 'name' parameter is provided, it filters customers by that name.
        List<Customer> customers = new ArrayList<>();
        // Hardcoded list of customers for demonstration.

        // Adding customers to the list.
        customers.add(new Customer(1, "Raymond", "Lebanon"));
        customers.add(new Customer(2, "Buba", "USA"));
        customers.add(new Customer(3, "Daniel", "USA"));
        customers.add(new Customer(4, "Raymond", "USA"));

        List<Customer> filteredCustomers = new ArrayList<>();
        // Filtering logic: if name is provided, filter customers by that name.
        if (name != null) {
            for (Customer customer : customers) {
                if (customer.getName().toLowerCase().equals(name.toLowerCase())) {
                    filteredCustomers.add(customer);
                }
            }
            return filteredCustomers;
        }

        return customers; // Return the full or filtered list of customers.
    }

    @RequestMapping(path = "/customers/{customerId}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable int customerId) {
        // This method handles GET requests for a specific customer by their ID.
        List<Customer> customers = new ArrayList<>();
        // Hardcoded list of customers for demonstration.

        // Adding customers to the list.
        customers.add(new Customer(1, "Raymond", "Lebanon"));
        customers.add(new Customer(2, "Buba", "USA"));
        customers.add(new Customer(3, "Daniel", "USA"));
        customers.add(new Customer(4, "Raymond", "USA"));

        // Searching for the customer with the given ID.
        for (Customer customer : customers) {
            if (customer.getId() == customerId) {
                return customer; // Return the found customer.
            }
        }
        return null; // Return null if no customer is found with the given ID.
    }
}