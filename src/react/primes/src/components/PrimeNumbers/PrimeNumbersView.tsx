import {
  Button,
  Container,
  InputLabel,
  List,
  ListItem,
  Paper,
  TextField,
  Typography,
} from "@mui/material";
import { useState } from "react";

const PrimeNumbersView = (): JSX.Element => {
  const [upperBound, setUpperBound] = useState("");
  const [responseData, setResponseData] = useState([]);
  const [invalidInput, setInvalidInput]=useState(false);
  const handleSubmit = async (event: { preventDefault: () => void }) => {
    event.preventDefault();
    setInvalidInput(false); //clearing error messages
    const isValidInput = (): boolean => {
      let isValid = true;
      if (Number.isNaN(upperBound)) {
        isValid = false;
      } else if (Number.parseInt(upperBound) < 2) {
        isValid = false;
      }
      return isValid;
    };
    if (isValidInput()) {
      const url = "http://localhost:8080/primes/" + upperBound;
      //try fetch
      fetch(url)
        .then((response) => response.json())
        .then((data) => {
          setResponseData(data);
        })
        .catch((error) => {
          console.error("There was an error!", error);
        });
    }
    else{
          setInvalidInput(true);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <Typography align="center" variant="h4" sx={{ margin: "0.5em" }}>
        Generate Prime Numbers
      </Typography>
      <Paper sx={{ margin: "auto", width: "60%", padding: "2em" }}>
        <Container maxWidth="sm">
          <InputLabel htmlFor="upperBound">Enter a number</InputLabel>
          <TextField
            fullWidth
            error={invalidInput}
            helperText={invalidInput?"Please enter a number greater than 1":""}
            id="upperBound"
            label="Number"
            type="text"
            sx={{ marginTop: "0.5em" }}
            name="upperBound"
            onChange={(e): void => setUpperBound(e.target.value)}
            InputLabelProps={{
              shrink: true,
            }}
          />
          {/* <input type="text" name="upperBound" onChange={(e) :void  => setUpperBound(e.target.value)}/> */}
          <Button type="submit" variant="contained" sx={{ marginTop: "2em" }}>
            Generate
          </Button>
        </Container>
      </Paper>
      <Container sx={{ width: "50%", margin: "auto", padding: "1em" }}>
        {responseData.length > 0 && (
          <Typography align="left" variant="h6" sx={{ margin: "0.5em" }}>
            Here is a list of prime numbers between 0 and the number entered
            above.
          </Typography>
        )}
        <List>
          {responseData.length > 0 &&
            responseData.map((item, index) => {
              return (
                <ListItem
                  sx={{
                    display: "inline",
                    listStyle: "none",
                    padding: "2px",
                    wordWrap: "break-word",
                  }}
                  key={index}
                >
                  {(index ? ", " : "") + item}
                </ListItem>
              );
            })}
        </List>
      </Container>
    </form>
  );
};
export default PrimeNumbersView;
