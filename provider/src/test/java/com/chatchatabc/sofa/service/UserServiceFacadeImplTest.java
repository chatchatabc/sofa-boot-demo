package com.chatchatabc.sofa.service;


import com.chatchatabc.sofa.SofaBootBaseTest;
import com.chatchatabc.user.UserServiceFacade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class UserServiceFacadeImplTest extends SofaBootBaseTest {
    @Autowired
    private UserServiceFacade userServiceFacade;

    @Test
    public void testFindById() {
        assertThat(userServiceFacade.findById(1L)).isNotNull();
    }
}
