# MyAndroidKotlin
kotlin版本的Android学习

## 1.Jetpack(官方组件)
### 1.1 LifeCycle
LifecycleObserver ：观察者
@OnLifecycleEvent ：用来标注方法关注的生命周期
LifeCycleOwner ：生命周期被订阅者，Activity和Fragment已经集成
ProcessLifecycleOwner ：Application持有，用来监听App的生命周期 ondestroy的监听永远不会被调用

### 1.2 Navigation 导航页面

### 1.3 ViewModel数据管理

ViewModel :标准类，并且含有一个onCleared方法用来销毁数据 

AndroidViewModel:相比于ViewModel多一个参数Application，可以做一些App相关的操作

ViewModel一般与LiveData 结合在一起使用

下图为ViewModel生命周期

![image](https://api2.mubu.com/v3/document_image/c0148d1c-fb98-447c-a168-13e94e8297b6-4745159.jpg)

### 1.4 LiveData 数据绑定 




## 2.PermissionX 郭霖版本
解决Permissions权限请求的框架

## 3.自定义View