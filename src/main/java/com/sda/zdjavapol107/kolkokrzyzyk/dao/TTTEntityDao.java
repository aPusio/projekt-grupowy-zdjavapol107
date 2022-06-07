package com.sda.zdjavapol107.kolkokrzyzyk.dao;

import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;

@AllArgsConstructor
public abstract class TTTEntityDao <T> {
    protected SessionFactory sessionFactory;
    private Class<T> clazz;

}
