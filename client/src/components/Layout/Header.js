import React, { Component } from "react";
import { Link } from "react-router-dom";

class Header extends Component {
  render() {
    return (
      <nav className="navbar navbar-expand-sm navbar-dark bg-danger mb-4">
        <div className="container">
          <Link className="navbar-brand" to="/dashboard">
           <h2>Jira Software</h2> 
          </Link>
          <button
            className="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#mobile-nav"
          >
            <span className="navbar-toggler-icon" />
          </button>

          <div className="collapse navbar-collapse" id="mobile-nav">
            <ul className="navbar-nav mr-auto">
              <li className="nav-item">
                <Link className="nav-link" to="/dashboard">
                  Dashboards
                </Link>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="/dashboard">
                  Issues
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="/dashboard">
                  JExel
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="/dashboard">
                  Boards
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="/dashboard">
                  Commits
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="/dashboard">
                  Quick Timesheet
                </a>
              </li>
            </ul>
           
            <ul className="navbar-nav ml-auto">
              <li className="nav-item">
                <Link to="/register" className="nav-link ">
                  Sign Up
                </Link>
              </li>
              <li className="nav-item">
                <Link to="/login" className="nav-link" href="login.html">
                  Log In
                </Link>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    );
  }
}

export default Header;
