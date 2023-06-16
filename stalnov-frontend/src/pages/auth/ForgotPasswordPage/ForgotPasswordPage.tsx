import { Box, Button, Card, CardContent, Link, TextField, useMediaQuery } from "@mui/material";
import { Form } from "@n7studio/react-original-form";
import { defaults } from "../../../configs";
import { Wrapper } from "../../../layout";
import { validationSchema } from "./validationSchema";
import { notifySuccess } from "../../../lib/notifications";

type ResetPasswordInput = {
    email: string;
}

export default function ForgotPasswordPage() {
    const isMobile = useMediaQuery(defaults.mobileBreakpoint);

    const smallStyle = {
        width: "100vw",
        my: "0%"
    };

    const bigStyle = {
        width: "650px",
        my: "10%"
    }

    return (
        <Wrapper>
            <Card sx={[isMobile ? smallStyle : bigStyle, { borderRadius: 5, boxShadow: 3, marginX: "auto" }]}>
                <CardContent sx={{ margin: "1em 1.5em" }} >
                    <Form
                        validationSchema={validationSchema}
                        onSubmit={(values: ResetPasswordInput) => {
                            console.log(values);
                            notifySuccess("Connexion réussie")
                        }}>
                        <Box sx={{ textAlign: "center" }}>
                            <p style={{ fontSize: "50px", margin: 0, fontWeight: "600" }} >Réinitialisation</p>
                            <p>Vous-vous souvenez de votre mot de passe? <Link href="/auth/login"> Cliquez-ici! </Link> </p>
                        </Box>
                        <Box sx={{ display: "flex", flexDirection: "column", gap: "1em", m: "2em 0" }}>
                            <TextField name="email" type="email" label="Adresse Email" placeholder="Veuillez entrer votre adresse email pour recevoir un lien de réinitialisation" />
                        </Box>
                        <Button sx={{ fontWeight: "bold" }} size="large" type="submit" fullWidth variant="contained" >Envoyer le lien de récupération</Button>
                    </Form>
                    <Box sx={{ textAlign: "center" }}>
                        <p>Vous n'avez pas encore un compte? <Link href="/auth/register"> Inscrivez-vous </Link> </p>
                    </Box>
                </CardContent>
            </Card>
        </Wrapper>
    )
}