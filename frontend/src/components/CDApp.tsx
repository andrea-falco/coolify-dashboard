import {useState} from "react";
import {Button} from "@mui/material";

function CDApp() {
    const [count, setCount] = useState(0);

    const handleClick = () => {
        setCount(count + 1);
    }

    return (
        <Button variant={"outlined"} onClick={handleClick}>App {count}</Button>
    );
}

export default CDApp;