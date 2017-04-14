package test3.dao;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "aopService")
public class AopService {

    @Resource
    private ADao adao;


    public void run() {
        adao.GetA2();
        adao.listAAA();
    }
}
