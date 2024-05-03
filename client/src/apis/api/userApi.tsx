import { API } from '../utils/instance';

interface ResultResponse {
  success: boolean;
  message: string;
}

export const checkLogin = async (): Promise<ResultResponse> => {
  try {
    const response = await API.get(`userAPI/checkLogin`);
    return { success: response.data.login, message: '' };
  } catch (error) {
    console.log('Error checkLogin: ', error);
    return { success: false, message: 'API Error' };
  }
};

interface UserInfo {
  success: boolean;
  id?: string;
  icon?: string;
  nickname?: string;
}

export const getUserInfo = async (): Promise<UserInfo> => {
  try {
    const response = await API.get(`userApi/nav`);
    const data = response.data;
    return data;
  } catch (error) {
    console.log('Error getUserInfo: ', error);
    return { success: false };
  }
};

interface LoginRequest {
  id: string;
  password: string;
}

export const login = async (
  loginData: LoginRequest,
): Promise<ResultResponse> => {
  try {
    const response = await API.post(`userApi/login`, loginData);
    return { success: response.data.success, message: '' };
  } catch (error) {
    console.error('Error login:', error);
    return { success: false, message: 'API Error' };
  }
};

export const logout = async (): Promise<ResultResponse> => {
  try {
    const response = await API.get(`userApi/logout`);
    return response.data.success;
  } catch (error) {
    console.log('Error logout:', error);
    return { success: false, message: 'API Error' };
  }
};
