import { Box, Button, Card, CardContent, TextField, useMediaQuery } from "@mui/material";
import { Form } from "@n7studio/react-original-form";
import { defaults } from "../../../configs";
import { Wrapper } from "../../../layout";
import { notifySuccess } from "../../../lib/notifications";
import { validationSchema } from "./validationSchema";

type ResetPasswordInput = {
    email: string;
}

export default function ResetPasswordPage() {
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
                            <p style={{ fontSize: "50px", margin: 0, fontWeight: "600" }} >Nouveau mot de passe</p>
                            <p>Veuillez à présent saisir un nouveau mot de passe</p>
                        </Box>
                        <Box sx={{ display: "flex", flexDirection: "column", gap: "1em", m: "2em 0" }}>
                            <TextField name="password" type="password" label="Nouveau mot de passe" placeholder="Veuillez saisir votre nouveau mot de passe" />
                            <TextField name="password2" type="password" label="Confirmation du mot de passe" placeholder="Veuillez confirmer votre nouveau mot de passe" />
                        </Box>
                        <Button sx={{ fontWeight: "bold" }} size="large" type="submit" fullWidth variant="contained" >Changer de mot de passe</Button>
                    </Form>
                </CardContent>
            </Card>
        </Wrapper>
    )
}