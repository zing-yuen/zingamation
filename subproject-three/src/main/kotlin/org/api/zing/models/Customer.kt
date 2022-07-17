package org.api.zing.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("customer")
class Customer {
    @Id
    var id: String = ""

    var firstName: String = ""
    var secondName: String = ""

}