import logo from "./logo.svg";
import "./App.css";
import HomePage from "./Pages/HomePage";
import {
  MDBContainer,
  MDBNavbar,
  MDBNavbarBrand, 
  MDBNavbarNav,
  MDBNavItem,
  MDBNavLink,
} from "mdb-react-ui-kit";
import AboutUs from "./Pages/AboutUs";
import PlanYourTrip from "./Pages/PlanYourTrip";
import DiscoverCity from "./Pages/DiscoverCity";
import TopAttractions from "./Pages/TopAttractions";
import LoginPage from "./Pages/LogInPage";
import RegisterPage from "./Pages/RegisterPage";
import ForgotPassword from "./Pages/ForgotPassword";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import {Form} from "react-bootstrap";

function App() {
  return (
    <div className="App">
        <BrowserRouter>
            <Routes>
                <Route path={"/"} element={<HomePage/>}/>
                <Route path={"/about"} element={<AboutUs/>}/>
                <Route path={"/discover/123"} element={<DiscoverCity/>}/>
                <Route path={"/login"} element={<LoginPage/>}/>
                <Route path={"/register"} element={<RegisterPage/>}/>
                <Route path={"/forgot"} element={<ForgotPassword/>}/>
                <Route path={"/plan"} element={<PlanYourTrip/>}/>
                <Route path={"/itineraries/31"} element={<TopAttractions/>}/>
            </Routes>
        </BrowserRouter>
       {/*<HomePage/>*/}
      {/* <AboutUs/> */}
      {/* <PlanYourTrip/>*/}
      {/* <DiscoverCity/>*/}
      {/*<TopAttractions/>*/}
      {/*<RegisterPage/>*/}
      {/*<LoginPage/>*/}
      {/*  <ForgotPassword/>*/}
    </div>
  );
}

export default App;
