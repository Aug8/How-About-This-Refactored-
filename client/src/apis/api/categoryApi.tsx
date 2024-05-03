import { API } from '../utils/instance';

interface CategoryData {
  cateId: number;
  cateName: string;
}

export const getAllCateName = async (): Promise<CategoryData[]> => {
  try {
    const response = await API.get(`categoryAPI/all`);
    const data: CategoryData[] = response.data.data.map((item: any) => ({
      cateId: item.id,
      cateName: item.name,
    }));
    return data;
  } catch (error) {
    console.error('Error getAllCateName:', error);
    return [];
  }
};
