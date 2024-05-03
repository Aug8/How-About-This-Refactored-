import styled from 'styled-components';
import { eventFunction } from '../../utils/types/eventFunction';

interface InputProps {
  type?: string;
  placeholder?: string;
  onChange?: React.ChangeEventHandler<HTMLInputElement>;
  onKeyDown?: eventFunction;
  value?: string;
  width?: string;
  padding?: string;
}

type InputHTMLProps = React.InputHTMLAttributes<HTMLInputElement>;

const Input: React.FC<InputProps & InputHTMLProps> = ({
  type,
  placeholder,
  onChange,
  onKeyDown,
  value,
  width,
  padding,
  ...rest // Capture remaining props
}) => {
  return (
    <StyledInput
      type={type}
      placeholder={placeholder}
      onChange={onChange}
      onKeyDown={onKeyDown}
      value={value}
      width={width}
      padding={padding}
    />
  );
};

const StyledInput = styled.input<InputProps>`
  width: ${({ width }) => (width ? width : '700px')};
  padding: ${({ padding }) => (padding ? padding : '9px 0 10px 0')};
  background-color: var(--bg-grey-color);
  border: none;
  border-radius: 5px;
  font-size: 16px;
  font-family: var(--noto-font);
  color: rgba(0, 0, 0, 0.6);
  &:focus {
    outline: none;
  }
`;

export default Input;
