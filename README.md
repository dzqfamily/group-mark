### 开发原因
> 在北京这大城市经常跟别人合伙花钱吃喝,所以想开发一个app自己用,顺便学习小程序（从Android改成小程序）

### 测试环境需补齐配置文件
    小程序配置文件miniprogram.properties
    appid=
    appSecret=
    JJWT加密配置password.properties
    signingKey=

### 测试环境运行

tomcat:run -Pdev

### 生产环境打包

clean package -Pproduct 需按照测试环境补齐配置文件


### todo list
1. request校验
2. ~~创建团，团员，明细增加上限~~ 
3. ~~明细增加上限~~
3. ~~明细只有状态0才能修改~~
4. ~~无结算明细报错~~
6. ~~明细和团增加版本~~
7. ~~只有创建人才能作废团和团员和明细~~
8. ~~增加空指针报错~~
9. ~~返回值增加明细团修改的按钮权限~~
10. ~~查询权限只能是本团~~
    1. ~~修改创建明细/create~~
    2. ~~明细列表/detailList~~
    3. ~~明细信息/detailInfo~~
    4. ~~团增加团员/addGroupMember~~
    5. ~~修改团名/modifyGroupName~~
    6. ~~获取团信息/groupInfo~~
    7. ~~修改团员名称/modifyGroupMemberName~~
    8. ~~删除团员/deleteMember~~
    9. ~~结算计算/doSet~~
    10. ~~结算明细/setDetail~~
    11. ~~结算列表/settleList~~
    12. ~~结算信息/settleInfo~~
