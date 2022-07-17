package org.api.zing.repositories

import org.api.zing.models.Customer
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepo: MongoRepository<Customer, String>{

}