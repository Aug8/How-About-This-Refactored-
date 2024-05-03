import styled from 'styled-components';
import Select from '../atom/Select';
import { categories, searchOptions } from '../../utils/constants/constants';

const TopBarSelects = () => {
  return (
    <StyledTopBarSelects>
      <Select
        options={categories.map((category: string, index: number) => {
          return { value: String(index), name: category };
        })}
        width='10vw'
      />
      <Select
        options={searchOptions.map((option: string, index: number) => {
          return { value: String(index), name: option };
        })}
        width='10vw'
      />
    </StyledTopBarSelects>
  );
};

const StyledTopBarSelects = styled.div`
  display: flex;
  justify-content: space-between;
  margin-right: 6px;
`;

export default TopBarSelects;
