import React, { Component } from 'react'
import { Link } from 'react-router-dom';

 class Landing extends Component {
  render() {
    return (
        <div className="landing">
        <div className="light-overlay landing-inner text-dark">
          <div className="container">
            <div className="row">
              <div className="col-md-12 text-center">
                <h2 className="display-3 mb-4">
                     Welcome to Integral Suite JIRA
                </h2>
                <p className="lead">
                  Create your account to join active projects or start your own
                </p>
                <hr />
                <Link className="btn btn-lg btn-info mr-2" to="/register">
                  Sign Up
                </Link>
                <Link className="btn btn-lg btn-primary mr-2" to="/login">
                  Log In
                </Link>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default Landing;
