import './utils/variables.scss';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

import LeftNavBar from './components/organism/LeftNavBar';
import TopBar from './components/organism/TopBar';
import MobileBar from './components/template/MobileBar';
import MainBox from './components/atom/MainBox';
import ProductListBox from './components/organism/ProductListBox';
import LoginArea from './components/template/LoginArea';
import JoinArea from './components/template/JoinArea';
import Profile from './components/template/Profile';
import ProfileEdit from './components/template/ProfileEdit';
import ChatRoom from './components/template/ChatRoom';

function App() {
  return (
    <BrowserRouter>
      <div className='App'>
        <LeftNavBar />
        <TopBar />
        <MobileBar />
        <Routes>
          <Route path='/' element={<MainBox children={ProductListBox()} />} />
          <Route path='/login' element={<MainBox children={LoginArea()} />} />
          <Route path='/join' element={<MainBox children={JoinArea()} />} />
          <Route
            path='/profile/:userId'
            element={<MainBox children={Profile()} />}
          />
          <Route
            path='/profileedit'
            element={<MainBox children={ProfileEdit()} />}
          />
          <Route path='/chatroom' element={<MainBox children={ChatRoom()} />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
