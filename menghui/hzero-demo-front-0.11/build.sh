#!/usr/bin/env bash

# Skip resolving dependency of PUPPETEER
export PUPPETEER_SKIP_CHROMIUM_DOWNLOAD=1

# OP or SAAS
readonly BUILD_PLATFORM_VERSION="SAAS"
readonly BUILD_CLIENT_ID="hzero-front-dev"
readonly BUILD_API_HOST="http://haasgz.hand-china.com:34988"
readonly BUILD_BPM_HOST="$BUILD_API_HOST/hwfe"
readonly BUILD_WFP_EDITOR="$BUILD_API_HOST/hwfp"
readonly BUILD_WEBSOCKET_HOST="ws://haasgz.hand-china.com:34982"

yarn bootstrap
yarn build:dll
yarn build

if [[ -d "dist" ]]; then
    echo "Substituting placeholders ..."
    find dist -name '*.js' | xargs sed -i "s BUILD_API_HOST $BUILD_API_HOST g"
    find dist -name '*.js' | xargs sed -i "s BUILD_CLIENT_ID $BUILD_CLIENT_ID g"
    find dist -name '*.js' | xargs sed -i "s BUILD_BPM_HOST $BUILD_BPM_HOST g"
    find dist -name '*.js' | xargs sed -i "s BUILD_WFP_EDITOR $BUILD_WFP_EDITOR g"
    find dist -name '*.js' | xargs sed -i "s BUILD_WEBSOCKET_HOST $BUILD_WEBSOCKET_HOST g"
fi

if [[ -d dist ]]; then
	tar zcvf dist.tar.gz dist/
fi
