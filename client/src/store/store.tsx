import { configureStore } from '@reduxjs/toolkit';
import categoryReducer from './slice/categorySlice';
import joinReducer from './slice/joinSlice';
import profileEditReducer from './slice/profileEditSlice';
import loginReducer from './slice/loginSlice';

const store = configureStore({
  reducer: {
    category: categoryReducer,
    join: joinReducer,
    login: loginReducer,
    profileEdit: profileEditReducer,
  },
});

export default store;

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;
