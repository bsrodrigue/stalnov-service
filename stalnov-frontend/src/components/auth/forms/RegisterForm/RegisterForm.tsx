import { Form } from "@n7studio/react-original-form";
import { AuthTextInput } from "../../..";

export default function RegisterForm() {


    return (
        <Form>
            <div style={{
                backgroundColor: "white",
                display: "flex",
                flexDirection: "column",
                gap: "1em",
                padding: "1em",
                maxWidth: "500px",
                borderRadius: "1.5em"
            }}>
                <p>Créer un compte</p>
                <p>Vous avez déjà un compte? <span>Connectez-vous</span> </p>
                <AuthTextInput type="email" name="email" placeholder="Veuillez saisir votre adresse email" />
                <AuthTextInput type="password" name="password" placeholder="Veuillez saisir votre mot de passe" />
                <AuthTextInput type="password" name="password2" placeholder="Veuillez confirmer votre mot de passe" />
            </div>
        </Form>
    )
}