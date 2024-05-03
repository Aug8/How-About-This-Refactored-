import styled from 'styled-components';
import ProductCard from '../molecule/ProductCard';

interface ProductListProps {
  children: { name: string; imgSrc: string }[];
}

const ProductList = ({ children }: ProductListProps) => {
  return (
    <StyledProductList>
      {children.map((product) => {
        return <ProductCard name={product.name} imgSrc={product.imgSrc} />;
      })}
    </StyledProductList>
  );
};

const StyledProductList = styled.div`
  display: grid;
  grid-template-columns: repeat(auto-fit, 280px);
  justify-items: center;
  justify-content: center;
  padding: initial;
  padding-top: 35px;
`;

export default ProductList;
