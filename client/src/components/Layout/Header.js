import React, { Component } from "react";

class Header extends Component {
  render() {
    return (
      <nav className="navbar navbar-expand-sm navbar-dark bg-danger mb-4">
        <div className="container">
          <a className="navbar-brand" href="#">
           <h2>Jira Software</h2> 
          </a>
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
                <a className="nav-link" href="/dashboard">
                  Dashboards
                </a>
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
                <a className="nav-link " href="register.html">
                  Sign Up
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="login.html">
                  Log In
                </a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    );
  }
}

export default Header;
