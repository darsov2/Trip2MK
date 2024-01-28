import axios from "../axios";
// import { config } from '../../Constants'

const authenticate = (username, password) => {
    return axios.post('/auth/authenticate', { username, password }, {
        headers: { 'Content-type': 'application/json'}
    })
}

const signup = (user) => {
    return axios.post('/auth/signup', user, {
        headers: { 'Content-type': 'application/json' }
    })
}

const edit = (user) => {
    return axios.post('/auth/user/edit', user, {
        headers: { 'Content-type': 'application/json' }
    })
}

export const authAPI = {
    authenticate,
    signup,
    edit
}


function basicAuth(user) {
    return `Basic ${user.authdata}`
}