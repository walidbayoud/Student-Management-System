import React, { useRef } from "react";
import { Link } from "react-router-dom";

const NavBar = () => {
    const collapseRef = useRef(null);

    const handleLinkClick = () => {
        // Remove the "show" class from the collapse div to close it
        if (collapseRef.current && collapseRef.current.classList.contains("show")) {
            collapseRef.current.classList.remove("show");
        }
    };

    return (
        <nav className="navbar navbar-expand-lg navbar-light navbar-dark bg-dark mb-5">
            <Link className="navbar-brand" to="/" onClick={handleLinkClick}>
                SBR Demo
            </Link>
            <button
                className="navbar-toggler"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent"
                aria-expanded="false"
                aria-label="Toggle navigation"
            >
                <span className="navbar-toggler-icon"></span>
            </button>

            <div className="collapse navbar-collapse" id="navbarSupportedContent" ref={collapseRef}>
                <ul className="navbar-nav mr-auto">
                    <li className="nav-item active">
                        <Link className="nav-link" to="/view-students" onClick={handleLinkClick}>
                            View all students
                        </Link>
                    </li>
                    <li className="nav-item">
                        <Link className="nav-link" to="/add-student" onClick={handleLinkClick}>
                            Add new student
                        </Link>
                    </li>
                </ul>
            </div>
        </nav>
    );
};

export default NavBar;
