import React from "react";
import "../HomePage/homePage.css";
import Hero from "../HomePage/Hero";
import NavbarCustom from "../Layout/Navbar";
import { Button, Col, Container, FormControl, Row } from "react-bootstrap";
import PopularDestinations from "../HomePage/PopularDestinations";
import Footer from "../HomePage/Footer";

const PlanYourTrip = () => {
  return (
    <>
      <div className="parallax parallax-plantrip">
        <div className="z-proba">
          <NavbarCustom color=""></NavbarCustom>
          <Hero showStats="false" text={"PLAN<br/>YOUR TRIP"} />
        </div>
        <div className="overlay"></div>
      </div>

      <Container fluid className="py-5">
        <Container className="w-50 py-5">
        <Row>
          <Col className="col-9">
            <FormControl size="lg" type="text" name="city" placeholder="City" style={{fontSize: "1.2em", fontFamily: "Syne"}} />
          </Col>
          <Col className="col-3">
            <Button href="/discover/123" size="lg" style={{ backgroundColor: "gray", fontSize: "1.2em", fontFamily: "Syne", boxShadow: "rgba(0, 0, 0, 0.35) 0px 5px 15px"}}>Search</Button>
          </Col>
        </Row>
        </Container>
      </Container>

      <Container id={"destinations"} fluid className="px-5">
      <PopularDestinations/>
      </Container>

      <Footer/>
    </>
  );
};

export default PlanYourTrip;
