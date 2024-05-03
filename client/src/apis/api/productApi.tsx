import { API } from '../utils/instance';

interface ProductData {
  prodId: number;
  prodName: string;
  likecount: number;
}

interface ProductListOptions {
  categoryId: number;
  sort: string;
}

export const postProducts = async (
  options: ProductListOptions,
): Promise<ProductData[]> => {
  try {
    const response = await API.post(`productAPI/list`, options);
    console.log(response.data);
    const data: ProductData[] = response.data.data.map((item: any) => ({
      prodId: item.prodID,
      prodName: item.prodNAME,
      likecount: item.likecount,
    }));
    return data;
  } catch (error) {
    console.error('Error getProducts:', error);
    return [];
  }
};
