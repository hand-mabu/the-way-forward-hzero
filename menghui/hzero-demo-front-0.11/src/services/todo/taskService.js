/**
 *  客户端
 * @date: 2018-12-24
 * @author: LZY <zhuyan.luo@hand-china.com>
 * @copyright Copyright (c) 2018, Hand
 */
import request from 'utils/request';
import { HZERO_HTDS } from '@/utils/config';
import { parseParameters } from 'utils/utils';

/**
 * 请求API前缀
 * @type {string}
 */
const prefix = `${HZERO_HTDS}/v1`;

/**
 * 查询task列表数据
 * @async
 * @function fetchTaskList
 * @param {object} params - 查询条件
 */
export async function fetchTaskList(params) {
  const param = parseParameters(params);
  const { ...others } = param;
  return request(`${prefix}/ora21991/tasks/queryAll`, {
    method: 'GET',
    query: others,
  });
}
/**
 * 查询clien详情数据
 * @async
 * @function fetchDetail
 * @param {object} params - 查询条件
 */
export async function fetchDetail(params) {
  const { clientId } = params;
  return request(`${prefix}/ora21991/tasks/${clientId}`, {
    method: 'GET',
  });
}

/**
 * 新建
 * @async
 * @function createTask
 * @param {object} params - 创建参数
 */
export async function createTask(params) {
  const { ...others } = params;
  return request(`${prefix}/ora21991/tasks`, {
    method: 'POST',
    body: others,
  });
}

/**
 * 更新
 * @async
 * @function updateTask
 * @param {object} params - 参数
 */
export async function updateTask(params) {
  const { ...others } = params;
  const { id } = others;
  return request(`${prefix}/ora21991/tasks/${id}`, {
    method: 'PUT',
    body: others,
  });
}

/**
 * 删除
 * @async
 * @function deleteTask
 * @param {object} params - 参数
 */
export async function deleteTask(params) {
  const { taskNumber } = params;
  return request(`${prefix}/ora21991/tasks/taskNumber/${taskNumber}`, {
    method: 'DELETE',
    // body: params,
  });
}
