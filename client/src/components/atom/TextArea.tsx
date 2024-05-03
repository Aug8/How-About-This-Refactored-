import { FC } from 'react';
import styled from 'styled-components';

interface TextAreaProps {
  width?: string;
  height?: string;
  placeholder?: string;
}

const TextArea: FC<TextAreaProps> = ({ placeholder, width, height }) => {
  return (
    <StyledTextArea width={width} height={height} placeholder={placeholder} />
  );
};

export const StyledTextArea = styled.textarea<TextAreaProps>`
  width: ${(props) => props.width || 'auto'};
  height: ${(props) => props.height || 'auto'};
  resize: none;
  font-family: var(--noto-font);
  font-size: 15px;
  border-radius: 10px;
  padding: 10px;
`;

export default TextArea;
