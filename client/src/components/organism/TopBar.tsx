import styled from 'styled-components';
import TopBarSelects from '../molecule/TopBarSelects';
import SearchBar from '../molecule/SearchBar';

const TopBar = () => {
  return (
    <StyledTopBar>
      <TopBarSelects />
      <SearchBar />
    </StyledTopBar>
  );
};

const StyledTopBar = styled.div`
  position: fixed;
  top: 0;
  left: 270px;
  z-index: 1;
  width: 100%;
  display: flex;
  justify-content: center;
  padding: 10px;
  padding-right: 17%;
  background-color: white;
  box-shadow: var(--bar-shadow);
  border-left: 3px solid var(--light-grey-color);

  @media (max-width: 768px) {
    display: none;
  }
`;

export default TopBar;
