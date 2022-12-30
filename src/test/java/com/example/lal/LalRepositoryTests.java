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
    @Autowired private LalRepository repository;

    @BeforeAll 
    static void beforeAll(
        @Autowired LalRepository repository,
        @Autowired KekRepository kekRepo
    ) {
        Lal l1 = new Lal("l1", Lal.LalType.FIRST);
        Lal l2 = new Lal("l2", Lal.LalType.SECOND);
        Lal l3 = new Lal("l3", Lal.LalType.THIRD);
        List<Lal> ll = Arrays.asList(l1, l2, l3);

        Kek k1 = new Kek("k1");
        Kek k2 = new Kek("k2");

        List<Kek> kl = Arrays.asList(k1, k2);

        kekRepo.saveAll(kl);
        l1.addKek(k1).addKek(k2);

        repository.saveAll(ll);
    }

    @AfterAll 
    static void afterAll(
        @Autowired LalRepository repository,
        @Autowired KekRepository kekRepo
    ) {
        repository.deleteAll();
        kekRepo.deleteAll();
    }

    @Test
    void injectedRepositoryAreNotNull() {
        assertNotNull(repository);
    }

    @Test
    void findByType() {
        Pageable p = PageRequest.of(0, 20);
        Page<Lal> l1 = repository.findByNameContaining("l", p);
        assertEquals(l1.getContent().size(), 3);
    }

    @Test
    void findByTypes() {
        List<Lal.LalType> types = Arrays.asList(Lal.LalType.FIRST, Lal.LalType.SECOND);
        Lal[] l1 = repository.findByType(types);
        assertEquals(l1.length, 2);
    }

    @Test
    void findWithRelations() {
        Pageable p = PageRequest.of(0, 20);
        Page<Lal> l1 = repository.findAllWithRelation(p);
        List<Lal> c = l1.getContent();
        assertEquals(c.size(), 3);

        List<Kek> kl = c.get(0).getKeks();
        assertNotNull(kl);
        Kek k = kl.get(0);
        assertNotNull(k);
    }
}
