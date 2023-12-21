import React from "react";
import {Col, Container, Image, Row, Button, Form, FormLabel, FormControl} from "react-bootstrap";
import NavbarCustom from "../Layout/Navbar";

const RegisterPage = (props) => {
    return(<>
        <NavbarCustom color="#29b34"></NavbarCustom>

        <Container className={"my-5"}>
            <Row>
                <h1>Create new Account</h1>
            </Row>
            <Row>
                <h6>Already registered? <a href={"/login"}> Login</a></h6>
            </Row>
        </Container>

        <Container className={"w-25"} style={{paddingBottom:"10%"}}>
            <Form>
                <Form.Group  className={"my-3 text-start"}>
                    <FormLabel className={"text-start"}>
                        NAME
                    </FormLabel>

                    <FormControl type={"text"} size={"lg"} placeholder={"Mila Krsteva"}>

                    </FormControl>
                </Form.Group>


                <Form.Group className={"my-3 text-start"}>
                    <FormLabel className={"text-start"}>
                        EMAIL
                    </FormLabel>

                    <FormControl type={"email"} size={"lg"} placeholder={"hello@trip2.mk"}>

                    </FormControl>
                </Form.Group>

                <Form.Group className={"my-3 text-start"}>
                    <FormLabel className={"text-start"}>
                        PASSWORD
                    </FormLabel>

                    <FormControl type={"password"} size={"lg"} placeholder={"********"}>

                    </FormControl>
                </Form.Group>

                <Form.Group className={"my-3 text-start"}>
                    <FormLabel className={"text-end"}>
                        DATE OF BIRTH
                    </FormLabel>

                    <FormControl type={"date"} size={"lg"} placeholder={"Select Date"}>

                    </FormControl>
                </Form.Group>

                <Button size={"lg"} type={"submit"} style={{backgroundColor:"#293b34"}} className={"px-5"}>sign up</Button>

            </Form>

        </Container>





    </>)
}

export default RegisterPage;
