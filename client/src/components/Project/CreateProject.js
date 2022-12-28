import React from 'react'
import {Link} from "react-router-dom"

 const CreateProject = () => {
  return (
    <React.Fragment>
        <Link to="/addProject" className="btn btn-lg btn-primary">
            Create a Project
        </Link>
    </React.Fragment>
  );
}
export default CreateProject;