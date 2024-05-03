import styled from 'styled-components';
import { useEffect, useState } from 'react';

import Logo from '../atom/Logo';
import NavLogin from '../molecule/NavLogin';
import NavProfile from '../molecule/NavProfile';
import CategoryList from '../molecule/CategoryList';

import { checkLogin } from '../../apis/api/userApi';

const LeftNavBar = () => {
  const [loginStatus, setLoginStatus] = useState<boolean>(false);

  useEffect(() => {
    const checkLoginStatus = async () => {
      const data = await checkLogin();
      setLoginStatus(data.success);
    };
    checkLoginStatus();
  }, []);

  return (
    <StyledLeftNavBar>
      <Logo />
      {loginStatus ? <NavProfile /> : <NavLogin />}
      <CategoryList />
    </StyledLeftNavBar>
  );
};

export const StyledLeftNavBar = styled.div`
  position: fixed;
  top: 0;
  z-index: 1;
  background-color: white;
  width: 270px;
  height: 100vh;
  padding: 50px 0;
  box-shadow: 1px 0px 10px lightgray;
  & > * {
    margin-bottom: 40px;
  }

  @media (max-width: 768px) {
    display: none;
  }
`;

export default LeftNavBar;
