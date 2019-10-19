// main.js

import React from 'react';

import EditableTable from './EditableTable';

export default class Page2 extends React.Component {
  render() {
    return (
      <React.Fragment>
        <div id="TableEdite">
          <EditableTable />
        </div>
      </React.Fragment>
    );
  }
}
