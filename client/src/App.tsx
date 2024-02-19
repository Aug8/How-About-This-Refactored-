import './utils/variables.scss';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

import LeftNavBar from './components/organism/LeftNavBar';
import TopBar from './components/organism/TopBar';
import MainBox from './components/atom/MainBox';
import ProductListBox from './components/organism/ProductListBox';
import LoginArea from './components/template/LoginArea';
import JoinArea from './components/template/JoinArea';

function App() {
  return (
    <BrowserRouter>
      <div className='App'>
        <LeftNavBar />
        <TopBar />
        <Routes>
          <Route path='/' element={<MainBox children={ProductListBox()} />} />
          <Route path='/login' element={<MainBox children={LoginArea()} />} />
          <Route path='/join' element={<MainBox children={JoinArea()} />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
