import styled from 'styled-components';
import tw from 'twin.macro';
import { useNavigate } from 'react-router-dom';


const Product = ({ product }) => {
  const navigate = useNavigate();

  const handleProductClick = () => {
    navigate.push(`/productDetail/${product.id}`);
  };

  const truncatedTitle = product.title.length > 15
    ? product.title.substring(0, 15) + '...'
    : product.title;

  return (
    <StyledProduct onClick={handleProductClick}>
      <img src={product.image} alt={product.title} className=' w-48 h-48 mb-5' />
      <h2 className='text-x1 mt-2 font-bold text-lg'>{truncatedTitle}</h2>
      <div className='flex mt-10 items-center'>
        <button className='border px-9 py-3 border-gray-500 text-gray-500 rounded mb-3'>장바구니 담기</button>
        <p className='ml-10'>${product.price}</p>
      </div>
    </StyledProduct>
  );
}

const StyledProduct = styled.button`
${tw` w-1/5 p-4 border my-3 mx-2 flex flex-col items-center justify-center`}
`;

export default Product;
