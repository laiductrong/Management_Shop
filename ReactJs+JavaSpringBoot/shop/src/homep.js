import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import React, { useState, useEffect } from "react";
import Button from "react-bootstrap/Button";
import axios from "axios";
import Item from "./item";
function Homep() {
  const [product, setProduct] = useState([]);
  const [key_find, setKeyFind] = useState("");

  useEffect(() => {
    document.title = `Product`;
  });

  function getProduct() {
    document.title = `Product`;
    var config = {
      headers: { "Access-Control-Allow-Origin": "*" },
    };
    axios
      .get("http://localhost:8080/api/v1/Product/getAll", config)
      .then((response) => {
        setProduct(response.data);
      });
  }
  function sortProduct() {
    const increase = [...product].sort((a, b) => b.sold - a.sold);
    setProduct(increase);
  }
  function findProduct() {
    var config = {
      headers: { "Access-Control-Allow-Origin": "*" },
    };
    axios
      .get(
        "http://localhost:8080/api/v1/Product/getByIDProduct/" + key_find,
        config
      )
      .then((response) => {
        if (response.data.status !== "fail") setProduct([response.data.data]);
        else setProduct([]);
      });
  }
  //add to cart
  function addToCart(item, number) {
    const buy = {
      idreceipt: 1,
      idproduct: item.idproduct,
      amount: number,
      unitprice: item.price,
      totalprice: number * item.price,
    };
    if (!localStorage.getItem("cart")) {
      const cart = [buy];
      localStorage.setItem("cart", JSON.stringify(cart));
      console.log(cart);
    } else {
      const c = localStorage.getItem("cart");
      const cart = JSON.parse(c);
      cart.push(buy);
      console.log(cart);
      localStorage.removeItem("cart");
      localStorage.setItem("cart", JSON.stringify(cart));
    }
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
      <div>
        <Button variant="primary" onClick={getProduct}>
          All Product
        </Button>{" "}
        <Button variant="primary" onClick={sortProduct}>
          Sort
        </Button>{" "}
        <input
          type="text"
          value={key_find}
          onChange={(event) => setKeyFind(event.target.value)}
        />
        <Button variant="info" onClick={findProduct}>
          Find
        </Button>
        <div className="container text-center">
          <div className="row row-cols-4">
            {/* {product.length === 0 ? "" : (<p>{product[0].idproduct}</p>)} */}
            <Item items={product} onAdd={addToCart}></Item>{" "}
          </div>
        </div>
      </div>
    </>
  );
}
export default Homep;
