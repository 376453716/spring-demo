#### IOC container
##### ioc
1.依赖注入/控制反转
对象通过构造函数工厂方法创建，在创建时会存在依赖，由容器在创建bean时注入这些依赖。将依赖的控制交给容器，而不是由程序直接创建依赖。
##### beans
bean是spring容器管理的对象，bean及其依赖关系通过配置元数据管理（xml、注解、代码）
##### Container
1. 负责实例化、配置和组装bean
2. 读取配置元数据获取关于要实例化、配置和组装哪些对象的指令。配置元数据用XML、Java注释或Java代码表示。
3. 业务对象+配置元数据--->容器bean，应用
###### config
1. Configuration Metadata
xml/annotation/java code
2. Instantiating a Container
```$java
ApplicationContext context = new ClassPathXmlApplicationContext("services.xml", "daos.xml");
```
import config
```$xslt
<beans>
    <import resource="services.xml"/>
    <import resource="resources/messageSource.xml"/>
    <import resource="/resources/themeSource.xml"/>
    <bean id="bean1" class="..."/>
    <bean id="bean2" class="..."/>
</beans>
```
###### use container
1. getBean
2. refresh
3. 避免调用，通过自动注入从而不依赖spring api
#### Bean
1. Spring IoC容器管理一个或多个bean。这些bean是使用提供给容器的配置元数据创建的。
2.  在容器本身中，这些bean定义表示为BeanDefinition对象，其中包含(其他信息)以下元数据
a. A package-qualified class name
b. Bean行为配置元素(范围、生命周期回调)
c. 对其他bean的引用。这些引用也称为协作者或依赖项。
d. 要在新创建的对象中设置的其他配置设置
###### Naming Beans
bean通常只有一个标识符。以将额外的名称设置为别名。
###### Instantiating Beans
1. Instantiation with a Constructor,空的构造方法
2. Instantiation with a Static Factory Method，指定factory-method
3. Instantiation by Using an Instance Factory Method
factory bean: 首先是一个bean，其次是一个factory可以生产bean，由spring容器管理
bean factory: spring容器根接口,管理所有bean
#### dependencise
应用中很多对象都会相互关联协作，产生依赖
###### dependency injection
由容器注入依赖项，代码更加简洁，易于测试
1. Constructor-based Dependency Injection
2. Setter-based Dependency Injection
3. 建议：对于强制依赖项使用构造函数，对于可选依赖项使用setter方法或配置方法
4. 通常提倡构造函数注入，因为它允许您将应用程序组件实现为不可变的对象，并确保所需的依赖项不是空的。此外，注入构造函数的组件总是以完全初始化的状态返回给客户端
###### Dependency Resolution Process
1.  ApplicationContext使用描述bean的配置元数据进行创建和初始化
2. 对每个bean在创建时进行提供依赖项
###### Circular dependencies
###### Using depends-on
 显式强制在使用此元素的bean初始化之前初始化一个或多个bean。
###### Lazy-initialized Beans
延迟实例化
###### Autowiring Collaborators
byName、byType、constructor
###### Method Injection
1. Lookup Method Injection
#### Bean Scopes
singleton(default)、prototype、request、session、application、websocket、Custom Scopes
#### Customizing the Nature of a Bean
###### Lifecycle Callbacks
实现Spring InitializingBean和一次性bean接口，与bean生命周期的容器管理进行交互。Spring框架使用BeanPostProcessor实现来处理它能找到并调用适当方法的任何回调接口。
1. Initialization Callbacks
InitializingBean.afterPropertiesSet()、 init-method、 @PostConstruct 
2. Destruction Callbacks
DisposableBean.destroy()、 destroy-method
3. Default Initialization and Destroy Methods
4.Combining Lifecycle Mechanisms
a. The InitializingBean and DisposableBean callback interfaces
b. Custom init() and destroy() methods
c. The @PostConstruct and @PreDestroy annotations.   
5. Startup and Shutdown Callbacks
6.Shutting Down the Spring IoC Container Gracefully in Non-Web Applications
ctx.registerShutdownHook();
###### ApplicationContextAware and BeanNameAware
1. ApplicationContextAware
2. BeanNameAware
3. Other Aware Interfaces：
####
Bean Definition Inheritance







