/**
 * Task.js - 客户端 model
 * @date: 2018-12-24
 * @author: XXX <xxx@hand-china.com>
 * @version: 0.0.1
 * @copyright: Copyright (c) 2018, Hand
 */

import { getResponse, createPagination } from 'utils/utils';
import {
  fetchTaskList,
  fetchDetail,
  createTask,
  updateTask,
  deleteTask,
} from '@/services/todo/taskService';

export default {
  namespace: 'task',

  state: {
    taskList: [], // 列表数据
    pagination: {}, // 分页器
  },

  effects: {
    // 查询Task列表数据
    *fetchTaskList({ payload }, { call, put }) {
      const res = yield call(fetchTaskList, payload);
      const list = getResponse(res);
      if (list) {
        yield put({
          type: 'updateState',
          payload: {
            taskList: list.content,
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
    // 创建
    *createTask({ payload }, { call }) {
      const res = yield call(createTask, payload);
      return getResponse(res);
    },
    // 更新Task
    *updateTask({ payload }, { call }) {
      const res = yield call(updateTask, payload);
      return getResponse(res);
    },
    // 删除
    *deleteTask({ payload }, { call }) {
      const res = yield call(deleteTask, payload);
      return getResponse(res);
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
