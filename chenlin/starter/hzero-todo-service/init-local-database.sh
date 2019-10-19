#!/bin/bash
version="0.10.0.RELEASE"
mkdir -p tool-jar
if [ ! -f bin/choerodon-tool-liquibase.jar ]
then
    curl https://oss.sonatype.org/content/groups/public/io/choerodon/choerodon-tool-liquibase/${version}/choerodon-tool-liquibase-${version}.jar -o ./tool-jar/choerodon-tool-liquibase.jar
fi
java -Dspring.datasource.url="jdbc:mysql://db.hzero.org:3306/todo_service?useUnicode=true&characterEncoding=utf-8&useSSL=false" \
 -Dspring.datasource.username=hzero \
 -Dspring.datasource.password=hzero \
 -Ddata.drop=false -Ddata.init=true \
 -Ddata.dir=./src/main/resources \
 -jar ./tool-jar/choerodon-tool-liquibase.jar