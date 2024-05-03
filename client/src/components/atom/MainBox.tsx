import styled from 'styled-components';

interface MainBoxProps {
  children: JSX.Element | JSX.Element[];
}

const MainBox = ({ children }: MainBoxProps) => {
  return <StyledMainBox>{children}</StyledMainBox>;
};

const StyledMainBox = styled.div`
  padding-top: 60px;
  padding-bottom: 60px;
  padding-left: 90px;
  padding-right: 90px;
  margin-left: 270px;
  margin-top: 55px;

  @media (max-width: 768px) {
    padding-top: 0;
    padding-bottom: 0;
    padding-left: 5vw;
    padding-right: 5vw;
    margin-left: 0;
    margin-top: 10px;
  }
`;

export default MainBox;
