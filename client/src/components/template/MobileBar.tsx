import styled from 'styled-components';
import { Link } from 'react-router-dom';
import { useEffect, useState } from 'react';
import { BsList } from 'react-icons/bs';

import Logo from '../atom/Logo';
import NavProfile from '../molecule/NavProfile';
import Button from '../atom/Button';

import { checkLogin } from '../../apis/api/userApi';

const MobileBar = () => {
  const [loginStatus, setLoginStatus] = useState<boolean>(false);

  useEffect(() => {
    const checkLoginStatus = async () => {
      const data = await checkLogin();
      setLoginStatus(data.success);
    };
    checkLoginStatus();
  }, []);

  return (
    <StyledMobileBar>
      <Left>
        <BsList size={30} />
        <Logo width='150px' />
      </Left>
      {loginStatus ? (
        <NavProfile />
      ) : (
        <Link to='/login'>
          <Button
            id='LoginBtn'
            text='로그인'
            color='black'
            width='80px'
            height='40px'
          />
        </Link>
      )}
    </StyledMobileBar>
  );
};

export const StyledMobileBar = styled.div`
  position: static;
  display: flex;
  align-items: center;
  justify-content: space-between;
  background-color: white;
  box-shadow: 1px 0px 10px lightgray;
  width: 100vw;
  height: 80px;
  padding: 0 5%;
  margin-bottom: 30px;

  @media (min-width: 769px) {
    display: none;
  }
`;

export const Left = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 200px;
`;

export default MobileBar;
