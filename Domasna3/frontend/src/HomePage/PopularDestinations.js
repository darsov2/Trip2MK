import React from "react";
import { Col, Container, Image, Row } from "react-bootstrap";
import Information from "./information";
import PopularCity from "./PopularCity";

const PopularDestinations = () => {
  return (
    <>
      <Container
        fluid
        className="p-5 my-5"
        style={{ backgroundColor: "#f7f7f7" }}
      >
        <Row className="mb-3">
          <h1 className="mb-3" style={{ textAlign: "left", fontFamily: "Syne" }}>
            Popular destinations
          </h1>
          <hr
            style={{
              maxWidth: "7%",
              border: "3px solid #fdc40a",
              opacity: "1",
            }}
          />
        </Row>

        <Row className="mb-3">
          <Col>
            <PopularCity text="SKOPJE" img="https://content.r9cdn.net/rimg/dimg/98/9a/27fe7b67-city-18146-165110bb4da.jpg?width=1366&height=768&xhint=1084&yhint=1010&crop=true" />
          </Col>
          <Col>
            <PopularCity text="OHRID" img="https://ak-d.tripcdn.com/images/100s1f000001gx545ED87.jpg?proc=source%2Ftrip" />
          </Col>
          <Col>
            <PopularCity text="MAVROVO" img="https://macedonia-timeless.com/wp-content/uploads/2018/08/mavrovo-turizam.jpg" />
          </Col>
        </Row>

        <Row>
          <Col>
            <PopularCity text="SKOPJE" img="https://content.r9cdn.net/rimg/dimg/98/9a/27fe7b67-city-18146-165110bb4da.jpg?width=1366&height=768&xhint=1084&yhint=1010&crop=true" />
          </Col>
          <Col>
            <PopularCity text="OHRID" img="https://ak-d.tripcdn.com/images/100s1f000001gx545ED87.jpg?proc=source%2Ftrip" />
          </Col>
          <Col>
            <PopularCity text="MAVROVO" img="https://macedonia-timeless.com/wp-content/uploads/2018/08/mavrovo-turizam.jpg" />
          </Col>
        </Row>
      </Container>
    </>
  );
};

export default PopularDestinations;
