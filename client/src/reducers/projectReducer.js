import { GET_PROJECT, GET_PROJECTS } from "../actions/type";
const iniatialState = {
    projects: [],
    project: {}
};

export default function(state =iniatialState, action) {
    switch(action.type) {
        case GET_PROJECTS:
        return {
            ... state,
            projects:action.payload
        };
        case GET_PROJECT:
            return {
                ...state,
                project: action.payload
            }
        default:
            return state;
    }
}