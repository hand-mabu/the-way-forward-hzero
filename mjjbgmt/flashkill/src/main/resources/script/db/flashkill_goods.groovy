package script.db

databaseChangeLog(logicalFilePath: 'script/db/flashkill_goods.groovy') {
    changeSet(author: "mengtao.yan@hand-chian.com", id: "2019-10-12-flashkill_goods") {
        def weight = 1
        if(helper.isSqlServer()){
            weight = 2
        } else if(helper.isOracle()){
            weight = 3
        }
        if(helper.dbType().isSupportSequence()){
            createSequence(sequenceName: 'flashkill_goods_s', startValue:"1")
        }
        createTable(tableName: "flashkill_goods", remarks: "") {
            column(name: "ID", type: "bigint(20) unsigned", autoIncrement: true ,   remarks: "")  {constraints(primaryKey: true)} 
            column(name: "GOODS_NAME", type: "varchar(" + 32 * weight + ")",  remarks: "商品名")  {constraints(nullable:"false")}  
            column(name: "INVENTORY", type: "bigint(32)",  remarks: "库存")  {constraints(nullable:"false")}  
            column(name: "START_TIME", type: "datetime",  remarks: "开始秒杀时间")   
            column(name: "COUNTDOWN_TIME", type: "bigint(20)",  remarks: "倒计时时间(ms)")   
            column(name: "IMG_ADRESS", type: "varchar(" + 255 * weight + ")",  remarks: "图片地址")  {constraints(nullable:"false")}  
            column(name: "CREATED_BY", type: "bigint(20)",   defaultValue:"-1",   remarks: "")   
            column(name: "CREATION_DATE", type: "datetime",   defaultValueComputed:"CURRENT_TIMESTAMP",   remarks: "")   
            column(name: "LAST_UPDATED_BY", type: "bigint(20)",   defaultValue:"-1",   remarks: "")   
            column(name: "LAST_UPDATE_DATE", type: "datetime",   defaultValueComputed:"CURRENT_TIMESTAMP",   remarks: "")   

        }

    }
}