import axios from "axios";
import { RegisterForm } from "../../../components";

const baseUrl = "http://localhost:8080";
axios.defaults.baseURL = baseUrl;

type RegisterInput = {
    email: string;
    password: string;
    pseudo: string;
}

export default function RegisterPage() {

    return (
        <RegisterForm />
    )
}