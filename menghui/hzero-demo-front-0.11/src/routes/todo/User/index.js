/**
 * todo - Todo User
 * @date: 2019-04-28
 * @author: eliu <memories.liu@hand-china.com>
 * @version: 1.0.0
 * @copyright Copyright (c) 2018, Hand
 */
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
import Drawer from './Drawer';

const FormItem = Form.Item;
@Form.create({ fieldNameProp: null })
@formatterCollections({ code: ['todo.user'] })
/**
 * todo - 业务组件 - 客户端
 * @extends {Component} - React.Component
 * @reactProps {!Object} [todoUser={}] - 数据源
 * @reactProps {!Object} [loading={}] - 加载是否完成
 * @reactProps {!Object} [loading.effect={}] - 加载是否完成
 * @reactProps {boolean} [fetchListLoading=false] - 用户列表信息加载中
 * @reactProps {boolean} [createUserLoading=false] - 创建用户处理中
 * @reactProps {Function} [dispatch= e => e] - redux dispatch方法
 * @return React.element
 */
@connect(({ todoUser, loading }) => ({
  todoUser,
  fetchLoading: loading.effects['todoUser/fetchUserList'],
  createLoading: loading.effects['todoUser/createUser'],
  tenantId: getCurrentOrganizationId(),
}))
export default class User extends React.Component {
  state = {
    visible: false, // 测试弹窗
    detailData: {}, // 用户详情数据
  };

  /**
   * @function componentDidMount 组件加载完成之后自动触发查询
   */
  componentDidMount() {
    this.handleSearch();
  }

  /**
   * 查询
   */
  @Bind()
  handleSearch(fields = {}) {
    const { form, dispatch } = this.props;
    form.validateFields((err, values) => {
      const fieldValues = values || {};
      if (!err) {
        dispatch({
          type: 'todoUser/fetchUserList',
          payload: {
            page: isEmpty(fields) ? {} : fields,
            ...fieldValues,
          },
        });
      }
    });
  }

  /**
   * @function handleResetSearch - 重置查询表单
   */
  @Bind()
  handleResetSearch() {
    this.props.form.resetFields();
  }

  // 打开连接测试弹窗
  @Bind()
  showModal() {
    this.setState({ visible: true });
  }

  // 关闭连接测试弹窗
  @Bind()
  hiddenModal() {
    this.setState({ visible: false, detailData: {} });
  }

  // 新建
  @Bind()
  handleAdd() {
    // const { dispatch, tenantId } = this.props;
    // dispatch({
    //   type: 'todoUser/fetchRandomData',
    //   payload: {
    //     tenantId,
    //   },
    // }).then(res => {
    //   this.setState({ detailData: res }, () => {
    //     this.showModal();
    //   });
    // });
    this.setState({ detailData: {} }, () => {
      this.showModal();
    });
  }

  // 编辑
  @Bind()
  handleUpdate(record) {
    const { dispatch } = this.props;
    dispatch({
      type: 'todoUser/fetchDetail',
      payload: {
        userId: record.id,
      },
    }).then(res => {
      this.setState({ detailData: res }, () => {
        this.showModal();
      });
    });
  }

  // 保存
  @Bind()
  handleSave(fieldsValue) {
    const {
      dispatch,
      todoUser: { pagination },
    } = this.props;
    const { detailData } = this.state;
    const { id } = detailData;

    dispatch({
      type: `todoUser/${id ? 'updateUser' : 'createUser'}`,
      payload: {
        ...detailData,
        ...fieldsValue,
      },
    }).then(res => {
      if (res) {
        notification.success();
        this.hiddenModal();
        this.handleSearch(pagination);
      }
    });
  }

  /**
   * 数据列表，删除
   * @param {object} record - 操作对象
   */
  @Bind()
  handleDeleteContent(record) {
    const {
      dispatch,
      todoUser: { pagination },
    } = this.props;
    dispatch({
      type: 'todoUser/deleteUser',
      payload: { ...record },
    }).then(res => {
      if (res) {
        notification.success();
        this.handleSearch(pagination);
      }
    });
  }

  /**
   * @function renderForm - 渲染搜索表单
   */
  renderFilterForm() {
    const { getFieldDecorator } = this.props.form;
    return (
      <Form layout="inline">
        <FormItem label={intl.get('todo.user.model.user.name').d('员工姓名')}>
          {getFieldDecorator('employeeName', {})(<Input />)}
        </FormItem>
        <FormItem>
          <Button type="primary" htmlType="submit" onClick={this.handleSearch}>
            {intl.get('hzero.common.button.search').d('查询')}
          </Button>
          <Button style={{ marginLeft: 8 }} onClick={this.handleResetSearch}>
            {intl.get('hzero.common.button.reset').d('重置')}
          </Button>
        </FormItem>
      </Form>
    );
  }

  render() {
    const { dispatch, tenantId, todoUser, createLoading, fetchLoading } = this.props;
    const { userList = [], pagination } = todoUser;
    const { visible, detailData = {} } = this.state;
    const columns = [
      {
        title: intl.get('todo.user.model.employee.name').d('员工名称'),
        dataIndex: 'employeeName',
        width: 150,
      },
      {
        title: intl.get('todo.user.model.employee.number').d('员工编码'),
        dataIndex: 'employeeNumber',
        width: 150,
      },
      {
        title: intl.get('todo.user.model.employee.email').d('电子邮件'),
        dataIndex: 'email',
        width: 200,
      },
      {
        title: intl.get('hzero.common.button.action').d('操作'),
        key: 'operation',
        width: 60,
        render: (text, record) => {
          return (
            <span className="action-link">
              <a onClick={() => this.handleUpdate(record)}>
                {intl.get('hzero.common.button.edit').d('编辑')}
              </a>
              <Popconfirm
                placement="topRight"
                title={intl.get('hzero.common.message.confirm.delete').d('是否删除此条记录')}
                onConfirm={() => this.handleDeleteContent(record)}
              >
                <a>{intl.get('hzero.common.button.delete').d('删除')}</a>
              </Popconfirm>
            </span>
          );
        },
      },
    ];
    const title = detailData.id
      ? intl.get('hzero.common.button.edit').d('编辑')
      : intl.get('hzero.common.button.create').d('新建');

    const drawerProps = {
      dispatch,
      tenantId,
      title,
      visible,
      loading: createLoading,
      initData: detailData,
      onCancel: this.hiddenModal,
      onOk: this.handleSave,
    };
    return (
      <React.Fragment>
        <Header title={intl.get('todo.user.view.message.title.list').d('用户')}>
          <Button icon="plus" type="primary" onClick={this.handleAdd}>
            {intl.get('hzero.common.button.create').d('新建')}
          </Button>
        </Header>
        <Content>
          <div className="table-list-search">{this.renderFilterForm()}</div>
          <Table
            bordered
            rowKey="id"
            loading={fetchLoading}
            dataSource={userList}
            columns={columns}
            scroll={{ x: tableScrollWidth(columns, 400) }}
            pagination={pagination}
            onChange={this.handleSearch}
          />
          {visible && <Drawer {...drawerProps} />}
        </Content>
      </React.Fragment>
    );
  }
}
