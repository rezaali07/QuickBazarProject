import React from "react";
import Navbar from "../navbar/Navbar.tsx";
import "../../css/HomePage.css"
import Carousel from "../../decoretor/Carousel.tsx";
import CategoryList from "./CategoryList.tsx";
import ItemList from "./ItemList.tsx";


const images = [
    'https://images.pexels.com/photos/5872364/pexels-photo-5872364.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1',
    'https://images.pexels.com/photos/5632381/pexels-photo-5632381.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1',
    'https://images.pexels.com/photos/4201333/pexels-photo-4201333.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1',
    'https://images.pexels.com/photos/4068322/pexels-photo-4068322.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1',
];
const HomePage: React.FC = () => {

    return(
        <>
            <div className={"navbar-div"}>
                <Navbar/>
            </div>

            <div className={"menu-page-div"}>

                <div className={"slide-images-div"}>
                    <Carousel images={images}/>
                </div>

                <div className={"item-contents"}>
                    <CategoryList/>
                    <ItemList/>

                </div>
                <div className={"info"}>
                    <h1>
                        Buy And Sell Any Things
                    </h1>

                </div>

            </div>
        </>

    );

};
export default HomePage;