import React from 'react'
import { useParams } from 'react-router-dom'
import { getCustomer } from '../../data/data';

export default function Customer() {
    let params = useParams();
    let customer = getCustomer(parseInt(params.customerId, 10));
    return (
        <main style={{ padding: "1rem" }}>
            <h3>Customer Details</h3>
            <p>Id: {customer.id}</p>
            <p>Customer first name: {customer.firstName}</p>
            <p>Customer last name: {customer.lastName}</p>
        </main>
    )
}
