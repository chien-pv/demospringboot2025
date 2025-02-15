package banhang.banhang.service;

import org.springframework.stereotype.Service;

@Service
public class PgCrudService implements CrudService {
    public void create(){
        System.out.println("Tao du lieu vao PG");
    }
}
