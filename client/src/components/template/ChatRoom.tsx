import styled from 'styled-components';
import ChatTop from '../organism/ChatTop';
import ChatArea from '../organism/ChatArea';
import ChatInput from '../organism/ChatInput';
import Box from '../atom/Box';

const ChatRoom = () => {
  return (
    <StyledChatRoom>
      <Box width='800px'>
        <StyledBox>
          <ChatTop />
          <ChatArea />
          <ChatInput />
        </StyledBox>
      </Box>
    </StyledChatRoom>
  );
};

const StyledChatRoom = styled.div`
  height: calc(100vh - 200px);
  display: flex;
  text-align: center;
  justify-content: center;
  align-items: center;
`;

const StyledBox = styled.div`
  padding: 0 15px;
`;

export default ChatRoom;
