import "./style.module.css";

type AuthTextInputProps = {
    name?: string;
    onChange?: (value: string) => void;
    placeholder?: string;
    type?: "password" | "email" | "text";
}

export default function AuthTextInput({ onChange, ...rest }: AuthTextInputProps) {
    return (
        <input className="input" onChange={(e) => onChange?.(e.target.value)} {...rest} />
    )
}