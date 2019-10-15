package script.db

databaseChangeLog(logicalFilePath: 'script/db/flashkill_order.groovy') {
    changeSet(author: "mengtao.yan@hand-chian.com", id: "2019-10-14-flashkill_order") {
        def weight = 1
        if(helper.isSqlServer()){
            weight = 2
        } else if(helper.isOracle()){
            weight = 3
        }
        if(helper.dbType().isSupportSequence()){
            createSequence(sequenceName: 'flashkill_order_s', startValue:"1")
        }
        createTable(tableName: "flashkill_order", remarks: "") {
            column(name: "ID", type: "bigint(255) unsigned", autoIncrement: true ,   remarks: "")  {constraints(primaryKey: true)} 
            column(name: "USER_ID", type: "bigint(20)",  remarks: "用户id")  {constraints(nullable:"false")}  
            column(name: "GOODS_ID", type: "bigint(20)",  remarks: "商品id")  {constraints(nullable:"false")}  
            column(name: "pay", type: "varchar(" + 2 * weight + ")",   defaultValue:"N",   remarks: "是否付款 Y:是 N:否")   
            column(name: "CREATED_BY", type: "bigint(20)",   defaultValue:"-1",   remarks: "")   
            column(name: "CREATION_DATE", type: "datetime",   defaultValueComputed:"CURRENT_TIMESTAMP",   remarks: "")   
            column(name: "LAST_UPDATED_BY", type: "bigint(20)",   defaultValue:"-1",   remarks: "")   
            column(name: "LAST_UPDATE_DATE", type: "datetime",   defaultValueComputed:"CURRENT_TIMESTAMP",   remarks: "")   
            column(name: "OBJECT_VERSION_NUMBER", type: "bigint(20)",  remarks: "")   

        }

    }
}