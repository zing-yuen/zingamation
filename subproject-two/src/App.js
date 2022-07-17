// import logo from './logo.svg';
import './App.css';
import Tick from './demo/Tick';
import Delayed from './demo/Delayed';
import {
  Link, Outlet
} from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <div>
          <p id="firstName">Zing</p>
          <Tick />
          <Delayed />
          <nav>
            <Link to="/customers">Customers</Link> | {""}
            <Link to="/organisations">Organisations</Link>
          </nav>

          <Outlet />
        </div>
        {/* <img src={logo} className="App-logo" alt="logo" /> */}
        {/* <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a> */}
      </header>
    </div>
  );
}

export default App;