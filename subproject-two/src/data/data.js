let customers = [
    {
        id: 1001,
        firstName: "James",
        lastName: "Tan"
    },
    {
        id: 1002,
        firstName: "Peter",
        lastName: "Tan"
    }
]

export function getCustomers() {
    return customers;
}

export function getCustomer(id) {
    return customers.find(
        (customer) => customer.id === id
    );
}