package com.example.lal;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootTest
public class LalRepositoryTests {

    @Autowired
    private LalRepository repository;

    @BeforeAll 
    static void beforeAll(@Autowired LalRepository repository) {
        Lal e1 = new Lal("e1", Lal.LalType.FIRST);
        Lal e2 = new Lal("e2", Lal.LalType.SECOND);
        Lal e3 = new Lal("e3", Lal.LalType.THIRD);
        List<Lal> list = Arrays.asList(e1, e2, e3);

        repository.saveAll(list);
    }

    @AfterAll 
    static void afterAll(@Autowired LalRepository repository) {
        repository.deleteAll();
    }

    @Test
    void injectedRepositoryAreNotNull() {
        assertNotNull(repository);
    }

    @Test
    void findByType() {
        Pageable p = PageRequest.of(0, 20);
        Page<Lal> l1 = repository.findByNameContaining("e", p);
        assertEquals(l1.getContent().size(), 3);
    }

    @Test
    void findByTypes() {
        List<Lal.LalType> types = Arrays.asList(Lal.LalType.FIRST, Lal.LalType.SECOND);
        Lal[] l1 = repository.findByType(types);
        assertEquals(l1.length, 2);
    }
}
