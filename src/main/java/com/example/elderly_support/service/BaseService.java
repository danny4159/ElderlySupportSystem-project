package com.example.elderly_support.service;

import com.example.elderly_support.ifs.CrudInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component // JpaRepository를 autowired 받기위해 Entity를 추가하고 @Component를 함.
public abstract class BaseService<Req,Res,Entity> implements CrudInterface<Req,Res> {

    //각 service에서 자동으로 Repository 세팅하는 역할.
    @Autowired(required = false)
    protected JpaRepository<Entity,Long> baseRepository;

    //CRUD는 service에서 직접 작성할거야. 여기서 재정의 하지마.
}
