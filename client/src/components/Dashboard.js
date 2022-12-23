import React, { Component } from 'react';
import CreateProject from './Project/CreateProject';
import ProjectItem from "./Project/ProjectItem";
 class Dashboard extends Component {
  render() {
    return (
        <div className="projects">
          <div className="container">
            <div className="row">
              <div className="col-md-12">
                <h1 className="display-4 text-center">System Dashboard</h1>
                <br />
                <CreateProject/>
                <br />
                <hr />
                <ProjectItem />
              </div>
            </div>
          </div>
        </div>
      );
  }
}

export default Dashboard;
