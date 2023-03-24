import React, { useState } from "react";
import PropTypes from "prop-types";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";

Item.propTypes = {
  items: PropTypes.array,
  onAdd: PropTypes.func,
};
Item.defaultProps = {
  items: [],
  onAdd: null,
};
function Item(props) {
  const { items, onAdd } = props;
  const [number, setNumber] = useState(0);
  function handleAddToCart(item) {
    // localStorage.setItem("number_buy", number);
    if (onAdd) {
      onAdd(item, number);
    }
    setNumber(0);
  }
  return (
    <>
      {items.map((item) => (
        <div className="col" key={item.idproduct}>
          <Card style={{ width: "18rem" }}>
            <Card.Img variant="top" src={item.url} />
            <Card.Body>
              <Card.Title>{item.idproduct}</Card.Title>
              <Card.Text>{item.infor}</Card.Text>
              <Card.Text>{item.price}$</Card.Text>
              <Card.Text>sold: {item.sold}</Card.Text>
              {item.amount === "0" ? (
                <p>Out of stock</p>
              ) : (
                <input
                  type="number"
                  // id="quantity"
                  name="quantity"
                  min="1"
                  onChange={(e) => setNumber(e.target.value)}
                  max={item.amount}
                />
              )}

              <Card.Text></Card.Text>
              {item.amount === "0" ? (
                <>can't buy</>
              ) : (
                <>
                  <Button
                    variant="primary"
                    onClick={() => handleAddToCart(item)}
                  >
                    Add to cart
                  </Button>
                </>
              )}
            </Card.Body>
          </Card>
        </div>
      ))}
    </>
  );
}
export default Item;
