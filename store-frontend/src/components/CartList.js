import CartItem from "./CartItem";
const CartList = ({ cartItems, handleAddItemToCart, handleRemoveItemFromCart  }) => {
  const Total = cartItems.reduce(
    (sum, i) => sum + i.amount * i.price,
    0
  );
  return (
    <aside>
      <h1>Store of buys</h1>
      {cartItems.length === 0 ? <h3>No there are products in the car...</h3> : null}
      <div>
        {cartItems.map((i) => (
          i.image
        ))}
      </div>
      <h2>Total: {Total.toFixed(2)}</h2>
    </aside>
  );
};
export default CartList;