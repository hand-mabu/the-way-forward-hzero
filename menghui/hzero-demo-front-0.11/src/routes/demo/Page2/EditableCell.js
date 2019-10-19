import React from 'react';
import './style.less';
import { Input, Form, DatePicker, InputNumber } from 'hzero-ui';

import moment from 'moment';

const FormItem = Form.Item;
const EditableContext = React.createContext();

export default class EditableCell extends React.Component {
  state = {
    editing: false,
  };

  toggleEdit = () => {
    const editing = !this.state.editing;
    this.setState({ editing }, () => {
      if (editing) {
        this.input.focus();
      }
    });
  };

  save = e => {
    const { record, handleSave } = this.props;
    this.form.validateFields((error, values) => {
      if (error && error[e.currentTarget.id]) {
        return;
      }
      this.toggleEdit();
      handleSave({ ...record, ...values });
    });
  };

  render() {
    const { editing } = this.state;
    const { editable, dataIndex, title, record, index, handleSave, ...restProps } = this.props;
    return (
      <td {...restProps}>
        {editable ? (
          <EditableContext.Consumer>
            {form => {
              this.form = form;
              if (dataIndex === 'returnDate') {
                return editing ? (
                  <FormItem style={{ margin: 0 }}>
                    {form.getFieldDecorator(dataIndex, {
                      rules: [
                        {
                          required: true,
                          message: `${title} is required.`,
                        },
                      ],
                      initialValue: moment(record[dataIndex]),
                    })(
                      <DatePicker
                        ref={node => {
                          this.input = node;
                        }}
                      />
                    )}
                  </FormItem>
                ) : (
                  <div
                    className="editable-cell-value-wrap"
                    style={{ paddingRight: 24 }}
                    onClick={this.toggleEdit}
                  >
                    {restProps.children}
                  </div>
                );
              } else if (dataIndex === 'returnQuantity') {
                return editing ? (
                  <FormItem style={{ margin: 0 }}>
                    {form.getFieldDecorator(dataIndex, {
                      rules: [
                        {
                          required: true,
                          message: `${title} is required.`,
                        },
                      ],
                      initialValue: record[dataIndex],
                    })(
                      <InputNumber
                        ref={node => {
                          this.input = node;
                        }}
                        onPressEnter={this.save}
                        onBlur={this.save}
                      />
                    )}
                  </FormItem>
                ) : (
                  <div
                    className="editable-cell-value-wrap"
                    style={{ paddingRight: 24 }}
                    onClick={this.toggleEdit}
                  >
                    {restProps.children}
                  </div>
                );
              } else {
                return editing ? (
                  <FormItem style={{ margin: 0 }}>
                    {form.getFieldDecorator(dataIndex, {
                      rules: [
                        {
                          required: true,
                          message: `${title} is required.`,
                        },
                      ],
                      initialValue: record[dataIndex],
                    })(
                      <Input
                        ref={node => {
                          this.input = node;
                        }}
                        onPressEnter={this.save}
                        onBlur={this.save}
                      />
                    )}
                  </FormItem>
                ) : (
                  <div
                    className="editable-cell-value-wrap"
                    style={{ paddingRight: 24 }}
                    onClick={this.toggleEdit}
                  >
                    {restProps.children}
                  </div>
                );
              }
            }}
          </EditableContext.Consumer>
        ) : (
          restProps.children
        )}
      </td>
    );
  }
}
