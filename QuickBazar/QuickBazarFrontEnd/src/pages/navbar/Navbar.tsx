import React from "react";
import { FaRegUser, FaSearch } from "react-icons/fa";
import { IoIosAddCircle } from "react-icons/io";
import { SiQuicktime } from "react-icons/si";
import "../../css/Navbar.css";
import {Link} from "react-router-dom";


const Navbar: React.FC = () => {

    return (
        <nav className="main-nav">
            <div className="logo">

                <Link to="/HomePage">
                    <h2>
                        <span>Q</span>uick <span>B</span>azar
                    </h2>
                    <h1>
                        <SiQuicktime />
                    </h1>
                </Link>

            </div>
            <div className="search-bar">
                <ul>
                    <li>
                        <div className="search-wrapper">
                            <input type="search" placeholder="Search for anything" />
                            <span className={"search-icon"}><FaSearch /></span>
                        </div>
                    </li>
                    <li className={"post-button"}>
                        <Link to={"/postProduct"}>
                            <button>
                                <span> <IoIosAddCircle /> </span> Post for free
                            </button>
                        </Link>
                    </li>
                </ul>
            </div>
            <div className={"login-register"}>
                <ul>
                    <li>
                        <div className={"login-button"}>
                            <Link to="/Login">
                                <button><span><FaRegUser /></span> Login</button>
                            </Link>
                        </div>
                    </li>
                    <li>
                        <div className={"separate-line"}>
                            <h1>|</h1>
                        </div>
                    </li>
                    <li>
                        <div className={"registration-button"}>
                            <Link to="/RegistrationPage">
                                <button> SignUp</button>
                            </Link>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
    );
};

export default Navbar;
