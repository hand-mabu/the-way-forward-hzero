/**
 * client.js - Todo User model
 * @date: 2019-04-28
 * @author: eliu <memories.liu@hand-china.com>
 * @version: 1.0.0
 * @copyright: Copyright (c) 2018, Hand
 */

import { getResponse, createPagination } from 'utils/utils';
import {
  fetchUserList,
  fetchDetail,
  createUser,
  updateUser,
  deleteUser,
} from '@/services/todo/userService';

export default {
  namespace: 'todoUser',

  state: {
    userList: [], // 列表数据
    pagination: {}, // 分页器
    detailData: {}, // 用户明细数据
  },

  effects: {
    // 查询用户列表数据
    *fetchUserList({ payload }, { call, put }) {
      const res = yield call(fetchUserList, payload);
      const list = getResponse(res);
      if (list) {
        yield put({
          type: 'updateState',
          payload: {
            userList: list.content,
            pagination: createPagination(list),
          },
        });
      }
      return list;
    },

    // 查询详情
    *fetchDetail({ payload }, { call, put }) {
      const res = yield call(fetchDetail, payload);
      const list = getResponse(res);
      if (list) {
        yield put({
          type: 'updateState',
          payload: {
            detailData: list,
          },
        });
      }
      return list;
    },

    // 创建用户
    *createUser({ payload }, { call }) {
      const res = yield call(createUser, payload);
      return getResponse(res);
    },

    // 更新用户信息
    *updateUser({ payload }, { call }) {
      const res = yield call(updateUser, payload);
      return getResponse(res);
    },

    // 删除用户
    *deleteUser({ payload }, { call }) {
      const response = yield call(deleteUser, payload);
      return getResponse(response);
    },
  },

  reducers: {
    updateState(state, action) {
      return {
        ...state,
        ...action.payload,
      };
    },
  },
};
