import React, { useState } from "react";
import { Col, Container, Row, Image, FormControl, Button } from "react-bootstrap";
import Circle from "./Circle";

const Review = () => {
  const [hoverArr, setHoverArr] = useState([false, false, false, false, false]);

  const unSelectAll = () => {
    setHoverArr([false, false, false, false, false]);
  };

  const handleHover = (count) => {
    const arr = Array(5).fill(false);
    for (let i = 0; i <= count; i++) {
      arr[i] = true;
    }
    return arr;
  };

  return (
    <>
      <Container className={""} style={{paddingTop: "5%", paddingBottom: "5%"}}>
        <Row className="mb-3">
          <Col>
            <h1 style={{fontSize: "3em", fontFamily: "Syne", fontWeight: "normal"}}>Write a review, make someone's trip</h1>
          </Col>
        </Row>
        <Row>
          <Row>
            <Col>
              <h5 className="text-start mb-3" style={{fontSize: "1.3em", fontWeight: "bold", fontFamily: "Syne"}}>How would you rate your experience?</h5>
            </Col>
          </Row>
          <Row className="mb-3 ps-4">
            {Array.of(0, 1, 2, 3, 4).map((x) => (
              <Circle
                key={x}
                onHover={(e) => setHoverArr(handleHover(x))}
                onLeave={unSelectAll}
                hovered={hoverArr[x]}
              />
            ))}
          </Row>
        </Row>
        <Row>
          <label>
            <FormControl
              as="textarea"
              name="postContent"
              placeholder="The views were amazing. We took so many photos..."
              style={{ height: '200px' }}
            />
          </label>
        </Row>
        <Row>
            <Col className="d-flex my-3">
                <Button style={{backgroundColor: "green", fontSize: "1em", fontFamily: "Syne"}}>Submit</Button>
            </Col>
        </Row>
      </Container>
    </>
  );
};
export default Review;
