package com.example.junitmock.init;



import com.example.junitmock.model.A;
import com.example.junitmock.model.B;
import com.example.junitmock.model.C;
import com.example.junitmock.repository.ARepository;
import com.example.junitmock.repository.BRepository;
import com.example.junitmock.service.DataManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {


    private final ARepository aRepository;
    private final BRepository bRepository;
    private final DataManager dataManager;
    private A a;
    private B b;

    public DataLoader(ARepository aRepository, BRepository bRepository, DataManager dataManager) {
        this.aRepository = aRepository;
        this.bRepository = bRepository;
        this.dataManager = dataManager;
    }


    public void insertABC(){
        B b = new B();
        b.setName("B-Name");
        b.setAddress("B-Address");

        List<C> cList = List.of(new C("c-name", "c-address"),new C( "c-name2", "c-address2"),
                new C( "c-name3", "c-address3"));

        A a = new A();
        a.setName("A-Name");
        a.setAddress("A-Address");
        a.setB(b);
        b.setA(a);

        cList.forEach(item -> item.setB(b));
        b.setCBatch(cList);
        dataManager.saveA(a);

    }

    public void getAB(){
       var aa =  aRepository.getById(a.getAId());
       var bb = aa.getB();
       bb.setAddress("new address of B");
       dataManager.saveB(bb);
      // bRepository.save(bb);
    }

    @Override
    public void run(String... args) throws Exception {
        aRepository.deleteAll();
        bRepository.deleteAll();
        insertABC();
       // getAB();
    }
}
