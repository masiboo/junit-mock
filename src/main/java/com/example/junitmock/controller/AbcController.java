package com.example.junitmock.controller;

import com.example.junitmock.model.A;
import com.example.junitmock.model.B;
import com.example.junitmock.service.DataManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = AbcController.REQUEST_URL)
public class AbcController {

    public static final String REQUEST_URL = "/api/v1/revisions/";
    private final String PAGE_LIMIT = "100";

    public final DataManager dataManager;

    public AbcController(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @GetMapping(value = "/getB/{id}")
    public B getBbyId(@PathVariable long id){
       var b =  dataManager.findBbyId(id);
       return  b;
    }

    @GetMapping(value = "/getA/{id}")
    public A getAById(@PathVariable long id){
        var a =  dataManager.findAbyId(id);
        return a;
    }

    @GetMapping(value = "/getAllB")
    public List<B> getAllB(){
        var allB =  dataManager.findAllB();
        return  allB;
    }

    @GetMapping(value = "/getAllA")
    public List<A> getAllA(){
        var allA =  dataManager.findAllA();
        return  allA;
    }

    @PostMapping(value = "/saveA")
    public A saveA(@RequestBody A a){
       return dataManager.saveA(a);
    }

    @PostMapping(value = "/saveA")
    public B saveB(@RequestBody B b){
        return dataManager.saveB(b);
    }

    @DeleteMapping(value = "/delA")
    public void deleteA(long id){
        dataManager.deleteAbyId(id);
    }

    @DeleteMapping(value = "/delB")
    public void deleteB(long id){
        dataManager.deleteBbyId(id);
    }
}
