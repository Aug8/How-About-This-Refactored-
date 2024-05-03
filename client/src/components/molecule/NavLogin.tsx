import { Link } from 'react-router-dom';
import Button from '../atom/Button';
import styled from 'styled-components';

const NavLogin = () => {
  return (
    <StyledNavLogin>
      <Link to='/login'>
        <Button
          id='LoginBtn'
          text='로그인'
          color='black'
          width='130px'
          height='35px'
        />
      </Link>
      <Link to='/join'>
        <Button
          id='JoinBtn'
          text='회원가입'
          color='white'
          width='130px'
          height='35px'
        />
      </Link>
    </StyledNavLogin>
  );
};

export const StyledNavLogin = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;

  & > * {
    margin-bottom: 10px;
  }
`;

export default NavLogin;
