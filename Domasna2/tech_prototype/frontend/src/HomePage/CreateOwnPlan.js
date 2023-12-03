import React from "react";
import { Col, Container, Image, Row, Button } from "react-bootstrap";
import "mdb-react-ui-kit/dist/css/mdb.min.css";
import "@fortawesome/fontawesome-free/css/all.min.css";
import "./homePage.css";
const CreateOwnPlan = () => {
  return (
    <>
      <Container
        fluid
        className="px-0 py-0 pe-3"
        style={{ backgroundColor: "#66a792", height: "25vh" }}
      >
        <Container style={{ paddingTop: "3%" }}>
          <Row>
            <Container className="mx-auto">
              <h1
                style={{ color: "white", fontSize: "5em", fontFamily: "Syne" }}
              >
                Create your own plan
              </h1>
            </Container>
          </Row>

          <Row>
            <Container className="mx-auto">
              <Button
                className="py-3"
                style={{
                  width: "15%",
                  backgroundColor: "#66a792",
                  color: "white",
                  border: "1px solid white",
                  fontFamily: "Syne",
                  fontSize: "1.2 em",
                }}
              >
                START
              </Button>
            </Container>
          </Row>
        </Container>
      </Container>
    </>
  );
};

export default CreateOwnPlan;
