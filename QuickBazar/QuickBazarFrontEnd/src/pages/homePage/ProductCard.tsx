import React, { useState, useEffect } from 'react';
import axios from 'axios';
import "../../css/productCard.css";

interface Product {
    id: number;
    subCategoryId: number;
    categoryId: number;
    productName: string;
    productBrand: string;
    productCondition: string;
    price: string;
    address: string;
    productDiscription: string;
    // productImage?: string;
    // // Add more fields as needed
}

const ProductCard: React.FC<{ productId: number }> = ({ productId }) => {
    const [product, setProduct] = useState<Product | null>(null);

    useEffect(() => {
        const fetchProduct = async () => {
            try {
                const response = await axios.get(`http://localhost:8082/product/findById/${productId}`);
                setProduct(response.data);
            } catch (error) {
                console.error('Error fetching product:', error);
            }
        };

        fetchProduct();
    }, [productId]);

    if (!product) {
        return <div>Loading...</div>;
    }

    return (
        <div className="product-card">
            <h2>Name: {product.productName}</h2>
            <p>Brand: {product.productBrand}</p>
            <p>Condition: {product.productCondition}</p>
            <p>Discription: {product.productDiscription}</p>
            <p>Address: {product.address}</p>
            <p>Price: Rs.{product.price}</p>


            {/*{product.productImage && <img src={product.productImage} alt={product.productName} style={{ maxWidth: '100%', maxHeight: '200px' }} />}*/}
            {/*/!* Add more fields or customize the layout as needed *!/*/}
        </div>
    );
};

export default ProductCard;
