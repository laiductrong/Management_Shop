import React from "react";
import axios from "axios";
// import Button from "react-bootstrap/Button";
// import Form from "react-bootstrap/Form";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";

class Register extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      username: "",
      pass: "" /*sdt*/,
      confirmpass: "",
      address: "",
      CFpass: false,
    };

    this.handleChange = this.handleChange.bind(this);
    this.handleChangePass = this.handleChangePass.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleChangeConfirmPass = this.handleChangeConfirmPass.bind(this);
    this.handleChangeAddress = this.handleChangeAddress.bind(this);
  }

  handleChange(event) {
    this.setState({ username: event.target.value });
  }
  handleChangePass(event) {
    this.setState({ pass: event.target.value });
  }
  handleChangeConfirmPass(event) {
    // console.log(this.state.confirmpass);
    this.setState({ confirmpass: event.target.value });

    if (event.target.value === this.state.pass) {
      this.setState({ CFpass: true });
    } else {
      this.setState({ CFpass: false });
    }
  }
  handleChangeAddress(event) {
    this.setState({ address: event.target.value });
  }

  handleSubmit(event) {

    const data = {
      idcustomer: 5,
      name: this.state.username,
      phonenumber: this.state.pass,
      address: this.state.address,
    };
    const headers = {
      Authorization: "Bearer my-token",
      "My-Custom-Header": "foobar",
    };
    axios
      .put("http://localhost:8080/api/v1/Customer/update/5", data, { headers })
      .then(response => console.log(response.data.status));
    event.preventDefault();
  }

  render() {
    return (
      <>
        <Container>
          <Row>
            <Col></Col>
            <Col></Col>
          </Row>
          <Row>
            <Col></Col>
            <Col>
              <form onSubmit={this.handleSubmit}>
                <label>
                  Name:
                  <br />
                  <input
                    type="text"
                    value={this.state.username}
                    onChange={this.handleChange}
                  />
                </label>
                <br />
                <label>
                  Password:
                  <br />
                  <input
                    type="password"
                    value={this.state.pass}
                    onChange={this.handleChangePass}
                  />
                </label>
                {this.state.CFpass ? <p>oke</p> : <p>not ok</p>}
                <label>
                  Confirm Password:
                  <br />
                  <input
                    type="password"
                    value={this.state.confirmpass}
                    onChange={this.handleChangeConfirmPass}
                  />
                </label>
                <br />
                <label>
                  Address:
                  <br />
                  <input
                    type="text"
                    value={this.state.address}
                    onChange={this.handleChangeAddress}
                  />
                </label>
                <br />
                <input type="submit" value="Submit" />
              </form>
            </Col>
            <Col></Col>
          </Row>
        </Container>
      </>

      // <Form>
      //   <Form.Group className="mb-3" controlId="formBasicEmail">
      //     <Form.Label>Email address</Form.Label>
      //     <Form.Control type="email" placeholder="Enter email" />
      //     <Form.Text className="text-muted">
      //       We'll never share your email with anyone else.
      //     </Form.Text>
      //   </Form.Group>

      //   <Form.Group className="mb-3" controlId="formBasicPassword">
      //     <Form.Label>Password</Form.Label>
      //     <Form.Control type="password" placeholder="Password" />
      //   </Form.Group>
      //   <Form.Group className="mb-3" controlId="formBasicCheckbox">
      //     <Form.Check type="checkbox" label="Check me out" />
      //   </Form.Group>
      //   <Button variant="primary" type="submit">
      //     Submit
      //   </Button>
      // </Form>
    );
  }
}

export default Register;
