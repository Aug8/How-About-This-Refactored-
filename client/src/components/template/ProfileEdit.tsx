import styled from 'styled-components';
import SnsEdit from '../organism/SnsEdit';
import Box from '../atom/Box';
import Title from '../atom/Title';
import Button from '../atom/Button';
import ProfileImg from '../atom/ProfileImg';
import TextArea from '../atom/TextArea';

const ProfileEdit = () => {
  return (
    <StyledProfileEdit>
      <Box width='1100px'>
        <StyledBox>
          <Title text='프로필 수정' size='28px' />
          <EditArea>
            <EditLeft>
              <ProfileImg width='150px' />
              <Button text='사진 선택' color='white' height='40px' />
            </EditLeft>
            <EditRight>
              <TextArea width='350px' height='22px' />
              <TextArea width='500px' height='200px' />
              <SnsEdit />
            </EditRight>
          </EditArea>
          <ButtonArea>
            <Button
              text='비밀번호 변경'
              color='white'
              width='200px'
              height='40px'
            />
            <Button text='수정 완료' width='200px' height='40px' />
          </ButtonArea>
        </StyledBox>
      </Box>
    </StyledProfileEdit>
  );
};

const StyledProfileEdit = styled.div`
  height: calc(100vh - 200px);
  display: flex;
  text-align: center;
  justify-content: center;
  align-items: center;
`;

const StyledBox = styled.div`
  padding: 50px;
`;

const EditArea = styled.div`
  display: flex;
  justify-content: center;
  padding: 50px;
`;

const EditLeft = styled.div`
  display: flex;
  flex-direction: column;
  margin-right: 50px;
  & > *:not(:last-child) {
    margin-bottom: 10px;
  }
`;

const EditRight = styled.div`
  display: flex;
  flex-direction: column;
  & > *:not(:last-child) {
    margin-bottom: 10px;
  }
`;

const ButtonArea = styled.div`
  & > *:not(:last-child) {
    margin-right: 100px;
  }
`;

export default ProfileEdit;
