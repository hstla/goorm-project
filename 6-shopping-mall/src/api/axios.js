import axios from 'axios';

const instance = axios.create({
  baseURL: "https://fakestoreapi.com/",
});

export default instance;

const requests = {
  fetchAllProducts: 'products',
}

export { requests };
