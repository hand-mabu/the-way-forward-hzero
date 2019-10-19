HZERO 前端演示项目
===
## 概述

本项目是HZERO前端演示项目，使用 [hzero-front-cli](https://code.choerodon.com.cn/hzero-hzero/hzero-front-cli) 工具进行生成。



## 变更历史

| 版本      | 作者   | 时间       | 变更日志                  |
| --------- | ------ | ---------- | ------------------------- |
| `v0.11.0` | 刘洪玉 | 2019-08-14 | 升级至 `0.11` 前端        |
| `v0.3.0`  | 刘洪玉 | 2019-07-18 | 修复所有页面报 404 的错误 |
| `v0.2.0`  | 刘洪玉 | 2019-06-21 | 适配 0.9 版本             |
| `v0.1.0`  | 刘洪玉 | 2019-05-10 | 初版                      |



## 使用方法

### 克隆项目

```bash
git clone -b 0.11 https://code.choerodon.com.cn/2062/hzero-demo-front.git
```

### 编译打包

本项目默认配置连接广州开发中心部署的后端服务，基于 [hzero-demo-backend](https://code.choerodon.com.cn/2062/hzero-demo-backend.git) 进行构建。如果需要另行配置，按照不同的情况进行以下调整：

> **☞ 注意**
>
> 从 0.9 版开始，启动的环境变量不再在 `package.json` 里面维护，每一个 profile ( 如 start, buid, test 等等 ) 会单独有一个环境变量文件，文件名规则为： `config/compile{Profile}Env.js` 

#### 1. npm start

编辑 `package.json` 并对 `start` 命令为如下形式：

```
"start": "node --max_old_space_size=8196 scripts/start.js",
```

编辑 `config/compileStartEnv.js` 文件配置环境变量，几个关键的变量说明如下：

| 环境变量         | 含义                              | 默认值                           |
| ---------------- | --------------------------------- | -------------------------------- |
| BASE_PATH        | Web 应用的根路径                  | /                                |
| PLATFORM_VERSION | 平台版本：`OP` 或者 `SAAS`        | `SAAS`                           |
| CLIENT_ID        | OAuth 客户端 ID (`oauth_client`)  | `localhost`                      |
| BPM_HOST         | 工作流编辑器地址                  | http://192.168.123.149:8080/hwfe |
| WFP_EDITOR       | 新版工作流 workflow-plus 服务地址 | http://192.168.123.149:8080/hwfp |
| API_HOST         | API Gateway 地址                  | http://192.168.123.149:8080      |
| WEBSOCKET_HOST   | Websocket (hzero-message) 地址    | ws://192.168.123.149:8120        |

最后修改完成的效果如下所示：

```json
module.exports = {
  BASE_PATH: `${process.env.BASE_PATH || '/'}`,
  PLATFORM_VERSION: `${process.env.PLATFORM_VERSION || 'SAAS'}`,
  CLIENT_ID: `${process.env.CLIENT_ID || 'localhost'}`,
  BPM_HOST: `${process.env.API_HOST || 'http://192.168.123.149:8080'}/hwfe`,
  WFP_EDITOR: `${process.env.API_HOST || 'http://192.168.123.149:8080'}/hwfp`,
  API_HOST: `${process.env.API_HOST || 'http://192.168.123.149:8080'}`,
  WEBSOCKET_HOST: `${process.env.WEBSOCKET_HOST || 'ws://192.168.123.149:8120'}`,
  ...
}
```

最后执行一下命令启动：

```bas
yarn bootstrap
yarn build:dll
yarn start
```

#### 2. yarn build

编辑 `package.json` 并对 `start` 命令为如下形式：

```
"build": "npm run lint:fix && node --max_old_space_size=4196 scripts/build.js",
```

编辑 `build.sh` 文件中的参数，参数定义部分如下：

```bash
...
readonly BUILD_PLATFORM_VERSION="SAAS"
readonly BUILD_CLIENT_ID="hzero-front-dev"
readonly BUILD_API_HOST="http://192.168.123.149:8080"
readonly BUILD_BPM_HOST="$BUILD_API_HOST/hwfe"
readonly BUILD_WFP_EDITOR="$BUILD_API_HOST/hwfp"
readonly BUILD_WEBSOCKET_HOST="ws://192.168.123.149:8120"
...
```

请注意你的前端访问地址要和 `oauth_client` 表中的对应客户端 `hzero-front-dev` 的转向地址保持一致。

最后执行打包命令：

```bash
./build.sh
```

成功之后会在项目目录下生成编译后的HTML目录 `dist`，后续用户可以使用 Nginx 反向代理到此目录进行访问。