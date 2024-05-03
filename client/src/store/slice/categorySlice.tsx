import { createSlice, PayloadAction } from '@reduxjs/toolkit';

export interface CategoryState {
  selectedId: number;
  sort: string;
}

const initialState: CategoryState = {
  selectedId: 0,
  sort: 'like',
};

export const categorySlice = createSlice({
  name: 'category',
  initialState,
  reducers: {
    select: (state, action: PayloadAction<number>) => {
      state.selectedId = action.payload;
    },
    setSort: (state, action: PayloadAction<string>) => {
      state.sort = action.payload;
    },
  },
});

export const { select, setSort } = categorySlice.actions;

export default categorySlice.reducer;
