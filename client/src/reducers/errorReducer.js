import { GET_ERRORS } from "../actions/type";

const iniatialState = {};
export default function(state=iniatialState, action) {
    switch(action.type) {
        case GET_ERRORS:
            return action.payload;
            
            default:
                return state;
    }
}