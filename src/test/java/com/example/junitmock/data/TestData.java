package com.example.junitmock.data;

import com.example.junitmock.model.A;
import com.example.junitmock.model.B;
import com.example.junitmock.model.C;

import java.util.List;

public class TestData {

    public static  A getA(){
        A a = new A();
        B b = new B();
        a.setName("test A name");
        a.setAddress("test A address");
        b.setName("test B name");
        b.setAddress("test B address");
        b.setA(a);
        a.setB(b);
        return  a;
    }

    public static B getB(){
        B b = new B();
        b.setName("B name");
        b.setAddress("B address");
        A a = new A();
        a.setName("test A name");
        a.setAddress("test A address");
        b.setCBatch(List.of(new C(), new C()));
        b.setA(a);
        return  b;
    }

    public static List<A> getAList(){
        return List.of(new A(), new A());
    }

    public static List<B> getBList(){
        return List.of(new B(), new B());
    }
}
