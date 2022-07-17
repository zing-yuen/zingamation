package org.api.zing.services

import org.api.zing.models.Customer
import org.api.zing.repositories.CustomerRepo
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerRepo: CustomerRepo
) {

    fun getAllCustomers(): List<Customer> {
        return customerRepo.findAll()
    }
}