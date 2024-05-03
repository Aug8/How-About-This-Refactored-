import { FC } from 'react';
import styled from 'styled-components';
import logoImg from '../../assets/logo.png';

interface LogoProps {
  width?: string;
}

const Logo: FC<LogoProps> = ({ width }) => {
  return <StyledLogo src={logoImg} width={width} />;
};

export const StyledLogo = styled.img`
  width: ${(props) => props.width || '250px'};
  height: auto;
  cursor: pointer;
`;

export default Logo;
