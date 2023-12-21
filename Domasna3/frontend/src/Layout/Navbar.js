import React from "react";
import { Navbar, Nav, Container } from "react-bootstrap";
import { CgProfile } from "react-icons/cg";

const NavbarCustom = (props) => {
  return (
    <>
      <Navbar expand="lg" className="bg-body-tertiary" style={props.color == "" ? {} : {backgroundColor: "#293b34"}}>
        <Container>
          <Navbar.Brand
            className="blabla"
            style={{
              color: "white",
              fontWeight: 400,
              fontFamily: "Archivo Black !important",
              fontSize: "2.1rem",
              lineHeight: "2rem",
              textDecoration: "bold",
            }}
            href="/"
          >
            TRIP
            <br />
            2MK.
          </Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav bg="light" className="mx-auto">
              <Nav.Link
                className="mx-3 nav-letters"
                style={{ color: "white" }}
                href="/"
              >
                HOME
              </Nav.Link>
              <Nav.Link
                className="mx-3 nav-letters"
                style={{ color: "white" }}
                href="/plan"
              >
                PLAN YOUR TRIP
              </Nav.Link>
              <Nav.Link
                className="mx-3 nav-letters"
                style={{ color: "white" }}
                href="/about"
              >
                ABOUT US
              </Nav.Link>
            </Nav>
            <Navbar.Brand
              style={{
                color: "white",
                fontWeight: 800,
                fontSize: "2.1rem",
              }}
              href="/"
            >
              <CgProfile onClick={() => window.location = "/login"}/>
            </Navbar.Brand>
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </>
  );
};

export default NavbarCustom;
