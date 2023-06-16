import { Box, Stack } from "@mui/material";
import { AuthLink, Header } from "../../../components";
import { Wrapper } from "../../../layout";

export default function HomePage() {

    return (
        <Box bgcolor="white">
            <Wrapper>
                <Header >
                    <Stack direction="row" gap={1}>

                        <AuthLink underline="none" href="/auth/login">Se déconnecter</AuthLink>
                    </Stack>
                </Header>
            </Wrapper>
        </Box>
    );
}