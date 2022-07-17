import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import {
  BrowserRouter, Route, Routes
} from 'react-router-dom';
import CustomerMain from './components/Customers/CustomerMain';
import Customer from './components/Customers/Customer';
import OrganisationMain from './components/Organisation/OrganisationMain';


console.log("Start index.js")
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<App />}>
          <Route path="customers" element={<CustomerMain />}>
            <Route
              index
              element={
                <main style={{ padding: "1rem" }}>
                  <p>Select an invoice</p>
                </main>
              }
            />
            <Route path=":customerId" element={<Customer />} />
          </Route>
          <Route path="/organisations" element={<OrganisationMain />} />
        </Route>
        <Route path="*" element={
          <main style={{ padding: "1rem" }}>
            <p>There's nothing here</p>
          </main>
        } />
      </Routes>
    </BrowserRouter>

  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
