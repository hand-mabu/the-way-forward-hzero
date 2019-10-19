// main.js

import React from 'react';
// import "antd/dist/antd.css";

import Table1 from './Table1';
import Table2 from './Table2';
import TableNested from './TableNested';

// @formatterCollections({ code: ['demo.page1'] })
export default class Page1 extends React.Component {
  render() {
    return (
      <React.Fragment>
        <div id="divTable1">
          <Table1 />
        </div>
        <div id="divTable2">
          <Table2 />
        </div>
        <div id="divTableNested">
          <TableNested />
        </div>
      </React.Fragment>
    );
  }
}
