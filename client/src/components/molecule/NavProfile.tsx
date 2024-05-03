import { useEffect, useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import Button from '../atom/Button';
import styled from 'styled-components';
import ProfileImg from '../atom/ProfileImg';

import { getUserInfo, logout } from '../../apis/api/userApi';

interface UserInfoProps {
  success: boolean;
  id?: string;
  icon?: string;
  nickname?: string;
}

const NavProfile = () => {
  const navigate = useNavigate();
  const [userInfo, setUserInfo] = useState<UserInfoProps>({
    success: false,
    nickname: 'nickname',
  });

  useEffect(() => {
    const fetchUserInfo = async () => {
      const data = await getUserInfo();
      setUserInfo(data);
    };

    fetchUserInfo();
  }, []);

  const tryLogout = () => {
    logout();
    window.location.reload();
  };

  return (
    <StyledNavProfile>
      <Link to={`/profile/${userInfo.id}`}>
        <ProfileImg src={userInfo.icon} />
      </Link>
      <p>{userInfo.nickname}</p>
      <Button
        text='로그아웃'
        color='black'
        width='130px'
        height='35px'
        onClick={tryLogout}
      />
    </StyledNavProfile>
  );
};

export const StyledNavProfile = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;

  & > * {
    margin-bottom: 10px;
  }
`;

export default NavProfile;
