import { Box, Button, Card, CardContent, Link, TextField, useMediaQuery } from "@mui/material";
import { Form } from "@n7studio/react-original-form";
import { defaults } from "../../../configs";
import { Wrapper } from "../../../layout";
import { validationSchema } from "./validationSchema";
import { notifySuccess } from "../../../lib/notifications";

type LoginInput = {
    email: string;
    password: string;
}

export default function RegisterPage() {
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
                        onSubmit={(values: LoginInput) => {
                            console.log(values);
                            notifySuccess("Connexion réussie")
                        }}>
                        <Box sx={{ textAlign: "center" }}>
                            <p style={{ fontSize: "50px", margin: 0, fontWeight: "600" }} >Connexion</p>
                            <p>Nous sommes ravis de vous revoir</p>
                            <p>Vous avez oublié votre mot de passe? <Link href="/auth/reset-password"> Cliquez-ici! </Link> </p>
                        </Box>
                        <Box sx={{ display: "flex", flexDirection: "column", gap: "1em", m: "2em 0" }}>
                            <TextField name="email" type="email" label="Adresse Email" />
                            <TextField name="password" type="password" label="Mot de passe" />
                        </Box>
                        <Button sx={{ fontWeight: "bold" }} size="large" type="submit" fullWidth variant="contained" >Se Connecter</Button>
                    </Form>
                    <Box sx={{ textAlign: "center" }}>
                        <p>Vous n'avez pas encore un compte? <Link href="/auth/register"> Inscrivez-vous </Link> </p>
                    </Box>
                </CardContent>
            </Card>
        </Wrapper>
    )
}