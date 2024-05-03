import { FaBloggerB } from 'react-icons/fa';
import {
  RiMailFill,
  RiYoutubeFill,
  RiInstagramFill,
  RiFacebookBoxFill,
  RiKakaoTalkFill,
} from 'react-icons/ri';

export const snsTypes: { [key: string]: JSX.Element } = {
  kakaotalk: <RiKakaoTalkFill size={32} color='black' />,
  instagram: <RiInstagramFill size={31} color='black' />,
  youtube: <RiYoutubeFill size={32} color='black' />,
  facebook: <RiFacebookBoxFill size={28} color='black' />,
  email: <RiMailFill size={28} color='black' />,
  blog: <FaBloggerB size={27} color='black' />,
};
