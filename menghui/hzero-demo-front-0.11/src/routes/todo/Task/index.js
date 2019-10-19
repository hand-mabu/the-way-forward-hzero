/**
 * task - 客户端
 * @date: 2018-12-24
 * @author: LZY <zhuyan.luo@hand-china.com>
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
import TaskDrawer from './TaskDrawer';

const FormItem = Form.Item;
@Form.create({ fieldNameProp: null })
@formatterCollections({ code: ['todo.task'] })
/**
 * task - 业务组件 - 客户端
 * @extends {Component} - React.Component
 * @reactProps {!Object} [task={}] - 数据源
 * @reactProps {boolean} [fetchListLoading=false] - 客户端列表信息加载中
 * @reactProps {boolean} [fetchDetailLoading=false] - 详情信息加载中

 * @return React.element
 */
@connect(({ loading, task }) => ({
  task,
  fetchListLoading: loading.effects['task/fetchTaskList'],
  fetchDetailLoading: loading.effects['task/fetchDetail'],
  tenantId: getCurrentOrganizationId(),
}))
export default class Task extends React.Component {
  state = {
    visible: false, // 测试弹窗
    detailData: {}, // 客户端详情数据
  };

  componentDidMount() {
    const { dispatch } = this.props;
    dispatch({
      type: 'task/queryType',
    });
    this.handleSearch();
  }

  /**
   * 查询
   * @param {object} fields - 查询参数
   */
  @Bind()
  handleSearch(fields = {}) {
    const { form, dispatch } = this.props;
    form.validateFields((err, values) => {
      const fieldValues = values || {};
      if (!err) {
        dispatch({
          type: 'task/fetchTaskList',
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
    this.setState({ detailData: '' }, () => {
      this.showModal();
    });
  }

  // 编辑
  @Bind()
  handleUpdate(record) {
    const { dispatch, id } = this.props;
    dispatch({
      type: 'task/fetchDetail',
      payload: {
        id,
        clientId: record.id,
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
      task: { pagination },
    } = this.props;
    const { detailData } = this.state;
    const { id } = detailData;

    dispatch({
      type: `task/${id ? 'updateTask' : 'createTask'}`,
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
   * @param {obejct} record - 操作对象
   */
  @Bind()
  handleDeleteContent(record) {
    const {
      dispatch,
      task: { pagination },
    } = this.props;
    dispatch({
      type: 'task/deleteTask',
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
        <FormItem label={intl.get('todo.task.model.task.taskNumber').d('任务编号')}>
          {getFieldDecorator('taskNumber', {})(<Input />)}
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
    const {
      dispatch,
      tenantId,
      taskNumber,
      taskDescription,
      task,
      createLoading,
      updateLoading,
      fetchLoading,
      loadingDistributeUsers,
      fetchOwnedLoading,
      saveRoleLoading,
    } = this.props;
    const { taskList = [], pagination, typeList = [], paginationRole } = task;
    const { visible, detailData = {} } = this.state;
    const columns = [
      {
        title: intl.get('todo.task.model.task.employeeName').d('用户'),
        dataIndex: 'employeeName',
        width: 300,
      },
      {
        title: intl.get('todo.task.model.task.taskNumber').d('任务编号'),
        dataIndex: 'taskNumber',
        width: 200,
      },
      {
        title: intl.get('todo.task.model.task.state').d('状态'),
        dataIndex: 'state',
        width: 200,
        render: val => {
          let stateText = '';
          switch (val) {
            case 'N':
              stateText = '无效';
              break;
            case 'Y':
              stateText = '有效';
              break;
            default:
              break;
          }
          return <div>{stateText}</div>;
        },
      },
      {
        title: intl.get('todo.task.model.task.taskDescription').d('任务描述'),
        dataIndex: 'taskDescription',
        width: 200,
      },
      {
        title: intl.get('hzero.common.button.action').d('操作'),
        key: 'operation',
        width: 120,
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
      taskNumber,
      taskDescription,
      typeList,
      visible,
      loadingDistributeUsers,
      fetchOwnedLoading,
      saveRoleLoading,
      paginationRole,
      loading: createLoading || updateLoading,
      initData: detailData,
      onCancel: this.hiddenModal,
      onOk: this.handleSave,
    };
    return (
      <React.Fragment>
        <Header title={intl.get('todo.task.view.message.title.list').d('客户端')}>
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
            dataSource={taskList}
            columns={columns}
            scroll={{ x: tableScrollWidth(columns, 400) }}
            pagination={pagination}
            onChange={this.handleSearch}
          />
          {visible && <TaskDrawer {...drawerProps} />}
        </Content>
      </React.Fragment>
    );
  }
}
