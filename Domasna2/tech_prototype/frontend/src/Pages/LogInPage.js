import React from "react";
import {Col, Container, Image, Row, Button, Form, FormLabel, FormControl} from "react-bootstrap";
import NavbarCustom from "../Layout/Navbar";

const LogInPage = () => {
    return (<>
        <NavbarCustom color="#29b34"></NavbarCustom>

        <Container className={""} style={{marginTop:"10%"}}>
            <Row>
                <h1>Login</h1>
            </Row>
            <Row>
                <h6>Not registered yet ? <a href={"/register"}> Register here !</a></h6>
            </Row>
        </Container>

        <Container className={"w-25"} style={{paddingBottom:"10%"}}>
            <Form>
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

                    <h6><a href={"/"}>Forgot password?</a></h6>
                </Form.Group>


                <Button size={"lg"} type={"submit"} style={{backgroundColor:"#293b34"}} className={"px-5"}>login</Button>



            </Form>

        </Container>




    </>)

}

export default LogInPage;