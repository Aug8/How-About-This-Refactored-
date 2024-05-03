import styled from 'styled-components';
import { FaCheck, FaXmark } from 'react-icons/fa6';
import { useSelector, useDispatch } from 'react-redux';
import { RootState } from '../../store/store';
import { toggle, select } from '../../store/slice/profileEditSlice';
import SnsTypeSelect from '../molecule/SnsTypeSelect';
import { snsTypes as sns } from '../../utils/constants/snsTypes';

const SnsEdit = () => {
  const dispatch = useDispatch();
  const { isBoxVisible, selectedSnsType } = useSelector(
    (state: RootState) => state.profileEdit,
  );

  const toggleSelectBox = () => {
    dispatch(toggle());
  };

  const cancelSnsSelection = () => {
    dispatch(select(''));
  };

  return (
    <StyledSnsEdit>
      <AddButton onClick={toggleSelectBox}>+</AddButton>
      {isBoxVisible && <SnsTypeSelect />}
      <SnsWrapper>
        {selectedSnsType === '' && <AddLink>SNS 링크를 추가하세요!</AddLink>}
        {selectedSnsType && (
          <AddLink>
            {sns[selectedSnsType]}
            <Link placeholder='링크를 입력하세요.'></Link>
            <FaCheck />
            <FaXmark onClick={cancelSnsSelection} />
          </AddLink>
        )}
        <SnsList>
          {sns['kakaotalk']}
          {sns['facebook']}
        </SnsList>
      </SnsWrapper>
    </StyledSnsEdit>
  );
};

const StyledSnsEdit = styled.div`
  display: flex;
  margin-right: 10px;
  align-items: center;
  text-align: left;
  position: relative;
`;

const AddButton = styled.button`
  width: 30px;
  height: 30px;
  border-radius: 30px;
  font-size: 21px;
  margin: 5px 0;
  background-color: white;
  transition: background-color 0.3s ease;

  &:hover {
    background-color: black;
    color: white;
    border-radius: 30px;
  }
`;

const SnsWrapper = styled.div`
  display: flex;
  align-items: center;
  width: 100%;
`;

const AddLink = styled.div`
  margin-left: 10px;
  width: 100%;
  display: flex;
  align-items: center;
  & > *:not(:last-child) {
    margin-right: 10px;
  }
`;

const Link = styled.input`
  resize: none;
  border: none;
  border-bottom: 1px solid black;
  font-family: var(--noto-font);
  font-size: 15px;
  width: 50%;
`;

const SnsList = styled.div`
  display: flex;
  align-items: center;
`;

export default SnsEdit;
