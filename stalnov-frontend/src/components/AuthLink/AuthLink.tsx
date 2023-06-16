import { Link, styled } from "@mui/material";
import { theme } from "../../theme";

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

export default AuthLink;