import React from 'react';
import styled from 'styled-components';
import MediumText from '../atom/MediumText';
import Input from '../atom/Input';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEyeSlash } from '@fortawesome/free-solid-svg-icons';

import { useDispatch } from 'react-redux';
import { setId, setPassword } from '../../store/slice/loginSlice';

const LoginInput = () => {
  const dispatch = useDispatch();

  const updateId = (e: React.ChangeEvent<HTMLInputElement>) => {
    dispatch(setId(e.target.value));
  };

  const updatePassword = (e: React.ChangeEvent<HTMLInputElement>) => {
    dispatch(setPassword(e.target.value));
  };

  return (
    <StyledLoginInput>
      <MediumText text='아이디' />
      <Input width='340px' padding='12px 10px' onChange={updateId} />
      <MediumText text='비밀번호' />
      <PasswordWrapper>
        <Input
          width='340px'
          padding='12px 10px'
          type='password'
          onChange={updatePassword}
        />
        <StyledHideIcon icon={faEyeSlash} />
      </PasswordWrapper>
    </StyledLoginInput>
  );
};

export const StyledLoginInput = styled.div`
  text-align: left;
  margin: 10px 0 10px 0;
  & > * {
    margin-bottom: 10px;
  }
`;

export const PasswordWrapper = styled.div`
  position: relative;
`;

export const StyledHideIcon = styled(FontAwesomeIcon)`
  position: absolute;
  color: gray;
  width: 15px;
  right: 15px;
  top: 17px;
`;

export default LoginInput;
