import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { getProductById } from "../data/products";
import { useCard } from "../conetext/CardContext";

export default function ProductDetails() {
  const { id } = useParams();
  const [product, setProduct] = useState(null);
  const navigate = useNavigate();
  const { addToCard, cardItems } = useCard();
  const productInCard = cardItems.find((item) => item.id === product.id);
  const productQuantityLabel = productInCard
    ? `(${productInCard.quantity})`
    : "";

  useEffect(() => {
    const foundProduct = getProductById(id);
    console.log(foundProduct);
    if (!foundProduct) {
      navigate("/");
      return;
    }
    setProduct(foundProduct);
  }, [id]);
  if (!product) {
    return <h1>Looadding ...</h1>;
  }

  return (
    <div className="page">
      <div className="container">
        <div className="product-detail">
          <div className="product-detail-image">
            <img src={product.image} alt={product.name} />
          </div>
          <div className="product-detail-content">
            <h1 className="product-detail-name">{product.name}</h1>
            <p className="product-detail-price">{product.price}</p>
            <p>{product.description}</p>
            <button className="btn btn-primary" onClick={()=>addToCard(product.id)}>Add to cart {productQuantityLabel}</button>
          </div>
        </div>
      </div>
    </div>
  );
}
