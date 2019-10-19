import React from 'react';
import './style.less';
import { Table, Row, Col, Input, Button, Popconfirm, Form, Select, DatePicker } from 'hzero-ui';

import EditableCell from './EditableCell';

const { Option } = Select;
const EditableContext = React.createContext();

function handleChange(value) {
  console.log(`selected ${value}`);
}
const dateFormat = 'YYYY/MM/DD';
const EditableRow = ({ form, index, ...props }) => (
  <EditableContext.Provider value={form}>
    <tr {...props} />
  </EditableContext.Provider>
);

const EditableFormRow = Form.create()(EditableRow);

export default class EditableTable extends React.Component {
  constructor(props) {
    super(props);
    this.columns = [
      {
        title: 'Return Number',
        dataIndex: 'returnNumber',
      },
      {
        title: 'Return Date',
        dataIndex: 'returnDate',
        editable: true,
      },
      {
        title: 'Customer',
        dataIndex: 'customer',
        editable: true,
      },
      {
        title: 'Delivery Address',
        dataIndex: 'address',
      },
      {
        title: 'Bottle Item',
        dataIndex: 'bottleItem',
      },
      {
        title: 'Return Quantity',
        dataIndex: 'returnQuantity',
        editable: true,
      },
      {
        title: 'Serial No From',
        dataIndex: 'serialNoFrom',
      },
      {
        title: 'Serial No To',
        dataIndex: 'serialNoTo',
      },
      {
        title: 'Sync Flag',
        dataIndex: 'syncFlag',
      },
      {
        title: 'operation',
        dataIndex: 'operation',
        render: (text, record) =>
          this.state.dataSource.length >= 1 ? (
            <Popconfirm title="Sure to delete?" onConfirm={() => this.handleDelete(record.key)}>
              <a>Delete</a>
            </Popconfirm>
          ) : null,
      },
    ];

    this.state = {
      dataSource: [
        {
          key: '0',
          returnNumber: 'RT20180423000',
          returnDate: '2019-03-20',
          customer: 'xxx',
          bottleItem: 'BOTS0134',
          returnQuantity: '15',
          serialNoFrom: 'S20190101',
          serialNoTo: 'S20190115',
          syncFlag: 'Y',
          address: 'Building,Street,City',
        },
        {
          key: '1',
          returnNumber: 'RT20180423001',
          returnDate: '2019-06-04',
          customer: 'xxx',
          bottleItem: 'BOTS0126',
          returnQuantity: '40',
          serialNoFrom: 'S20190101',
          serialNoTo: 'S20190115',
          syncFlag: 'N',
          address: 'Building,Street,City',
        },
        {
          key: '2',
          returnNumber: 'RT20180423002',
          returnDate: '2019-04-20',
          customer: 'xxx',
          bottleItem: 'BOTS0120',
          returnQuantity: '6',
          serialNoFrom: 'S20180321',
          serialNoTo: 'S20180326',
          syncFlag: 'N',
          address: 'Building,Street,City',
        },
      ],
      count: 3,
      selectedRowKeys: [],
    };
  }

  onSelectChange = selectedRowKeys => {
    console.log('selectedRowKeys changed: ', selectedRowKeys);
    this.setState({ selectedRowKeys });
  };

  handleDelete = key => {
    const dataSource = [...this.state.dataSource];
    this.setState({ dataSource: dataSource.filter(item => item.key !== key) });
  };

  handleAdd = () => {
    const { count, dataSource } = this.state;
    const newData = {
      key: count,
      returnNumber: `RT2018042300${count}`,
      /* returnDate: null, */
      customer: 'xxx',
      bottleItem: `BOTS0126${count}`,
      returnQuantity: '40',
      serialNoFrom: 'S20190101',
      serialNoTo: 'S20190115',
      syncFlag: 'N',
      address: 'Building,Street,City',
    };
    this.setState({
      dataSource: [...dataSource, newData],
      count: count + 1,
      selectedRowKeys: [],
    });
  };

  handleSave = row => {
    const newData = [...this.state.dataSource];
    const index = newData.findIndex(item => row.key === item.key);
    const item = newData[index];
    newData.splice(index, 1, {
      ...item,
      ...row,
    });
    this.setState({ dataSource: newData });
  };

  render() {
    const { dataSource, selectedRowKeys } = this.state;
    const components = {
      body: {
        row: EditableFormRow,
        cell: EditableCell,
      },
    };
    const rowSelection = {
      selectedRowKeys,
      onChange: this.onSelectChange,
    };
    const columns = this.columns.map(col => {
      if (!col.editable) {
        return col;
      }
      return {
        ...col,
        onCell: record => ({
          record,
          editable: col.editable,
          dataIndex: col.dataIndex,
          title: col.title,
          handleSave: this.handleSave,
        }),
      };
    });
    return (
      <div>
        <Form className="ant-advanced-search-form" onSubmit={this.handleSearch}>
          <Row gutter={24}>
            <Col span={8} key={1}>
              <Form.Item label="Return Number">
                <Select defaultValue="RT20180423001" onChange={handleChange}>
                  <Option value="RT20180423001">RT20180423001</Option>
                  <Option value="RT20180423002">RT20180423002</Option>
                  <Option value="RT20180423003">RT20180423003</Option>
                  <Option value="RT0001" disabled>
                    RT0001
                  </Option>
                </Select>
              </Form.Item>
            </Col>
            <Col span={8} key={2}>
              <Form.Item label="Customer">
                <Input placeholder="Customer" />
              </Form.Item>
            </Col>
            <Col span={8} key={3}>
              <Form.Item label="Return Date">
                <DatePicker placeholder="Return Date" format={dateFormat} />
              </Form.Item>
            </Col>
            <Col span={8} key={4}>
              <Form.Item label="Bottle Item">
                <Input placeholder="Bottle Item" />
              </Form.Item>
            </Col>
            <Col span={8} key={5}>
              <Form.Item label="Field5">
                <Input placeholder="Field5" />
              </Form.Item>
            </Col>
            <Col span={8} key={6}>
              <Form.Item label="Field6">
                <Input placeholder="Field6" />
              </Form.Item>
            </Col>
            <Col span={8} key={7} style={{ display: 'none' }}>
              <Form.Item label="Field7">
                <Input placeholder="Field7" />
              </Form.Item>
            </Col>
          </Row>
          <Row>
            <Col span={12} style={{ textAlign: 'left' }}>
              <Button onClick={this.handleAdd} type="primary" style={{ marginBottom: 16 }}>
                Add a row
              </Button>
              <Button style={{ marginLeft: 20 }}>Save</Button>
              <Button style={{ marginLeft: 20, background: 'yellow' }}>Sync</Button>
              <Button type="danger" style={{ marginLeft: 20 }}>
                Delete
              </Button>
            </Col>
            <Col span={12} style={{ textAlign: 'right' }}>
              <Button type="primary" htmlType="submit">
                Search
              </Button>
              <Button style={{ marginLeft: 8 }} onClick={this.handleReset}>
                Clear
              </Button>
            </Col>
          </Row>
        </Form>
        <Table
          rowSelection={{ rowSelection }}
          components={components}
          rowClassName={() => 'editable-row'}
          bordered
          dataSource={dataSource}
          columns={columns}
        />
      </div>
    );
  }
}
