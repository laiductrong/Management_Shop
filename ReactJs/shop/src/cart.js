// import React, { useState, useEffect, useLayoutEffect } from "react";
import React, { useState, useEffect } from "react";
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import Table from "react-bootstrap/Table";
import Button from "react-bootstrap/Button";
import Modal from "react-bootstrap/Modal";
import axios from "axios";
function Cart() {
  // const [counter, setCounter] = useState(0);
  const [constructorHasRun, setConstructorHasRun] = useState(false);
  const [carts, setCarts] = useState([]);
  const [id_receipt, setIdReceipt] = useState();
  const [productBuy, setProductBuy] = useState();

  //
  const [show, setShow] = useState(false);

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);
  //

  useEffect(() => {
    document.title = `Cart`;
  });

  const constructor = () => {
    if (constructorHasRun) return;
    setCarts(JSON.parse(localStorage.getItem("cart")));
    setConstructorHasRun(true);
  };
  constructor();
  function cacelBuy(index) {
    const arrayTemp = [...carts];
    arrayTemp.splice(index, 1);
    console.log(arrayTemp);
    setCarts(arrayTemp);
    //set localstorage
    localStorage.removeItem('cart')
    localStorage.setItem('cart',JSON.stringify(arrayTemp));
  }
  function buy(index) {
    setShow(true);
    if (!localStorage.getItem("id_user")) return;
    setProductBuy(carts[index]);
    //create receipt
    const data = {
      idreceipt: null,
      idcustomer: parseInt(localStorage.getItem("id_user")),
      idstaff: 3, // default id_staff = 3
    };
    // console.log(data);
    const headers = {
      Authorization: "Bearer my-token",
      "My-Custom-Header": "foobar",
    };
    axios
      .put("http://localhost:8080/api/v1/Receipt/insert", data, { headers })
      .then((response) => {
        setIdReceipt(response.data.data.idreceipt);
        console.log(id_receipt);
      });
    // buy
  }
  function conform() {
    const headers = {
      Authorization: "Bearer my-token",
      "My-Custom-Header": "foobar",
    };
    // const productBuy = pr;
    const data_buy = {
      iddetailreceipt: null,
      idreceipt: id_receipt,
      idproduct: productBuy.idproduct,
      amount: productBuy.amount,
      unitprice: productBuy.unitprice,
      totalprice: productBuy.totalprice,
    };
    axios
      .put("http://localhost:8080/api/v1/Detail/insertDetail", data_buy, {
        headers,
      })
      .then((response) => console.log(response.data.status));



      const arrayTemp = [...carts];
      const index = arrayTemp.indexOf(productBuy);
      arrayTemp.splice(index, 1);
      setCarts(arrayTemp);
      localStorage.removeItem('cart')
      localStorage.setItem('cart',JSON.stringify(arrayTemp));
      
    setShow(false);
  }
  return (
    <>
    <Navbar bg="dark" variant="dark">
        <Container>
          <Navbar.Brand href="#home">Shop</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link href="#home">Product</Nav.Link>
            <Nav.Link href="#features">Cart</Nav.Link>
            
          </Nav>
        </Container>
      </Navbar>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>#</th>
            <th>Name Product</th>
            <th>Amount</th>
            <th>Unit Price</th>
            <th>Total Price</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          {localStorage.getItem("cart") ? (
            <>
              {carts.map((cart, index) => (
                <tr key={index}>
                  <td>{index + 1}</td>
                  <td>{cart.idproduct}</td>
                  <td>{cart.amount}</td>
                  <td>{cart.unitprice} $</td>
                  <td>{cart.totalprice} $</td>
                  <td>
                    <Button variant="danger" onClick={() => cacelBuy(index)}>
                      Cancel
                    </Button>{" "}
                    <Button variant="success" onClick={() => buy(index)}>
                      Buy
                    </Button>
                  </td>
                </tr>
              ))}
            </>
          ) : (
            <td colSpan={5}><h1>You have not selected any products yet</h1></td>            
          )}
        </tbody>
      </Table>
      <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Confirm</Modal.Title>
        </Modal.Header>
        <Modal.Body>Do you want buy product?</Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Cacel
          </Button>
          <Button variant="primary" onClick={() => conform()}>
            Agree
          </Button>
        </Modal.Footer>
      </Modal>
    </>
  );
}
export default Cart;
