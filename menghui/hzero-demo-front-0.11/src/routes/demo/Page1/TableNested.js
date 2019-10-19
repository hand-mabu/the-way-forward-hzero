import React, { Component } from 'react';
import { Table, Form, Input, Button, Row, Col } from 'hzero-ui';

function NestedTable() {
  const expandedRowRender = (record /* , index, indent, expanded */) => {
    const columns = [
      { title: 'Date', dataIndex: 'date', key: 'date' },
      { title: 'Customer', dataIndex: 'customer', key: 'name' },
      { title: 'Bottle Item', dataIndex: 'bottleItem', key: 'bottleItem' },
      {
        title: 'Transaction Quantity',
        dataIndex: 'transactionQuantity',
        key: 'transactionQuantity',
      },
      { title: 'Value', dataIndex: 'value', key: 'value' },
      { title: 'Transaction Number', dataIndex: 'transactionNumber', key: 'transactionNumber' },
    ];
    const data = [];
    for (let i = 0; i < 3; ++i) {
      data.push({
        key: i,
        date: `2019/01/0${10 + i}`,
        customer: record.customer,
        bottleItem: record.bottleItem,
        transactionQuantity: 10 + i,
        value: `$${10 + i}`,
        transactionNumber: `RT150000${i}`,
      });
    }
    return <Table columns={columns} dataSource={data} pagination={false} />;
  };

  const columns = [
    { title: 'Customer', dataIndex: 'customer', key: 'customer' },
    { title: 'Delivery Address', dataIndex: 'deliveryAddress', key: 'deliveryAddress' },
    { title: 'Bottle Item', dataIndex: 'bottleItem', key: 'bottleItem' },
    { title: 'Quantity Balance', dataIndex: 'quantityBalance', key: 'quantityBalance' },
    { title: 'Value Balance', dataIndex: 'valueBalance', key: 'valueBalance' },
  ];

  const dataHeader = [];
  for (let i = 0; i < 3; ++i) {
    dataHeader.push({
      key: i,
      customer: `XXX${i}`,
      deliveryAddress: 'Building,Street,City',
      bottleItem: `BOTS0${i}`,
      quantityBalance: 10 + i * 2,
      valueBalance: `$${10 + 10 * i}`,
    });
  }

  const handleReset = () => {};

  return (
    <div>
      <Form className="ant-advanced-search-form">
        <Row gutter={24}>
          <Col span={6} key={1}>
            <Form.Item>
              <Input placeholder="Customer" />
            </Form.Item>
          </Col>
          <Col span={6} key={2}>
            <Form.Item>
              <Input placeholder="Delivery Address" />
            </Form.Item>
          </Col>
          <Col span={6} key={3}>
            <Form.Item>
              <Input placeholder="Bottle Item" />
            </Form.Item>
          </Col>
          <Col span={6} key={4}>
            <Button type="primary" htmlType="submit">
              Search
            </Button>
            <Button style={{ marginLeft: 8 }} onClick={handleReset}>
              Clear
            </Button>
          </Col>
        </Row>
      </Form>
      <Table
        className="components-table-demo-nested"
        columns={columns}
        expandedRowRender={expandedRowRender}
        dataSource={dataHeader}
      />
    </div>
  );
}

export default class TableNested extends Component {
  render() {
    return <NestedTable />;
  }
}
