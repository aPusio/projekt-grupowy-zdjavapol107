package com.sda.zdjavapol107.examples;

import com.sda.zdjavapol107.HibernateFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HmmDaoTest {
    private SessionFactory sessionFactory = mock(SessionFactory.class);
    private Session session = mock(Session.class);
    private HmmDao hmmDao = new HmmDao(sessionFactory);
    @Test
    public void daoTest(){
        //given
        String sample = "SAMPLE!";
        //when
        when(sessionFactory.openSession()).thenReturn(session);
        hmmDao.save(sample);

        //then
        Mockito.verify(sessionFactory).openSession();
        Mockito.verify(session).save(Mockito.eq("SAMPLE!"));
    }
}