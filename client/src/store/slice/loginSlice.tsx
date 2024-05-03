import { createSlice, PayloadAction } from '@reduxjs/toolkit';

export interface LoginState {
  id: string;
  password: string;
  loginStatus: boolean;
}

const initialState: LoginState = {
  id: '',
  password: '',
  loginStatus: false,
};

export const loginSlice = createSlice({
  name: 'login',
  initialState,
  reducers: {
    setId: (state, action: PayloadAction<string>) => {
      state.id = action.payload;
    },
    setPassword: (state, action: PayloadAction<string>) => {
      state.password = action.payload;
    },
    setLoginStatus: (state, action: PayloadAction<boolean>) => {
      state.loginStatus = action.payload;
    },
  },
});

export const { setId, setPassword, setLoginStatus } = loginSlice.actions;

export default loginSlice.reducer;
