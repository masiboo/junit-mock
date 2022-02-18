package com.example.junitmock.service;

import com.example.junitmock.model.A;
import com.example.junitmock.model.B;
import com.example.junitmock.repository.ARepository;
import com.example.junitmock.repository.BRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public record DataManager(ARepository aRepository,
                          BRepository bRepository) {

    public A saveA(A a){
        return aRepository.save(a);
    }

    public B saveB(B b){
        return bRepository.save(b);
    }

    public A findAbyId(long id){
        Optional<A> result = aRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw  new EntityNotFoundException("Not found by id "+id);
    }

    public B findBbyId(long id){
        Optional<B> result = bRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw  new EntityNotFoundException("Not found by id "+id);
    }

    public List<A> findAllA(){
        return aRepository.findAll();
    }

    public List<B> findAllB(){
        return bRepository.findAll();
    }


    public void deleteAbyId(long id){
        aRepository.deleteById(id);
    }

    public void deleteBbyId(long id){
        bRepository.deleteById(id);
    }
}
