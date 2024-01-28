import axios from "axios";
import jsonpAdapter from 'axios-jsonp';
const instance = axios.create({
    baseURL: "https://cors-anywhere.herokuapp.com/https://trip2mk.azurewebsites.net",
    headers: { 
        // "Access-Control-Allow-Origin": "*"
    }
})

export default instance;