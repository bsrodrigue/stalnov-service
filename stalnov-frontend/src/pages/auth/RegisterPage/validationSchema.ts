import { object, string } from "yup";

export const validationSchema1 = object({
    email: string().email().required(),
    password: string().required(),
    password2: string().required()
});

export const validationSchema2 = object({
    firstName: string().required(),
    lastName: string().required(),
    gender: string().required()
});

export const validationSchema3 = object({
    pseudo: string().required(),
    bio: string().required(),
});