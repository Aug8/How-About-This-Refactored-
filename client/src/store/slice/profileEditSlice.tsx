import { createSlice, PayloadAction } from '@reduxjs/toolkit';

export interface ProfileEditState {
  isBoxVisible: boolean;
  selectedSnsType: string;
}

const initialState: ProfileEditState = {
  isBoxVisible: false,
  selectedSnsType: '',
};

export const ProfileEditSlice = createSlice({
  name: 'profileEdit',
  initialState,
  reducers: {
    toggle: (state) => {
      state.isBoxVisible = !state.isBoxVisible;
    },
    select: (state, action: PayloadAction<string>) => {
      state.selectedSnsType = action.payload;
    },
  },
});

export const { toggle, select } = ProfileEditSlice.actions;

export default ProfileEditSlice.reducer;
