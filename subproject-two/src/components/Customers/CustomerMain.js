import React from 'react';
import { Link, Outlet } from 'react-router-dom';
import { getCustomers } from "../../data/data";

export default function CustomerMain(props) {
  let customers = getCustomers();
  return (
    <div>
      <h2>CustomerMain</h2>
      <div style={{ display: "flex" }}>
        <nav
          style={{
            borderRight: "solid 1px",
            padding: "1rem"
          }}>
          {customers.map((customer) => (
            <Link
              style={{ display: "block", margin: "1rem 0" }}
              to={`/customers/${customer.id}`}
              key={customer.id}
            >
              {customer.id}
            </Link>
          ))}
        </nav>
        <Outlet />
      </div>

    </div>
  )
}
