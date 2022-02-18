package com.example.junitmock.repository;


import com.example.junitmock.model.A;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ARepository extends JpaRepository<A, Long> {

}
