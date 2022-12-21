import React from "react";
import axios from "axios";
// import Button from "react-bootstrap/Button";
// import Form from "react-bootstrap/Form";
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

class Login extends React.Component {
  constructor(props) {
    super(props);
    this.state = { username: "", pass: "" };//username: phonenumber, pass: name

    this.handleChange = this.handleChange.bind(this);
    this.handleChangePass = this.handleChangePass.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({ username: event.target.value });
  }
  handleChangePass(event) {
    this.setState({ pass: event.target.value });
  }

  handleSubmit(event) {
    var config = {
      headers: { "Access-Control-Allow-Origin": "*" },
    };
    axios
      .get("http://localhost:8080/api/v1/Customer/getUser/"+this.state.username+"&"+this.state.pass, config)
      .then(function(response) {
        console.log(response.data.status);
        if (response.data.status === "oke") {
          console.log(typeof(JSON.stringify(response.data.data[0].idcustomer)));
          localStorage.setItem('id_user',JSON.stringify(response.data.data[0].idcustomer));
        }
      });
      // axios
      // .get("http://localhost:8080/api/v1/Customer/getByIDCustomer/1", config)
      // .then(function(response) {
      //   console.log(response.data.status);
      //   if (response.data.status === "oke") {
      //     console.log(typeof(JSON.stringify(response.data.data.idcustomer)));
      //     localStorage.setItem('id_user',JSON.stringify(response.data.data.idcustomer));
      //   }
      // });
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
                  <br/>
                  <input
                    type="text"
                    value={this.state.username}
                    onChange={this.handleChange}
                  />
                </label>
                <br/>
                <label>
                  Password:
                  <br/>
                  <input
                    type="password"
                    value={this.state.pass}
                    onChange={this.handleChangePass}
                  />
                </label>
                <br/>
                <input type="submit" value="Login" />
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

export default Login;
