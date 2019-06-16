package com.epam.kolmakov.services;

import com.epam.kolmakov.db.dao.passingTest.PassingTestDao;
import com.epam.kolmakov.db.models.PassingTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassingTestService {
    @Autowired
    private PassingTestDao passingTestDao;

    public boolean save(PassingTest passingTest){
       return passingTestDao.save(passingTest);
    }
}
