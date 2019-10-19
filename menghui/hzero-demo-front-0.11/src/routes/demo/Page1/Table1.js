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

const dataTitle = [
  {
    key: '1',
    date1: '2019/04/22',
    date2: '2019/04/23',
    date3: '2019/04/24',
    date4: '2019/04/25',
    date5: '2019/04/26',
    date6: '2019/04/29',
    date7: '2019/04/30',
    date8: '2019/05/01',
    date9: '2019/05/02',
    date10: '2019/05/03',
  },
];

const data = [
  {
    key: '1',
    inventory: 'FC1',
    item: 'Item1',
    workOrder: 'Total Capacity',
    date1: '100',
    date2: '100',
    date3: '100',
    date4: '100',
    date5: '100',
    date6: '120',
    date7: '120',
    date8: '120',
    date9: '120',
    date10: '120',
  },
  {
    key: '2',
    inventory: 'FC1',
    item: 'Item1',
    workOrder: 'Used Capacity',
    date1: '80',
    date2: '78',
    date3: '90',
    date4: '95',
    date5: '105',
    date6: '100',
    date7: '100',
    date8: '100',
    date9: '105',
    date10: '105',
  },
  {
    key: '3',
    inventory: 'FC1',
    item: 'Item1',
    workOrder: 'Scheduled Qty',
    date1: '0',
    date2: '0',
    date3: '0',
    date4: '0',
    date5: '0',
    date6: '0',
    date7: '0',
    date8: '0',
    date9: '0',
    date10: '0',
  },
  {
    key: '4',
    inventory: 'FC1',
    item: 'Item1',
    workOrder: 'Available Capacity',
    date1: '20',
    date2: '22',
    date3: '10',
    date4: '5',
    date5: '-5',
    date6: '20',
    date7: '20',
    date8: '20',
    date9: '15',
    date10: '15',
  },
  {
    key: '5',
    inventory: 'FC1',
    item: 'Item1',
    workOrder: 'Used Percentage',
    date1: '80%',
    date2: '78%',
    date3: '90%',
    date4: '95%',
    date5: '105%',
    date6: '83%',
    date7: '83%',
    date8: '83%',
    date9: '88%',
    date10: '88%',
  },
  {
    key: '6',
    inventory: 'FC1',
    item: 'Item2',
    workOrder: 'Total Capacity',
    date1: '',
    date2: '',
    date3: '',
    date4: '',
    date5: '',
    date6: '',
    date7: '',
    date8: '',
    date9: '',
    date10: '',
  },
  {
    key: '7',
    inventory: 'FC1',
    item: 'Item2',
    workOrder: 'Used Capacity',
    date1: '',
    date2: '',
    date3: '',
    date4: '',
    date5: '',
    date6: '',
    date7: '',
    date8: '',
    date9: '',
    date10: '',
  },
  {
    key: '8',
    inventory: 'FC1',
    item: 'Item2',
    workOrder: 'Scheduled Qty',
    date1: '',
    date2: '',
    date3: '',
    date4: '',
    date5: '',
    date6: '',
    date7: '',
    date8: '',
    date9: '',
    date10: '',
  },
  {
    key: '9',
    inventory: 'FC1',
    item: 'Item2',
    workOrder: 'Available Capacity',
    date1: '',
    date2: '',
    date3: '',
    date4: '',
    date5: '',
    date6: '',
    date7: '',
    date8: '',
    date9: '',
    date10: '',
  },
  {
    key: '10',
    inventory: 'FC1',
    item: 'Item2',
    workOrder: 'Used Percentage',
    date1: '',
    date2: '',
    date3: '',
    date4: '',
    date5: '',
    date6: '',
    date7: '',
    date8: '',
    date9: '',
    date10: '',
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
    title: 'WorkOrder',
    dataIndex: 'workOrder',
  },
  {
    title: dataTitle[0].date1,
    children: [
      {
        title: dataTitle[0].date1,
        dataIndex: 'date1',
      },
      {
        title: dataTitle[0].date2,
        dataIndex: 'date2',
      },
      {
        title: dataTitle[0].date3,
        dataIndex: 'date3',
      },
      {
        title: dataTitle[0].date4,
        dataIndex: 'date4',
      },
      {
        title: dataTitle[0].date5,
        dataIndex: 'date5',
      },
    ],
  },
  {
    title: dataTitle[0].date6,
    children: [
      {
        title: dataTitle[0].date6,
        dataIndex: 'date6',
      },
      {
        title: dataTitle[0].date7,
        dataIndex: 'date7',
      },
      {
        title: dataTitle[0].date8,
        dataIndex: 'date8',
      },
      {
        title: dataTitle[0].date9,
        dataIndex: 'date9',
      },
      {
        title: dataTitle[0].date10,
        dataIndex: 'date10',
      },
    ],
  },
];
export default class Table1 extends Component {
  render() {
    return <Table columns={columns} dataSource={data} bordered />;
  }
}
