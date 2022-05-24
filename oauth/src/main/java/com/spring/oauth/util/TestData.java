package com.spring.oauth.util;

import com.spring.oauth.domain.ResourceBean;
import com.spring.oauth.domain.RoleBean;
import com.spring.oauth.domain.UserBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: xingle
 * @Description:
 * @Date: 2022/5/23 2:36 下午
 */
@Component
public class TestData {

    private List<UserBean> allUser;

    /**
     * 模拟数据库获取到的数据
     * admin用户，拥有admin角色，拥有mobile、salary两个资源.
     * manager用户，拥有manager角色，拥有mobile资源.
     * worker用户，拥有worker角色，无拥有资源。
     * @return
     */
    private List<UserBean> getAllUser() {
        if (null == allUser) {
            allUser = new ArrayList<>();

            ResourceBean mobileResource = new ResourceBean("1", "mobile");
            ResourceBean salaryResource = new ResourceBean("2", "salary");

            List<ResourceBean> adminResources = new ArrayList<>();
            adminResources.add(mobileResource);
            adminResources.add(salaryResource);
            List<ResourceBean> managerResources = new ArrayList<>();
            managerResources.add(mobileResource);

            RoleBean adminRole = new RoleBean("1", "mobile");
            adminRole.setRoleResource(adminResources);
            RoleBean managerRole = new RoleBean("2", "salary");
            managerRole.setRoleResource(managerResources);

            List<RoleBean> adminRoles = new ArrayList<>();
            adminRoles.add(adminRole);
            List<RoleBean> managerRoles = new ArrayList<>();
            managerRoles.add(managerRole);

            UserBean user1 = new UserBean("1", "admin", "admin");
            user1.setRoleBeans(adminRoles);
            user1.setResourceBeans(adminResources);
            UserBean user2 = new UserBean("2", "manager", "manager");
            user2.setRoleBeans(managerRoles);
            user2.setResourceBeans(managerResources);
            UserBean user3 = new UserBean("3", "worker", "worker");

            allUser.add(user1);
            allUser.add(user2);
            allUser.add(user3);
        }
        return allUser;
    }

    /**
     * Stream.toList()返回的List是不可变List，不能增删改
     * Collectors.toList()返回的是个普通的List，可以增删改
     * Collectors.toUnmodifiableList()返回的List是不可变List，不能增删改
     * Stream.toList()的性能要各方面都要好于Collectors.toList()和Collectors.toUnmodifiableList()
     * @param user
     * @return
     */
    public UserBean queryUser(UserBean user) {
        List<UserBean> allUser = this.getAllUser();
        List<UserBean> userList = allUser.stream().filter(userBean ->
                userBean.getUserName().equals(user.getUserName()) && userBean.getUserPass().equals(user.getUserPass())
        ).collect(Collectors.toList());
        return userList.size() > 0 ? userList.get(0) : null;
    }
}
