import React from "react";
import { Col, Container, Row, Image } from "react-bootstrap";
import "./Circle.css"
const Circle = (props) =>{

    const classes = (props.hovered ? "circle circle-hovered" : "circle")
    return (
        <>
        <div onMouseEnter={props.onHover} onMouseLeave={props.onLeave} className={classes} style={{margin: "0 0.2%"}}>
        </div>
        </>
    )
}
export default Circle