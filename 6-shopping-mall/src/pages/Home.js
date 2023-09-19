import styled from 'styled-components';
import Product from '../components/Product';
import ProductButtons from '../components/ProductButtons';
import { useDispatch } from 'react-redux';
import { useEffect } from 'react';
import { fetchCategoryProducts } from '../reducers/productSlice';
import { useSelector } from 'react-redux';

const Home = () => {
  const dispatch = useDispatch();
  const products = useSelector((state) => state.products.items);

  useEffect(() => {
    dispatch(fetchCategoryProducts());
  }, [dispatch]);


  useEffect(() => {
    dispatch(fetchCategoryProducts());
  }, [dispatch]);

  return (
    <div className='flex flex-col justify-center items-center'>
      <div><h1 className=' font-medium text-4xl mt-5'>Products</h1></div>
      <Products className='flex  items-center my-10 justify-center '>
        <ProductButtons />
      </Products>

      <ProductContainer>
        <div className='w-full pl-32 text-gray-500 font-bold'>showing: <span>{products.length}</span> items</div>
        {products.map((product) => (
          <Product key={product.id} product={product} />
        ))}
      </ProductContainer>
    </div>
  );
}

const ProductContainer = styled.div`
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  max-width: 80%; 
`;


const Products = styled.div(
  {
    className: "flex  items-center my-10 justify-center ",
  }
)

export default Home;