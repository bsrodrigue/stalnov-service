import { TextField, Button } from "@mui/material";
import { DatePicker } from "@mui/x-date-pickers";
import { Form } from "@n7studio/react-original-form";
import { useMutation } from "@tanstack/react-query";
import type { Dayjs } from "dayjs";
import axios from "axios";
import { useState } from "react";

const baseUrl = "http://localhost:8080";
axios.defaults.baseURL = baseUrl;

type RegisterInput = {
    email: string;
    password: string;
    pseudo: string;
    birthdate: Dayjs;
}

export default function RegisterPage() {
    const mutation = useMutation({
        mutationFn: (body: RegisterInput) => {
            return axios.post(`/api/auth/register`, body);
        },
        onSuccess: (data) => {
            console.log(data);
        },
        onError: (error) => {
            console.log(error);
        }
    });

    const [date, setDate] = useState<Dayjs | null>();

    return (
        <Form
            onSubmit={(input: RegisterInput) => {
                if (date) {
                    input.birthdate = date;
                }
                mutation.mutate(input);
            }}
        >
            <div style={{
                backgroundColor: "white",
                display: "flex",
                flexDirection: "column",
                gap: "1em",
                padding: "1em"
            }}>
                <TextField label="Email" name='email' type='email' />
                <TextField label="Mot de passe" name='password' type='password' />
                <TextField label="Pseudo" name='pseudo' />
                <DatePicker
                    label="Date de naissance"
                    onChange={setDate}
                />
                <Button type="submit" variant="contained">S'enregistrer</Button>
            </div>
        </Form>
    )
}