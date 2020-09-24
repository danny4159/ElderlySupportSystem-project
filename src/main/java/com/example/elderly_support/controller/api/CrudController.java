package com.example.elderly_support.controller.api;

import com.example.elderly_support.ifs.CrudInterface;
import com.example.elderly_support.model.network.Header;
import com.example.elderly_support.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Component //개발자가 직접 작성한 Class를 Bean으로 등록하기 위한 어노테이션
public abstract class CrudController<Req,Res,Entity> implements CrudInterface<Req,Res> {
//인터페이스에서 받은 클래스들을 구현하는 추상클래스
// 그 추상클래스를 상속받을 각 ApiController들


//    protected CrudInterface<Req,Res> baseService; //서비스랑 이렇게 연결한 걸 잘 봐!!
    @Autowired(required = false)
    protected BaseService<Req,Res,Entity> baseService;

    @Override
    @PostMapping("")
    public Header<Res> create(@RequestBody Header<Req> request) {
        log.info("{}",request);
        return baseService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<Res> read(@PathVariable Long id) {
        log.info("read : {}",id);
        return baseService.read(id);
    }

    @Override   
    @PutMapping("")
    public Header<Res> update(@RequestBody Header<Req> request) {
        return baseService.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        return baseService.delete(id);
    }

    @Override
    @GetMapping("")
    public Header<List<Res>> search(@PageableDefault(sort = "id",direction = Sort.Direction.ASC) Pageable pageable) {
        return baseService.search(pageable);
    }

}