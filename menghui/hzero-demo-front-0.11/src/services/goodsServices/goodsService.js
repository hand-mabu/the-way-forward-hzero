import request from 'utils/request';

export async function fetchGoodsList(params) {
  return request(`http://localhost:8888/goods/listSeckill`, {
    method: 'GET',
  });
}