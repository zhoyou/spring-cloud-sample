# spring-cloud-sample

基于Finchley版本的Spring Cloud示例。

## 模块说明

|模块名|类型|说明|端口|
|---|---|---|---|
|consul-agent|基础组件|consul服务治理中心|8500|
|zipkin-server|基础组件|zipkin链路追踪服务|9411|
|eureka-server|基础组件|eureka服务治理中心|21100|
|config-server|基础组件|配置中心服务|21000|
|gateway-server|基础组件|网关服务|20000|
|admin-server|基础组件|监控服务|21200|
|auth-server|基础组件|OAuth2认证授权服务|22000|
|service-shop|微服务|店铺服务|20100|
|service-order|微服务|订单服务|20200|
|shop-server|资源服务|店铺资源服务|23100|
|shop-client|客户端|店铺客户端|24100|