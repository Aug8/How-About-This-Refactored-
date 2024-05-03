import styled from 'styled-components';
import { snsTypes as sns } from '../../utils/constants/snsTypes';
import { useDispatch } from 'react-redux';
import { toggle, select } from '../../store/slice/profileEditSlice';

const SnsTypeSelect = () => {
  const dispatch = useDispatch();

  const OnClickSns = (key: string) => {
    dispatch(select(key));
    dispatch(toggle());
  };

  return (
    <SnsTypeSelectBox>
      <SnsTypes>
        {Object.keys(sns).map((key) => (
          <SnsType key={key} onClick={() => OnClickSns(key)}>
            <SnsIcon>{sns[key]}</SnsIcon>
            <SnsName>{key}</SnsName>
          </SnsType>
        ))}
      </SnsTypes>
    </SnsTypeSelectBox>
  );
};

const SnsTypeSelectBox = styled.div`
  position: absolute;
  left: -180px;
  width: 170px;
  max-height: 35vh;
  box-shadow: 0px 0px 10px 1px #dbdbdb;
  border-radius: 10px;
  background-color: white;
  padding: 20px;
  overflow: auto;
`;

const SnsTypes = styled.ul`
  display: flex;
  flex-direction: column;
`;

const SnsType = styled.li`
  display: flex;
  height: 35px;
  transition: background-color 0.3s ease;
  padding: 5px;
  margin: 3px 0;

  &:hover {
    background-color: #f2f4f7;
    border-radius: 5px;
  }
`;

const SnsIcon = styled.div`
  width: 100px;
  align-self: center;
`;

const SnsName = styled.div`
  width: 200px;
  align-self: center;
`;
export default SnsTypeSelect;
