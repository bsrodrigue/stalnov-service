import { Box, Stack } from "@mui/material";
import { ReactNode } from "react";
import logo from "../../assets/icons/logo.png";
import { Wrapper } from "../../layout";

type HeaderProps = {
    children?: ReactNode;
}

export default function Header({ children }: HeaderProps) {
    return (
        <Wrapper>
            <Stack justifyContent="space-between" alignItems="center" direction="row">
                <Box paddingTop={5}>
                    <img src={logo} height={65} width={250} />
                </Box>
                {children}
            </Stack>
        </Wrapper>
    )
}