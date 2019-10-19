module.exports = [
  {
    path: "/demo/page1",
    component: "demo/Page1",
    models: [],
  },
  {
    path: "/demo/page2",
    component: "demo/Page2",
    models: [],
  },
  {
    path: "/todo/user",
    component: "todo/User",
    models: [
      "todo/todoUser",
    ],
  },
  {
    path: "/todo/task",
    component: "todo/Task",
    models: [
      "todo/task",
    ],
  },
  // 客户端
  {
    path: "/hiam/goods",  // 路由
    component: "Goods",  // 页面组件
    authorized: true,  // 未配置菜单时，配置权限得以访问页面。在完成开发后删除此属性。
    models: [  // model数据模型
      // "goods",
    ],
  },
];
