import styled from 'styled-components';
import Button from '../atom/Button';
import { Link, useNavigate } from 'react-router-dom';
import { login } from '../../apis/api/userApi';
import { useSelector, useDispatch } from 'react-redux';
import { RootState } from '../../store/store';
import { setLoginStatus } from '../../store/slice/loginSlice';

const LoginBtns = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const { id, password } = useSelector((state: RootState) => state.login);

  const tryLogin = async () => {
    const result = await login({ id, password });
    if (result) {
      dispatch(setLoginStatus(true));
      navigate('/');
    } else {
      console.log('오류');
    }
  };

  return (
    <StyledLoginBtns>
      <Button
        text='로그인'
        color='black'
        width='160px'
        height='40px'
        onClick={tryLogin}
      />
      <Link to='/join'>
        <Button text='회원가입' color='white' width='160px' height='40px' />
      </Link>
    </StyledLoginBtns>
  );
};

export const StyledLoginBtns = styled.div`
  & > :first-child {
    margin-right: 35px;
  }
`;

export default LoginBtns;
