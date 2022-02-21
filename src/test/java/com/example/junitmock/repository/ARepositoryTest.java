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
    public void testSaveA() {
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
}