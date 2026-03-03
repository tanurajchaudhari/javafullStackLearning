import { Link } from "react-router-dom";
import { useCard } from "../conetext/CardContext";
export default function ProductCard({ product }) {
  const {addToCard,cardItems}=useCard();
  const productInCard=cardItems.find((item)=>item.id===product.id);
  const productQuantityLabel=productInCard ?`(${productInCard.quantity})`:"";
  return (
    <div className="product-card">
      <img src={product.image} className="product-card-image" />
      <div className="product-card-content">
        <h3 className="product-card-name">{product.name}</h3>
        <p className="product-card-price">{product.price}</p>
        <div className="product-card-actions">
          <Link className="btn btn-secondary" to={`/products/${product.id}`} >View Details</Link>
          <button className="btn btn-primary" onClick={()=>addToCard(product.id)}>Add to cart
           {productQuantityLabel}
            
          </button>
         
        </div>
      </div>
    </div>
  );
}
