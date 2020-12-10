package com.itheima.mapper;

import com.itheima.bean.User;
import tk.mybatis.mapper.common.Mapper;

/*
 *  @创建时间:  2020/12/9 9:44
 *  @描述：    主要是针对User表的增删改查操作
 *
 *   1. 由于使用了通用的mapper之后，那么mapper里面就不需要写任何的东西了
 *   2. 只需要声明一个接口，然后继承Mapper即可
 *   3. 继承的时候，Mapper里面的泛型一定要写， 如果是针对User表操作的，就写User类名。
 *   4. User类的定义不能放在taotao-manager-mapper工程，应该放在taotao-manager-pojo的工程
 *   5. 在taotao-manager-pojo写好了JavaBean之后，需要安装到本地仓库，然后在mapper项目里面引入taotao-manager-pojo
 *   6. 这仅仅是一个接口而已，甚至没有具体的实现，如果想让这个mapper能够生效，能够提供增删改查的方法，
 *      那么必须要使用springboot来扫描这个包下的所有mapper类。
 *
 *   7. 由于这个taotao-manager-mapper项目打包方式是jar ，并不具备启动的能力，所以一会测试的话，需要
 *     跟taotao-manager-service对接上。
 *
 */
public interface UserMapper extends Mapper<User> {

}
