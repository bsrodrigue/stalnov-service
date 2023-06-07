import { Box, Button, ButtonGroup, Link, Stack, styled } from "@mui/material";
import logo from "../../../assets/icons/logo.png";
import reader3 from "../../../assets/illustrations/reader3.png";
import writer from "../../../assets/illustrations/writer_1.png";
import reader1 from "../../../assets/illustrations/reader1.png";
import { Wrapper } from "../../../layout";
import { theme } from "../../../theme";
import { ReactNode } from "react";

const AuthLink = styled(Link)({
    padding: "0.5em 1.5em",
    borderRadius: "0.8em",
    border: "1px solid",
    fontWeight: "600",
    fontSize: 20,

    "&:hover": {
        color: "white",
        backgroundColor: theme.palette.primary.main
    }
});


function Header() {
    return (
        <Wrapper>
            <Stack justifyContent="space-between" alignItems="center" direction="row">
                <Box paddingTop={5}>
                    <img src={logo} height={65} width={250} />
                </Box>

                <Stack direction="row" gap={1}>
                    <AuthLink underline="none" href="/auth/register">S'inscrire</AuthLink>
                    <AuthLink underline="none" href="/auth/login">Se Connecter</AuthLink>
                </Stack>
            </Stack>
        </Wrapper>
    )
}

type WelcomeSectionProps = {
    title: string;
    titleColor?: string;
    description: string;
    descriptionColor?: string;
    bgcolor?: string;
    children?: ReactNode;
    img?: ReactNode;
    position?: "left" | "right";
}


function WelcomeSection({ title, titleColor, description, descriptionColor, bgcolor, children, img, position }: WelcomeSectionProps) {

    return (
        <Box bgcolor={bgcolor || "white"}>
            <Wrapper>
                <Stack paddingY={10} justifyContent="space-between" alignItems="center" direction={position === "right" ? "row" : "row-reverse"}>
                    <Stack marginRight={position === "right" ? 15 : 0} sx={{ textAlign: position === "right" ? "start" : "end" }} alignItems={position === "right" ? "start" : "end"} >
                        <h1 style={{ fontSize: 50, lineHeight: 1, color: titleColor || "black" }}>{title}</h1>
                        <p style={{
                            color: descriptionColor || "dimgrey",
                            fontSize: 24,
                            fontWeight: "500",
                            opacity: 0.7,
                        }} >{description}</p>
                        {children}
                    </Stack>
                    {img}
                </Stack>
            </Wrapper>
        </Box>
    )
}

export default function WelcomePage() {


    return (
        <>
            <Box bgcolor="white">
                <Wrapper>
                    <Header />
                </Wrapper>
            </Box>

            <WelcomeSection
                title="La plateforme pour les amoureux de romans en ligne."
                description="Lisez, ecrivez et partagez vos meilleures histoires qui seront accessibles par plus de 100 millions de lecteurs au Burkina."
                img={<img src={reader3} height={400} width={550} />}
                position="right"
            >
                <ButtonGroup>
                    <Button>Découvrir</Button>
                    <Button>Ecrire des histoires</Button>
                </ButtonGroup>
            </WelcomeSection>

            <WelcomeSection
                bgcolor="#22A39F"
                titleColor="white"
                descriptionColor="white"
                title="Liberez votre creativite! Ecrivez et partagez vos histoires"
                description="Ne cherchez plus loin pour decouvrir de nouvelles histoires originales. Quelles que soient vos preferences et vos gouts, vous trouverez forcemment une histoire qui vous tiendra en haleine."
                img={<img src={writer} height={350} width={500} />}
            >
            </WelcomeSection>

            <WelcomeSection
                title="Decouvrez toujours de nouvelles histoires"
                description="Ne cherchez plus loin pour decouvrir de nouvelles histoires originales. Quelles que soient vos preferences et vos gouts, vous trouverez forcemment une histoire qui vous tiendra en haleine."
                titleColor="#22A39F"
                img={<img src={reader1} height={450} width={550} />}
                position="right"
            >
            </WelcomeSection>
        </>
    )

}