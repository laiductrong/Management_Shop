import React from "react";
import axios from "axios";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
let products = [];
class Home extends React.Component {
  constructor(props) {
    super(props);
    this.state = {};
    this.getAll();
  }
  getAll() {
    // GET request using axios with set headers
    var config = {
      headers: { "Access-Control-Allow-Origin": "*" },
    };
    axios
      .get("http://localhost:8080/api/v1/Product/getAll", config)
      .then((response) => {
        for (let index = 0; index < response.data.length; index++) {
          products.push(response.data[index]);
        }
      });
  }
  render() {
    return (
      <>
        <div className="container text-center">
          <div className="row row-cols-3">
            {/* {products.map((product) => {
              <p key={product.idproduct}>
                {product.id}
              </p>;
            })} */}

            <div className="col">
              <Card style={{ width: "18rem" }}>
                <Card.Img
                  variant="top"
                  src="https://cdn2.cellphones.com.vn/358x/media/catalog/product/t/_/t_m_12_1.png"
                />
                <Card.Body>
                  <Card.Title>Card Title</Card.Title>
                  <Card.Text>
                    Some quick example text to build on the card title and make
                    up the bulk of the card's content.
                  </Card.Text>
                  <Button variant="primary">Go somewhere</Button>
                </Card.Body>
              </Card>
            </div>
            <div className="col">
              <Card style={{ width: "18rem" }}>
                <Card.Img
                  variant="top"
                  src="https://cdn2.cellphones.com.vn/358x/media/catalog/product/t/_/t_m_12_1.png"
                />
                <Card.Body>
                  <Card.Title>Card Title</Card.Title>
                  <Card.Text>
                    Some quick example text to build on the card title and make
                    up the bulk of the card's content.
                  </Card.Text>
                  <Button variant="primary">Go somewhere</Button>
                </Card.Body>
              </Card>
            </div>
            <div className="col">
              <Card style={{ width: "18rem" }}>
                <Card.Img
                  variant="top"
                  src="https://cdn2.cellphones.com.vn/358x/media/catalog/product/t/_/t_m_12_1.png"
                />
                <Card.Body>
                  <Card.Title>Card Title</Card.Title>
                  <Card.Text>
                    Some quick example text to build on the card title and make
                    up the bulk of the card's content.
                  </Card.Text>
                  <Button variant="primary">Go somewhere</Button>
                </Card.Body>
              </Card>
            </div>
            <div className="col">
              <Card style={{ width: "18rem" }}>
                <Card.Img
                  variant="top"
                  src="https://cdn2.cellphones.com.vn/358x/media/catalog/product/t/_/t_m_12_1.png"
                />
                <Card.Body>
                  <Card.Title>Card Title</Card.Title>
                  <Card.Text>
                    Some quick example text to build on the card title and make
                    up the bulk of the card's content.
                  </Card.Text>
                  <Button variant="primary">Go somewhere</Button>
                </Card.Body>
              </Card>
            </div>
          </div>
        </div>
      </>
    );
  }
}
export default Home;
