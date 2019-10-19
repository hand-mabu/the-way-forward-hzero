import React, { PureComponent } from 'react';
import { Form, Modal, Input, Row, Col } from 'hzero-ui';
import { Bind } from 'lodash-decorators';
// import { isUndefined } from 'lodash';

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
    // const updateFlag = !isUndefined(initData.id);
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
                label={intl.get('todo.user.model.employee.name').d('员工姓名')}
              >
                {getFieldDecorator('employeeName', {
                  initialValue: initData.employeeName,
                  rules: [
                    {
                      required: true,
                      message: intl.get('hzero.common.validation.notNull', {
                        name: intl.get('todo.user.model.employee.name').d('员工姓名'),
                      }),
                    },
                  ],
                  validateTrigger: 'onBlur',
                })(<Input />)}
              </FormItem>
            </Col>
            <Col span={24}>
              <FormItem
                {...formLayout}
                label={intl.get('todo.user.model.employee.number').d('员工编号')}
              >
                {getFieldDecorator('employeeNumber', {
                  initialValue: initData.employeeNumber,
                  // rules: []
                })(<Input />)}
              </FormItem>
            </Col>
            <Col span={24}>
              <FormItem
                {...formLayout}
                label={intl.get('todo.user.model.employee.number').d('Email')}
              >
                {getFieldDecorator('email', {
                  initialValue: initData.email,
                  rules: [
                    {
                      pattern: /^([a-zA-Z0-9_\-.])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/,
                      message: intl.get('hzero.common.validation.notNull', {
                        name: intl.get('todo.user.model.employee.email').d('电子邮件格式不正确'),
                      }),
                    },
                  ],
                })(<Input />)}
              </FormItem>
            </Col>
          </Row>
        </Form>
      </Modal>
    );
  }
}
