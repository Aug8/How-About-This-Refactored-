import { API } from '../utils/instance';

interface Profile {
  profileData: {
    userId: string;
    userIcon: string;
    introduce: string;
    nickname: string;
  };
  snsList: Record<string, string>;
}

export const getProfile = async (userId: string): Promise<Profile> => {
  try {
    const response = await API.get(`/profileAPI/${userId}`);
    const data = response.data;
    console.log(response.data);
    return data;
  } catch (error) {
    console.log('Error getUserInfo: ', error);
    return {
      profileData: {
        userId: 'userId',
        userIcon: '',
        introduce: 'Hello.',
        nickname: 'nickname',
      },
      snsList: {},
    };
  }
};
