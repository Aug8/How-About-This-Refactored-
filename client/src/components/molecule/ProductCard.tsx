import styled from 'styled-components';
import CardImg from '../atom/CardImg';
import HeartIcon from '../atom/HeartIcon';
import CardBottom from '../atom/CardBottom';

interface ProductCardProps {
  name: string;
  imgSrc: string;
}

const ProductCard = ({ name, imgSrc }: ProductCardProps) => {
  return (
    <StyledProductCard>
      <CardImg src={imgSrc} width='100%' height='270px' />
      <HeartIcon />
      <CardBottom text={name} />
    </StyledProductCard>
  );
};

const StyledProductCard = styled.div`
  position: relative;
  margin: 12px 12px;
  display: flex;
  flex-direction: column;
  border: 2px solid var(--light-grey-color);
  border-radius: 5px;
  cursor: pointer;
  overflow: hidden;
  width: 250px;
`;

export default ProductCard;
