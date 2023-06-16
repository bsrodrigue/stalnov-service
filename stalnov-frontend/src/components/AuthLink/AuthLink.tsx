import { Link, styled } from "@mui/material";
import { theme } from "../../theme";

const AuthLink = styled(Link)({
    color: "white",
    padding: "0.6em 1.8em",
    borderRadius: 25,
    fontSize: 20,
    backgroundColor: "black",

    "&:hover": {
        backgroundColor: theme.palette.primary.main
    }
});

export default AuthLink;