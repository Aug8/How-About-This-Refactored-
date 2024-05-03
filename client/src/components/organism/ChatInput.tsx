import styled from 'styled-components';
import Input from '../atom/Input';
import { VscSend } from 'react-icons/vsc';

const ChatInput = () => {
  return (
    <StyledChatInput>
      <Input width='100%' padding='10px' placeholder='메시지를 입력하세요' />
      <SendBtn>
        <VscSend size={20} />
      </SendBtn>
    </StyledChatInput>
  );
};

export const StyledChatInput = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 15px;
`;

export const SendBtn = styled.div`
  width: 50px;
  color: gray;
`;
export default ChatInput;
