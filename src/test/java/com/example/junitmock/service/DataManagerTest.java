package com.example.junitmock.service;

import com.example.junitmock.data.TestData;
import com.example.junitmock.model.A;
import com.example.junitmock.model.B;
import com.example.junitmock.repository.ARepository;
import com.example.junitmock.repository.BRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class DataManagerTest {

    @Mock
    ARepository aRepository;

    @Mock
    BRepository bRepository;

    @InjectMocks
    DataManager dataManager;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveA() {
      A expectedA = TestData.getA();
      when(aRepository.save(expectedA)).thenReturn(expectedA);
      A actualA = dataManager.saveA(expectedA);
      assertEquals(expectedA, actualA);
    }

    @Test
    void saveB() {
        B expectedB = TestData.getB();
        when(bRepository.save(expectedB)).thenReturn(expectedB);
        B actualB = dataManager.saveB(expectedB);
        assertEquals(expectedB, actualB);
    }

    @Test
    void findAbyId() {
        A expectedA = TestData.getA();
        when(aRepository.findById(1l)).thenReturn(Optional.of(expectedA));

        A actualA = dataManager.findAbyId(1l);

        assertEquals(expectedA, actualA);
    }

    @Test
    void findBbyId() {
        B expectedB = TestData.getB();
        when(bRepository.findById(1l)).thenReturn(Optional.of(expectedB));
        B actualB = dataManager.findBbyId(1l);

        assertEquals(expectedB, actualB);
    }

    @Test
    void findAllA() {
        List<A> expectedAList = TestData.getAList();
        when(aRepository.findAll()).thenReturn(expectedAList);

        List<A> actualAList =  dataManager.findAllA();

        assertEquals(expectedAList, actualAList);

    }

    @Test
    void findAllB() {
        List<B> expectedBList = TestData.getBList();
        when(bRepository.findAll()).thenReturn(expectedBList);

        List<B> actualBList =  dataManager.findAllB();

        assertEquals(expectedBList, actualBList);
    }

    @Test
    void deleteAbyId() {
        DataManager dataManager = mock(DataManager.class);
        doNothing().when(dataManager).deleteAbyId(1l);
        dataManager.deleteAbyId(1l);
        verify(dataManager, times(1)).deleteAbyId(1l);
    }

    @Test
    void deleteBbyId() {
        DataManager dataManager = mock(DataManager.class);
        doNothing().when(dataManager).deleteBbyId(1l);
        dataManager.deleteBbyId(1l);
        verify(dataManager, times(1)).deleteBbyId(1l);
    }

}