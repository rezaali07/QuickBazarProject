import "../../css/categoryList.css";

const CategoryList = () => {
    // Define categories directly
    const categories = [
        { id: 1, name: 'Category 1' },
        { id: 2, name: 'Category 2' },
        { id: 3, name: 'Category 3' },
        // Add more categories as needed
    ];

    return (
        <div className="category-list-container">
            <h2 style={{ color: 'black' }}>Categories</h2>
            <ul className="category-list">
                {categories.map(category => (
                    <li className="category-item" key={category.id}>
                        <a className="category-link" href={`/items/${category.id}`}>{category.name}</a>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default CategoryList;
