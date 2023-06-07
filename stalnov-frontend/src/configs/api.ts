import axios from "axios";

const baseUrl = "http://localhost:8080";
axios.defaults.baseURL = baseUrl;

export default axios;