// import React from 'react';
// import { connect } from 'dva';
// import formatterCollections from 'utils/intl/formatterCollections';
// import { getCurrentOrganizationId } from 'utils/utils';

import img1 from "../../assets/1.jpg";
import img2 from "../../assets/2.jpg";
import img3 from "../../assets/3.jpg";
import img4 from "../../assets/4.jpg";

import React from 'react';
import { connect } from 'dva';
import { Form, Input, Button, Table, Popconfirm } from 'hzero-ui';
import { Bind } from 'lodash-decorators';
import { isEmpty } from 'lodash';
import intl from 'utils/intl';
import formatterCollections from 'utils/intl/formatterCollections';
import notification from 'utils/notification';
import { Header, Content } from 'components/Page';
import { getCurrentOrganizationId, tableScrollWidth } from 'utils/utils';
// import TaskDrawer from './TaskDrawer';

// const FormItem = Form.Item;
// @Form.create({ fieldNameProp: null })
// @formatterCollections({ code: ['todo.task'] })

// import intl from 'utils/intl';
// import prompt from 'utils/intl/prompt';

// @formatterCollections({ code: ['hiam.goods'] })

// @connect(mapStateToProps, mapDispatchToProps)
export default class Goods extends React.Component {
    constructor(props) {
        super(props);
        // this.filterFormRef = React.createRef();
        this.state = {
            goodsList: [
                {
                    id: "01",
                    goodsName: "huawei001",
                    goodsDesc: "海军一号",
                    goodsPrice: "100",
                    goodsNum: "10",
                    imgUrl: img1,
                },
                {
                    id: "02",
                    goodsName: "华为002",
                    goodsDesc: "无敌大嘴",
                    goodsPrice: "100",
                    goodsNum: "10",
                    imgUrl: img2,
                },
                {
                    id: "03",
                    goodsName: "华为003",
                    goodsDesc: "爱国首选",
                    goodsPrice: "100",
                    goodsNum: "10",
                    imgUrl: img3,
                },
                {
                    id: "04",
                    goodsName: "huawei004",
                    goodsDesc: "大嘴四号",
                    goodsPrice: "100",
                    goodsNum: "10",
                    imgUrl: img4,
                }
            ],
            goodsList2: [
                {
                    id: "01",
                    goodsName: "huawei001",
                    goodsDesc: "海军一号",
                    goodsPrice: "100",
                    goodsNum: "10",
                    imgUrl: img1,
                },
                {
                    id: "02",
                    goodsName: "华为002",
                    goodsDesc: "无敌大嘴",
                    goodsPrice: "100",
                    goodsNum: "10",
                    imgUrl: img2,
                },
                {
                    id: "03",
                    goodsName: "华为003",
                    goodsDesc: "爱国首选",
                    goodsPrice: "100",
                    goodsNum: "10",
                    imgUrl: img3,
                },
                {
                    id: "04",
                    goodsName: "huawei004",
                    goodsDesc: "大嘴四号",
                    goodsPrice: "100",
                    goodsNum: "10",
                    imgUrl: img4,
                }
            ]
        }
      }
    
      componentDidMount() {
        // this.handleSearch();
      }
    
      /**
       * 客户端列表数据查询
       * @param {object} params - 查询参数
       */
    //   @Bind()
    //   handleSearch(params = {}) {
    //     const { form, query, pagination } = this.props;
    //       const fieldValues = this.filterFormRef.current.getFieldsValue();
    //         query({
    //           params: {
    //             page: pagination,
    //             ...fieldValues,
    //             ...params,
    //           },
    //         });
    //   }

  render() {
    //   const { goodsList = [], pagination, fetchLoading } = this.props;
    //   console.log(12121)
    //   console.log(goodsList)
      return (
          <div class="seckill_content">
              {/* 一类商品 */}
              <div class="title"><h2>倒计时</h2></div>
              <div class="all_seckill_goods">
                  <ul className="goods-list-show">
                      {this.state.goodsList.map((goods, index) => {
                          return <li className="goods-item" style={{ position: "relative", cursor: "pointer", listStyleType: 'none', border: "1px solid rgb(221, 221, 221)", display: "inline-block", margin: "0 10px" }}>
                              <div className="goods-item-img">
                                  <img src={goods.imgUrl} className="goods-img" style={{ position: "relative", height: "188px", width: "100%" }} />
                              </div>
                              <div className="goods-item-info" style={{ background: "#fff", height: "50px", padding: "0 10px" }}>
                                  <a href="#" style={{ display: "inline-block", float: "left" }}>详情页</a>
                                  <a href="#" style={{ display: "inline-block", float: "right" }}>订单页</a>
                              </div>
                          </li>
                      })}
                  </ul>
              </div>
              {/* 二类商品 */}
              <div class="title"><h2>倒计时</h2></div>
              <div class="all_seckill_goods">
                  <ul className="goods-list-show">
                      {this.state.goodsList2.map((goods, index) => {
                          return <li className="goods-item" style={{ position: "relative", cursor: "pointer", listStyleType: 'none', border: "1px solid rgb(221, 221, 221)", display: "inline-block", margin: "0 10px" }}>
                              <div className="goods-item-img">
                                  <img src={goods.imgUrl} className="goods-img" style={{ position: "relative", height: "188px", width: "100%" }} />
                              </div>
                              <div className="goods-item-info" style={{ background: "#fff", height: "50px", padding: "0 10px" }}>
                                  <a href="#" style={{ display: "inline-block", float: "left" }}>详情页</a>
                                  <a href="#" style={{ display: "inline-block", float: "right" }}>订单页</a>
                              </div>
                          </li>
                      })}
                  </ul>
              </div>
          </div>
    );
  }
}

// function mapStateToProps({ goods, loading }) {
//     const {
//         goodsList = [],
//         pagination = {},
//     } = goods;
//     return {
//         goodsList: [],
//         pagination: {},
//         fetchLoading: loading.effects['goods/fetchGoodsList'],
//     };
// }

// function mapDispatchToProps(dispatch) {
//     return {
//         query(payload) {
//             return dispatch({
//                 type: 'goods/fetchGoodsList',
//                 payload,
//             });
//         },
//     };
// }