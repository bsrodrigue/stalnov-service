import { TextField, FormControl, InputLabel, Select, MenuItem } from "@mui/material";
import { defaults } from "../../../configs";
import { FormPartial } from "@n7studio/react-original-form";
import { useFormContext } from "react-hook-form";
import { useEffect, useState } from "react";

function Step1() {
    return (
        <FormPartial>
            <TextField name="email" type="email" label="Adresse Email" />
            <TextField name="password" type="password" label="Mot de passe" />
            <TextField name="password2" type="password" label="Confirmation de mot de passe" />
        </FormPartial>
    );
}

function Step2() {
    const [gender, setGender] = useState("male");

    const { setValue } = useFormContext();

    const handleChange = (value: string) => {
        setGender(value);
        setValue("gender", value);
    }

    useEffect(() => {
        setValue("gender", gender);
    }, []);


    return (
        <FormPartial>
            <TextField name="firstName" label="Nom de famille" />
            <TextField name="lastName" label="Prénom" />

            <FormControl>
                <InputLabel id="">Genre</InputLabel>
                <Select value={gender} onChange={(e) => handleChange(e.target.value)} name="gender" label="Genre">
                    {
                        defaults.genders.map((gender) => (<MenuItem key={gender.value} value={gender.value}>{gender.label}</MenuItem>))
                    }
                </Select>
            </FormControl>
        </FormPartial>
    );
}

function Step3() {
    return (
        <FormPartial>
            <TextField name="pseudo" label="Pseudo" placeholder="Veuillez entrer votre pseudonyme" />
            <TextField name="bio" label="Bio" placeholder="Veuillez parler un peu de vous" multiline rows={5} />
        </FormPartial>
    );
}

export const steps = [
    <Step1 />,
    <Step2 />,
    <Step3 />,
];

