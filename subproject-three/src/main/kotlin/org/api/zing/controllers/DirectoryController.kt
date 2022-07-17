package org.api.zing.controllers

import org.api.zing.models.Customer
import org.api.zing.services.CustomerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/directory")
class DirectoryController(
    val customerService: CustomerService
) {

    @GetMapping("/")
    fun getAll(): List<Customer> {
        return customerService.getAllCustomers()
    }
}