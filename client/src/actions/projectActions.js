import axios from "axios";
import { GET_ERRORS, GET_PROJECT, GET_PROJECTS } from "./type";

export const createProject = (project, history) => async dispatch => {
    try{
        const res = await axios.post("http://localhost:8081/api/project", project)
        history.push("/dashboard");
        dispatch({
            type:GET_ERRORS,
            payload:{}
        })
    } catch(err) {
        dispatch({
            type:GET_ERRORS,
            payload:err.response.data
        })
    }
};

export const getProjects = () => async dispatch => {
    const res = await axios.get("http://localhost:8081/api/project/all")
    dispatch({
        type: GET_PROJECTS,
        payload: res.data
    });
}

export const getProject = (id, history) => async dispatch => {
    try {
        const res = await axios.get(`http://localhost:8081/api/project/${id}`)
        dispatch({
            type: GET_PROJECT,
            payload: res.data
        });
    } catch (error) {
        history.push("/dashboard");
    }
   
}