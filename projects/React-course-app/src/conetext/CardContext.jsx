import { createContext, useState, useContext } from "react";
import { useNavigate } from "react-router-dom";
import { getProductById } from "../data/products";
const CardContext = createContext(null);
export default function CardProvider({ children }) {
  const [cardItems, setCardItems] = useState([]);
  function addToCard(productId) {
    const existing = cardItems.find((item) => item.id == productId);
    if (existing) {
      const currentQuantity = existing.quantity;
      const updateCardItems = cardItems.map((item) =>
        item.id === productId
          ? { id: productId, quantity: currentQuantity + 1 }
          : item,
      );
      setCardItems(updateCardItems);
    } else {
      setCardItems([...cardItems, { id: productId, quantity: 1 }]);
    }
  }
  function getCardItemsWithProducts() {
    return cardItems
      .map((item) => ({
        ...item,
        product: getProductById(item.id),
      }))
      .filter((item) => item.product);
  }

  function removeFromCard(productId) {
    console.log("in removefrom card");
    setCardItems(cardItems.filter((item) => item.id != productId));
  }

  function updateQuantity(productId, quantity) {
    if (quantity <= 0) {
      console.log("in quantity<=0");
      removeFromCard(productId);
      return;
    }
    console.log("in update quantity");
    setCardItems(
      cardItems.map((item) =>
        item.id == productId ? { ...item, quantity } : item,
      ),
    );
  }
  function getCartTotal() {
    const total = cardItems.reduce((total, item) => {
      const product = getProductById(item.id);
      return total + (product ? product.price * item.quantity : 0);
    }, 0);
    return total;
  }
  function clearcard(){
    setCardItems([]);
  }
  return (
    <CardContext.Provider
      value={{
        cardItems,
        addToCard,
        getCardItemsWithProducts,
        getCartTotal,
        removeFromCard,
        updateQuantity,
        clearcard
      }}
    >
      {children}
    </CardContext.Provider>
  );
}

export function useCard() {
  const context = useContext(CardContext);
  return context;
}
