import { CombinedState, combineReducers } from "redux";
import errorReducer from "./errorReducer";

export default combineReducers({
    errors:errorReducer
});