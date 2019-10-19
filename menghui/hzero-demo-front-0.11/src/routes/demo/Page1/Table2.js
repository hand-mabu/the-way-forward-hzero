import React, { Component } from 'react';
import { Table } from 'hzero-ui';
// import {Table} from "antd";
// import "antd/dist/antd.css";

const temp = {}; // 当前重复的值,支持多列
const mergeCells = (text, array, columns) => {
  let i = 0;
  if (text !== temp[columns]) {
    temp[columns] = text;
    array.forEach(items => {
      for (const item in items) {
        if (item === columns) {
          if (items[item] === temp[columns]) {
            i += 1;
          }
        }
      }
    });
  }
  return i;
};
const data = [
  {
    key: '1',
    item: 'Item1',
    uom: 'Ea',
    inventory: 'FC1',
    workOrder: 'W01',
    address: 'New York No. 1 Lake Park',
  },
  {
    key: '2',
    item: 'Item1',
    uom: 'Ea',
    inventory: 'FC1',
    workOrder: 'W02',
    address: 'London No. 1 Lake Park',
  },
  {
    key: '3',
    item: 'Item1',
    uom: 'Ea',
    inventory: 'FC1',
    workOrder: 'W03',
    address: 'Sidney No. 1 Lake Park',
  },
  {
    key: '4',
    item: 'Item1',
    uom: 'Ea',
    inventory: 'FC1',
    workOrder: 'W04',
    address: 'London No. 2 Lake Park',
  },
  {
    key: '5',
    item: 'Item2',
    inventory: 'FC1',
    uom: 'Ea',
    workOrder: 'W05',
    address: 'New York No. 1 Lake Park',
  },
  {
    key: '6',
    item: 'Item2',
    uom: 'Ea',
    inventory: 'FC1',
    workOrder: 'W06',
    address: 'London No. 1 Lake Park',
  },
  {
    key: '7',
    item: 'Item2',
    uom: 'Ea',
    inventory: 'FC1',
    workOrder: 'W07',
    address: 'Sidney No. 1 Lake Park',
  },
  {
    key: '8',
    item: 'Item2',
    uom: 'Ea',
    inventory: 'FC1',
    workOrder: 'W08',
    address: 'London No. 2 Lake Park',
  },
];

const columns = [
  {
    title: 'Inventory',
    dataIndex: 'inventory',
    render: (text, row /* , index */) => {
      const obj = {
        children: text,
        props: {},
      };
      obj.props.rowSpan = mergeCells(row.inventory, data, 'inventory');
      return obj;
    },
  },
  {
    title: 'Item',
    dataIndex: 'item',
    render: (text, row /* , index */) => {
      const obj = {
        children: text,
        props: {},
      };
      obj.props.rowSpan = mergeCells(row.item, data, 'item');
      return obj;
    },
  },
  {
    title: 'Uom',
    dataIndex: 'uom',
    render: (text, row /* , index */) => {
      const obj = {
        children: text,
        props: {},
      };
      obj.props.rowSpan = mergeCells(row.uom, data, 'uom');
      return obj;
    },
  },
  {
    title: 'WorkOrder',
    dataIndex: 'workOrder',
  },
  {
    title: 'Address',
    dataIndex: 'address',
  },
];
export default class Table2 extends Component {
  render() {
    return <Table columns={columns} dataSource={data} bordered />;
  }
}
