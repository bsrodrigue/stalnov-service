import { createTheme } from '@mui/material/styles';

export const theme = createTheme({
    palette: {
        primary: {
            main: "#22A39F"
        }
    },

    components: {
        MuiFormLabel: {
            styleOverrides: {
                root: {
                    fontWeight: "bold"
                }
            }
        },

        MuiOutlinedInput: {
            styleOverrides: {
                root: {
                    borderRadius: 10,
                    backgroundColor: "#EDEDED",
                }
            }
        },

        MuiButton: {
            styleOverrides: {
                root: {
                    borderRadius: 10
                }
            }
        }
    },
});