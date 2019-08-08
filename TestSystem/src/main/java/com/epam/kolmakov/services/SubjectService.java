package com.epam.kolmakov.services;

import com.epam.kolmakov.db.dao.subject.SubjectDao;
import com.epam.kolmakov.db.models.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SubjectService {
    @Autowired
    private SubjectDao subjectDao;

    public List<Subject> getAllSubjects(){
        return subjectDao.findAll();
    }

    public Optional<Subject> getSubjectById(Long id){
        return subjectDao.findById(id);
    }

    public Optional<Subject> getSubjectByName(String name){
        return subjectDao.findSubjectByName(name);
    }

    public Long saveAndGetId(Subject subject){
        Optional<Subject> optionalSubject = subjectDao.findSubjectByName(subject.getName());
        if(optionalSubject.isPresent()){
            return optionalSubject.get().getId();
        }
        return subjectDao.saveAndGetId(subject);
    }
}
