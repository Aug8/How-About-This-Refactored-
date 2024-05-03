import { useEffect, useState } from 'react';
import styled from 'styled-components';

import { useSelector, useDispatch } from 'react-redux';
import { RootState } from '../../store/store';
import { select } from '../../store/slice/categorySlice';
import { getAllCateName } from '../../apis/api/categoryApi';

interface CategoryProps {
  cateId: number;
  cateName: string;
}

const CategoryList = () => {
  const { selectedId } = useSelector((state: RootState) => state.category);
  const dispatch = useDispatch();

  const [categories, setCategories] = useState<CategoryProps[]>([]);

  useEffect(() => {
    const getCategories = async () => {
      const data = await getAllCateName();
      setCategories(data);
    };

    getCategories();
  }, []);

  const onClickCategory = (cateId: number) => {
    dispatch(select(cateId));
  };

  return (
    <StyledCategoryList>
      {categories.map((category) => {
        return (
          <StyledCategoryItem
            onClick={() => onClickCategory(category.cateId)}
            isSelected={category.cateId === selectedId}
          >
            {category.cateName}
          </StyledCategoryItem>
        );
      })}
    </StyledCategoryList>
  );
};

export const StyledCategoryList = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  font-size: 18px;

  & > * {
    margin-bottom: 25px;
  }
`;

interface CategoryItemProps {
  isSelected: boolean;
}

const StyledCategoryItem = styled.li<CategoryItemProps>`
  font-weight: ${(props) => (props.isSelected ? 'bold' : 'normal')};
  cursor: pointer;
`;

export default CategoryList;
