import { getResponse, createPagination } from 'utils/utils';
import {
    fetchGoodsList,
} from '../services/goodsServices/goodsService';

export default {
    namespace: 'goods',

    state: {
        goodsList: [], // 列表数据
        pagination: {}, // 分页器
    },

    effects: {
        *fetchGoodsList({ payload }, { call, put }) {
            const res = yield call(fetchGoodsList, payload);
            const list = getResponse(res);
            console.log(list)
            if (list) {
                yield put({
                    type: 'updateState',
                    payload: {
                        goodsList: list,
                        pagination: createPagination(list),
                    },
                });
            }
            return list;
        }
    },

    reducers: {
        updateState(state, action) {
            return {
                ...state,
                ...action.payload,
            };
        },
    },
}