import styled from 'styled-components';

const ChatArea = () => {
  return (
    <StyledChatArea>
      <DateArea>2024년 04월 04일</DateArea>
      <MyMessage>my-message</MyMessage>
      <YourMessage>your-message</YourMessage>
      <YourMessage>
        very-long-message how about this message you can handle it
      </YourMessage>
    </StyledChatArea>
  );
};

export const StyledChatArea = styled.div`
  display: flex;
  flex-direction: column;
  padding: 10px;
  align-items: center;
  margin: 15px 0;
  min-height: 50vh;
  & > *:not(:last-child) {
    margin-bottom: 15px;
  }
`;

export const DateArea = styled.div`
  background-color: var(--bg-grey-color);
  padding: 10px 20px;
  border-radius: 100px;
  font-size: 13px;
`;

export const MyMessage = styled.div`
  background-color: var(--text-bg-blue-color);
  color: white;
  border-radius: 15px 0 15px 15px;
  padding: 10px 20px;
  margin-left: auto;
  max-width: 400px;
  overflow-wrap: break-word;
  text-align: right;
  line-height: 1.5;
`;

export const YourMessage = styled.div`
  background-color: var(--text-bg-grey-color);
  color: white;
  border-radius: 0 15px 15px 15px;
  padding: 10px 20px;
  margin-right: auto;
  max-width: 400px;
  overflow-wrap: break-word;
  text-align: left;
  line-height: 1.5;
`;

export default ChatArea;
