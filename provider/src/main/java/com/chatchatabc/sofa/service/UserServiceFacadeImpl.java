package com.chatchatabc.sofa.service;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.chatchatabc.user.User;
import com.chatchatabc.user.UserServiceFacade;
import org.springframework.stereotype.Service;

@Service(value = "userServiceFacade")
@SofaService(interfaceType = UserServiceFacade.class, bindings = {@SofaServiceBinding(bindingType = "bolt")})
public class UserServiceFacadeImpl implements UserServiceFacade {
    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(id);
        user.setNick("linux_china");
        return user;
    }
}
