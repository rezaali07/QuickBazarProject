import "../../css/itemList.css";

const ItemList = () => {
    // Define categories directly
    const categories = [
        { id: 1, name: 'item 1' },
        { id: 2, name: 'item 2' },
        { id: 3, name: 'item 3' },
        // Add more categories as needed
    ];

    return (
        <div className="category-list-container">
            <h2 style={{ color: 'black' }}>Items</h2>

            <ul className="item-list">
                {categories.map(item => (
                    <li className="item" key={item.id}>
                        <a className="item-link" href={`/items/${item.id}`}>{item.name}</a>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default ItemList;