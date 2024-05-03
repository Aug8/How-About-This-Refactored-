import styled from 'styled-components';

const ChatTop = () => {
  return (
    <StyledChatTop>
      <BackBtn>{'<'}</BackBtn>
      <p>name</p>
      <BackBtn />
    </StyledChatTop>
  );
};

export const StyledChatTop = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  height: 80px;
  border-bottom: 1px solid black;
  font-size: 20px;
  font-weight: 600;
  font-family: var(--gowun);
`;

export const BackBtn = styled.div`
  width: 50px;
`;

export default ChatTop;
