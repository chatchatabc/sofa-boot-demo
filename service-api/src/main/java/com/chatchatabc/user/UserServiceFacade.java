package com.chatchatabc.user;


import org.mvnsearch.microservices.annotator.RemoteAccess;

@RemoteAccess
public interface UserServiceFacade {
    User findById(Long id);
}
