import styled from 'styled-components';
import Title from '../atom/Title';
import Select from '../atom/Select';
import { sortOptions } from '../../utils/constants/constants';

import { useDispatch } from 'react-redux';
import { setSort } from '../../store/slice/categorySlice';

const ProductListTitle = () => {
  const dispatch = useDispatch();

  const handleSortOption = (e: any) => {
    dispatch(setSort(e.target.value));
  };

  return (
    <StyledProductListTitle>
      <Title text='전체' />
      <Select
        options={sortOptions.map((option) => {
          return { value: option.value, name: option.name };
        })}
        onChange={handleSortOption}
      />
    </StyledProductListTitle>
  );
};

const StyledProductListTitle = styled.div`
  display: flex;
  justify-content: space-between;
`;

export default ProductListTitle;
