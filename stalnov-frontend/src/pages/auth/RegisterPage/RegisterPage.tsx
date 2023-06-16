import { Box, Button, ButtonGroup, Card, CardContent, Link, useMediaQuery } from "@mui/material";
import { Form } from "@n7studio/react-original-form";
import axios from "axios";
import { useState } from "react";
import { defaults } from "../../../configs";
import { Wrapper } from "../../../layout";
import { steps } from "./steps";
import { validationSchema1, validationSchema2, validationSchema3 } from "./validationSchema";


const baseUrl = "http://localhost:8080";
axios.defaults.baseURL = baseUrl;

type RegisterInput = {
    email: string;
    password: string;
    pseudo: string;
}

export default function RegisterPage() {
    const [stepIndex, setStepIndex] = useState(0);
    const validationSchemas = [validationSchema1, validationSchema2, validationSchema3];
    const isMobile = useMediaQuery(defaults.mobileBreakpoint);
    const isLastStep = stepIndex === steps.length - 1;

    const onNext = () => {
        stepIndex < steps.length - 1 && setStepIndex(stepIndex + 1);
    }

    const onPrevious = () => {
        stepIndex > 0 && setStepIndex(stepIndex - 1);
    }

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
                        onSubmit={(values: RegisterInput) => {
                            console.log(values);

                            if (isLastStep) {
                                // API Call 
                                return;
                            }

                            onNext();
                        }}
                        validationSchema={validationSchemas[stepIndex]}
                    >
                        <Box sx={{ textAlign: "center" }}>
                            <p style={{ fontSize: "50px", margin: 0, fontWeight: "600" }} >Créer un compte</p>
                            <p>Rejoignez notre communaute de lecteurs</p>
                        </Box>
                        <Box sx={{ display: "flex", flexDirection: "column", gap: "1em", m: "2em 0" }}>
                            {steps[stepIndex]}
                        </Box>
                        <ButtonGroup disableElevation fullWidth variant="contained" >
                            <Button sx={{ fontWeight: "bold" }} size="large" onClick={onPrevious}>Précédant</Button>
                            <Button sx={{ fontWeight: "bold" }} size="large" type="submit">{isLastStep ? "Valider" : "Suivant"}</Button>
                        </ButtonGroup>
                    </Form>
                    <Box marginTop={5} sx={{ textAlign: "center" }}>
                        <p>Vous avez déjà un compte? <Link href="/auth/login"> Connectez-vous </Link> </p>
                    </Box>
                </CardContent>
            </Card>
        </Wrapper>
    )
}