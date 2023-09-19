import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import instance from '../api/axios';
import requests from '../api/requests';

export const fetchCategoryProducts = createAsyncThunk(
  'products/fetchCategory',
  async (category) => {
    const url = category ? requests[category] : requests.fetchAllProducts;
    const response = await instance.get(url);
    return response.data;
  }
);

const productSlice = createSlice({
  name: 'products',
  initialState: { items: [], status: 'idle', error: null },
  reducers: {},
  extraReducers: (builder) => {
    builder
      .addCase(fetchCategoryProducts.pending, (state) => {
        state.status = 'loading';
      })
      .addCase(fetchCategoryProducts.fulfilled, (state, action) => {
        state.status = 'succeeded';
        state.items = action.payload;
      })
      .addCase(fetchCategoryProducts.rejected, (state, action) => {
        state.status = 'failed';
        state.error = action.error.message;
      });
  },
});

export default productSlice.reducer;