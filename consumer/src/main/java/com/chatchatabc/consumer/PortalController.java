package com.chatchatabc.consumer;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import com.chatchatabc.user.User;
import com.chatchatabc.user.UserServiceFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortalController {
    @SofaReference(binding = @SofaReferenceBinding(bindingType = "bolt"))
    private UserServiceFacade userServiceFacade;

    @GetMapping("/user/{id}")
    public User index(@PathVariable("id") Long id) {
        return userServiceFacade.findById(id);
    }
}
