import { useEffect, useState } from 'react';
import ProductListTitle from '../molecule/ProductListTitle';
import ProductList from '../molecule/ProductList';

import { postProducts } from '../../apis/api/productApi';

import { useSelector, useDispatch } from 'react-redux';
import { RootState } from '../../store/store';
import { Root } from 'react-dom/client';

const sample = [
  {
    name: '손선풍기',
    imgSrc: 'https://sitem.ssgcdn.com/91/71/69/item/1000543697191_i1_1100.jpg',
  },
  {
    name: '바인더',
    imgSrc:
      'https://image.brandi.me/cproduct/2022/01/11/SB000000000049857754_1641888259_image1_M.jpeg',
  },
  {
    name: '빔프로젝터',
    imgSrc:
      'https://image9.coupangcdn.com/image/vendor_inventory/8401/f64a86397b47cdb8286f616946a8cb43c4ab0364c762452940664058de73.jpg',
  },
  {
    name: '테니스라켓',
    imgSrc:
      'https://image8.coupangcdn.com/image/retail/images/2022/09/08/22/0/d85e4ed1-7d89-4339-bef2-3f289a3e7a15.png',
  },
  {
    name: '화장대',
    imgSrc:
      'https://image7.coupangcdn.com/image/vendor_inventory/f1fa/e2971830ada8db7787170a57f6a2f759199c900c0c29ac227409ba03567f.jpg',
  },
  {
    name: '다꾸 랜덤박스',
    imgSrc:
      'https://image6.coupangcdn.com/image/vendor_inventory/4c5b/d3c193277b4f9104adb1cc607888c5d4dbeceb98ffb7c2aa0ae55a74b540.jpg',
  },
  {
    name: '아이라이너',
    imgSrc:
      'https://image8.coupangcdn.com/image/retail/images/692547764179109-acd46dc9-e4bd-4416-a679-67e67c02033d.jpg',
  },
  {
    name: '패브릭 포스터',
    imgSrc:
      'https://image6.coupangcdn.com/image/rs_quotation_api/lspb7qnu/f04476a71b624a31b30738cc06234ec3.jpg',
  },
];

interface ProductProps {
  prodId: number;
  prodName: string;
  likecount: number;
}

const ProductListBox = () => {
  const [products, setProducts] = useState<ProductProps[]>([]);
  const { selectedId, sort } = useSelector(
    (state: RootState) => state.category,
  );

  useEffect(() => {
    const getProductsList = async () => {
      const data = await postProducts({ categoryId: selectedId, sort });
      console.log(data);
    };

    getProductsList();
  }, []);
  return (
    <>
      <ProductListTitle />
      <ProductList children={sample} />
    </>
  );
};

export default ProductListBox;
