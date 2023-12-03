import React from "react";
import "../HomePage/homePage.css";
import NavbarCustom from "../Layout/Navbar";
import Hero from "../HomePage/Hero";
import { Button, Col, Container, FormSelect, Row } from "react-bootstrap";
import StrippedContainter from "../Layout/StrippedContainer";
import PopularDestination from "../HomePage/PopularDestination";
import Itinerary from "../HomePage/Itinerary";
import Footer from "../HomePage/Footer";
import PlanYourTrip from "./PlanYourTrip";
import CreateOwnPlan from "../HomePage/CreateOwnPlan";

const DiscoverCity = () => {
  return (
    <>
      <div className="parallax parallax-discover">
        <div className="z-proba">
          <NavbarCustom color={""}></NavbarCustom>
          <Hero showStats="false" text={"DISCOVER<br/>OHRID"} />
        </div>
        <div className="overlay"></div>
      </div>

      <Container fluid className="py-5">
        <Container className="w-50 py-5">
          <Row className="mb-3">
            <h1>Create Your Ohrid Guide</h1>
          </Row>
          <Row>
            <Col className="col-10">
              <FormSelect
                size="lg"
                name="city"
                placeholder="City"
                style={{ fontSize: "1.2em", fontFamily: "Syne" }}
              >
                <option>Choose your plan..</option>
                <option value="1">Ohrid in One Day</option>
                <option value="2">Ohrid in Two Days</option>
                <option value="3">Ohrid in Three Days</option>
                <option value="3">Ohrid in Four Days</option>
              </FormSelect>
            </Col>
            <Col className="col-2">
              <Button
                size="lg"
                className="px-5"
                style={{
                  backgroundColor: "gray",
                  fontSize: "1.2em",
                  fontFamily: "Syne",
                  boxShadow: "rgba(0, 0, 0, 0.35) 0px 5px 15px",
                }}
              >
                GO
              </Button>
            </Col>
          </Row>
        </Container>
      </Container>

      <StrippedContainter vh="56.8vh">
        <Container>
          <Row className="py-5">
            <h1 style={{ fontSize: "3.2em" }}>About The City</h1>
          </Row>
          <Row>
            <p style={{ fontSize: "1.6em", fontFamily: "Syne" }}>
              Ohrid is the main culturally historical city of the Republic of
              Macedonia, a city with many contents and beauties, which if you
              try to look for them at least a little, you will see that they are
              endless. Tourists and visitors from different cities from
              Macedonia, but also from different countries of the world come
              here in larger or smaller numbers and everyone falls in love with
              it at first sight. No one would remain indifferent, walking on the
              cobblestones on which several millennia of history are written, or
              enjoying the caress of the bright glare of the sun from the waters
              of Lake Ohrid. In Ohrid you can find too many cultural and
              historical monuments, but apart from them, there are 365
              churches-monasteries in the city, known to the people as "one
              church or monastery for every day of the year". Because of this,
              the city is known as the Balkan and European Jerusalem. Ohrid is
              also known as the "city of light" which is a literal translation
              of its old name, Lychnid.
            </p>
          </Row>
        </Container>
      </StrippedContainter>

      <div
        style={{
          borderTop: "2px solid #91865c",
          borderBottom: "2px solid #91865c",
        }}
      >
        <Container className="my-4">
          <Row className="mb-3">
            <h1
              style={{
                // color: "#91865c",
                fontSize: "3.5em",
                fontFamily: "Syne",
              }}
            >
              Top Attractions
            </h1>
          </Row>
          <Row className="gx-5 mb-5">
            <Col>
              <PopularDestination
                img="https://mytravelleader.com/wp-content/uploads/2023/10/Discovering-Lake-Ohrid-a-budget-friendly-gem-in-North-Macedonia.jpg"
                title="Bay of Bones"
              />
            </Col>
            <Col>
              <PopularDestination
                img="https://static.wixstatic.com/media/513e48_10f043f7012e4880a4fbc5f7f97509c3~mv2_d_6000_4000_s_4_2.jpg/v1/fill/w_1600,h_1066,al_c,q_90/file.jpg"
                title="Stone Bridge"
              />
            </Col>
            <Col>
              <PopularDestination
                img="https://i0.wp.com/2.bp.blogspot.com/-r4voLH4fqsw/WjTIWj1_1DI/AAAAAAAABlE/cj1c2vZ4bwEvl-jO1CqyhuMd8eRxolaSwCKgBGAs/s1600/heraklea-bitola-8162.jpg?ssl=1"
                title="Heraclea Lyncestis"
              />
            </Col>
          </Row>
          <Row className="gx-5 mb-5">
            <Col>
              <PopularDestination
                img="https://mytravelleader.com/wp-content/uploads/2023/10/Discovering-Lake-Ohrid-a-budget-friendly-gem-in-North-Macedonia.jpg"
                title="Bay of Bones"
              />
            </Col>
            <Col>
              <PopularDestination
                img="https://static.wixstatic.com/media/513e48_10f043f7012e4880a4fbc5f7f97509c3~mv2_d_6000_4000_s_4_2.jpg/v1/fill/w_1600,h_1066,al_c,q_90/file.jpg"
                title="Stone Bridge"
              />
            </Col>
            <Col>
              <PopularDestination
                img="https://i0.wp.com/2.bp.blogspot.com/-r4voLH4fqsw/WjTIWj1_1DI/AAAAAAAABlE/cj1c2vZ4bwEvl-jO1CqyhuMd8eRxolaSwCKgBGAs/s1600/heraklea-bitola-8162.jpg?ssl=1"
                title="Heraclea Lyncestis"
              />
            </Col>
          </Row>
        </Container>
      </div>

      <Container fluid className="p-5"
        style={{ backgroundColor: "#f7f7f7" }}> 
        <Container>
        <Row className="mt-3">
          <h1
            style={{
              // color: "#91865c",
              fontSize: "3.5em",
              fontFamily: "Syne",
            }}
          >
            Popular itineraries
          </h1>
        </Row>
        <Row className="my-5">
          <Itinerary
            title="Ohrid in 2 Days - Top Attractions"
            description="Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum"
            img="https://ak-d.tripcdn.com/images/100s1f000001gx545ED87_D_1180_558.jpg"
          />
        </Row>
        <Row className="my-5">
          <Itinerary
            title="Ohrid in 2 Days - Top Attractions"
            description="Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum"
            img="https://ak-d.tripcdn.com/images/100s1f000001gx545ED87_D_1180_558.jpg"
          />
        </Row>

        <Row className="my-5">
          <Itinerary
            title="Ohrid in 2 Days - Top Attractions"
            description="Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum"
            img="https://ak-d.tripcdn.com/images/100s1f000001gx545ED87_D_1180_558.jpg"
          />
        </Row>
        </Container>
      </Container>

      <Container fluid className="py-5">
            <Container>
                <CreateOwnPlan/>
            </Container>
            <Container className="my-5">
                <Button className="p-3 w-25" style={{backgroundColor: "white", border: "2px solid gray", color: "gray", fontSize: "1.2em", boxShadow: "rgba(50, 50, 93, 0.25) 0px 30px 60px -12px, rgba(0, 0, 0, 0.3) 0px 18px 36px -18px;"}}>VIEW OTHER DESTINATIONS</Button>
            </Container>
      </Container>

      <Footer/>
    </>
  );
};

export default DiscoverCity;
