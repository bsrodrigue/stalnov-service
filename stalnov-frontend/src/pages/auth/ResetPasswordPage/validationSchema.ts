import { object, string } from "yup";

export const validationSchema = object({
    password: string().email().required(),
    password2: string().email().required(),
});