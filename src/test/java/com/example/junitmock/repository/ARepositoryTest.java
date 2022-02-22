package com.example.junitmock.repository;

import com.example.junitmock.data.TestData;
import com.example.junitmock.model.A;
import com.example.junitmock.model.B;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class ARepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    ARepository aRepository;

    @Autowired
    BRepository bRepository;


    @Test
    public void testFindAById() {
        A a = TestData.getA();
        A expectedA = entityManager.persistAndFlush(a);
        Optional<A> aOptional = aRepository.findById(a.getAId());
        Optional<B> bOptional = bRepository.findById(a.getAId());

        if (aOptional.isPresent()) {
            A actualA = aOptional.get();
            assertEquals(expectedA, actualA);
        }

        if (bOptional.isPresent()) {
            B actualB = bOptional.get();
            assertEquals(expectedA.getB(), actualB);
        }
    }

    @Test
    public void testSaveA() {
        A a = TestData.getA();
        A actualA = aRepository.save(a);

        A expectedA = entityManager.find(A.class, actualA.getAId());
        assertEquals(expectedA, actualA);
    }

    @Test
    public void testSaveB() {
        B b = TestData.getB();
        B actualB = bRepository.save(b);

        B expectedB = entityManager.find(B.class, actualB.getBId());
        assertEquals(expectedB, actualB);
    }


    @Test
    public void testDeleteAbyId() {
        A a = TestData.getA();
        A actualA = aRepository.save(a);
        aRepository.deleteById(actualA.getAId());
        A expectedA = entityManager.find(A.class, actualA.getAId());
        assertNull(expectedA);
    }

    @Test
    public void testDeleteBbyId() {
        B b = TestData.getB();
        B actualB = bRepository.save(b);
        bRepository.deleteById(actualB.getBId());
        B expectedB = entityManager.find(B.class, actualB.getBId());
        assertNull(expectedB);
    }
}