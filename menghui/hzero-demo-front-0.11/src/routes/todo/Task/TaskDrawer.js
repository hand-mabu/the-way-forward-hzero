import React, { PureComponent } from 'react';
import ValueList from 'components/ValueList';
import Lov from 'components/Lov';
import { Form, Modal, Input, Row, Col } from 'hzero-ui';
import { Bind } from 'lodash-decorators';

import intl from 'utils/intl';

const FormItem = Form.Item;

@Form.create({ fieldNameProp: null })
export default class Drawer extends PureComponent {
  componentDidMount() {}

  @Bind()
  onOk() {
    const { onOk, form } = this.props;
    form.validateFields((error, fieldsValue) => {
      if (!error) {
        onOk(fieldsValue);
      }
    });
  }

  render() {
    const { form, initData = {}, title, visible, onCancel, loading } = this.props;
    const { getFieldDecorator } = form;
    const formLayout = {
      labelCol: { span: 6 },
      wrapperCol: { span: 16 },
    };
    return (
      <Modal
        width={1000}
        title={title}
        visible={visible}
        wrapClassName="ant-modal-sidebar-right"
        transitionName="move-right"
        onOk={this.onOk}
        onCancel={onCancel}
        confirmLoading={loading}
        destroyOnClose
      >
        <Form>
          <Row gutter={24} type="flex">
            <Col span={24}>
              <FormItem
                {...formLayout}
                label={intl.get('todo.task.model.task.taskNumber').d('任务编号')}
              >
                {getFieldDecorator('taskNumber', {
                  initialValue: initData.taskNumber,
                  rules: [
                    {
                      required: true,
                      message: intl.get('hzero.common.validation.notNull', {
                        name: intl.get('todo.task.model.task.taskNumber').d('任务编号'),
                      }),
                    },
                  ],
                  validateTrigger: 'onBlur',
                })(<Input />)}
              </FormItem>
            </Col>

            <Col span={24}>
              <FormItem {...formLayout} label={intl.get('todo.task.model.task.state').d('状态')}>
                {getFieldDecorator('state', {
                  initialValue: initData.state,
                  rules: [
                    {
                      required: true,
                      message: intl.get('hzero.common.validation.notNull', {
                        name: intl.get('todo.task.model.task.state').d('状态'),
                      }),
                    },
                  ],
                  validateTrigger: 'onBlur',
                })(
                  <ValueList
                    options={[
                      {
                        value: 'Y',
                        meaning: '有效',
                      },
                      {
                        value: 'N',
                        meaning: '无效',
                      },
                    ]}
                  />
                )}
              </FormItem>
            </Col>
            <Col span={24}>
              <FormItem
                {...formLayout}
                label={intl.get('todo.task.model.task.taskDescription').d('任务描述')}
              >
                {getFieldDecorator('taskDescription', {
                  initialValue: initData.taskDescription,
                  // rules: []
                })(<Input />)}
              </FormItem>
            </Col>
            <Col span={24}>
              <FormItem
                {...formLayout}
                label={intl.get('todo.task.model.task.employeeId').d('用户')}
              >
                {getFieldDecorator('employeeId', {
                  initialValue: initData.employeeId,
                  rules: [
                    {
                      required: true,
                      message: intl.get('hzero.common.validation.notNull', {
                        name: intl.get('todo.task.model.task.employeeId').d('用户'),
                      }),
                    },
                  ],
                })(
                  <Lov
                    code="TODO.USER_INFO"
                    textValue={initData.employeeName}
                    textField="employeeName"
                  />
                )}
              </FormItem>
            </Col>
          </Row>
        </Form>
      </Modal>
    );
  }
}
