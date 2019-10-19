/**
 *  客户端
 * @date: 2019-04-29
 * @author: eliu <memories.liu@hand-china.com>
 * @copyright Copyright (c) 2019, Hand
 */
import request from 'utils/request';
import { parseParameters } from 'utils/utils';
import { HZERO_TODO } from '@/utils/config';

/**
 * 请求API前缀
 * @type {string}
 */
const prefix = `${HZERO_TODO}/v1`;

/**
 * 查询client列表数据
 * @async
 * @function fetchUserList
 * @param {object} params - 查询条件
 */
export async function fetchUserList(params) {
  const param = parseParameters(params);
  const { tenantId, ...others } = param;
  return request(`${prefix}/user`, {
    method: 'GET',
    query: others,
  });
}

export async function fetchDetail(params) {
  const param = parseParameters(params);
  const { userId } = param;
  return request(`${prefix}/user/${userId}`, {
    method: 'GET',
  });
}

/**
 * 保存角色
 * @async
 * @function createUser
 * @param {object} params - 创建参数
 */
export async function createUser(params) {
  return request(`${prefix}/user`, {
    method: 'POST',
    body: params,
  });
}

/**
 * 更新角色
 * @async
 * @function updateUser
 * @param {object} params - 更新参数
 */
export async function updateUser(params) {
  return request(`${prefix}/user`, {
    method: 'PUT',
    body: params,
  });
}

/**
 * 删除角色
 * @async
 * @function deleteUser
 * @param {object} params - 删除对象
 */
export async function deleteUser(params) {
  return request(`${prefix}/user`, {
    method: 'DELETE',
    body: params,
  });
}
