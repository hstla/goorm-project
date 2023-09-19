import { useDispatch } from 'react-redux';
import styled from 'styled-components';
import tw from 'twin.macro';
import { fetchCategoryProducts } from '../reducers/productSlice';

const ProductButtons = () => {
  const dispatch = useDispatch();

  const handleCategoryClick = (category) => {
    dispatch(fetchCategoryProducts(category));
  }

  return (
    <>
      <ProductBtn onClick={() => handleCategoryClick()} > 모두</ProductBtn >
      <ProductBtn onClick={() => handleCategoryClick('fetchElectronics')}> 전자기기</ProductBtn >
      <ProductBtn onClick={() => handleCategoryClick('fetchJewelery')}>주얼리</ProductBtn>
      <ProductBtn onClick={() => handleCategoryClick('fetchMen')}>남성의류</ProductBtn>
      <ProductBtn onClick={() => handleCategoryClick('fetchWomen')}>여성의류</ProductBtn>
    </>
  );
}


const ProductBtn = styled.button`
  ${tw`mr-5 px-20 py-5  border border-gray-500  rounded-md font-bold text-lg duration-300`}
  &:hover {
    ${tw`bg-gray-500  text-white`}
  }
`;


export default ProductButtons; 