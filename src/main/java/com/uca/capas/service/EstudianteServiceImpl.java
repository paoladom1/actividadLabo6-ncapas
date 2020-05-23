package com.uca.capas.service;

import com.uca.capas.dao.EstudianteDAO;
import com.uca.capas.domain.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EstudianteServiceImpl implements EstudianteService {
    @Autowired
    EstudianteDAO estudianteDAO;

    @Override
    public List<Estudiante> findAll() throws DataAccessException {
        return estudianteDAO.findAll();
    }

    @Override
    public Estudiante findOne(Integer code) throws DataAccessException {
        return estudianteDAO.findOne(code);
    }

    @Override
    @Transactional
    public void save(Estudiante estudiante) throws DataAccessException {
        estudianteDAO.save(estudiante);
    }

    @Override
    @Transactional
    public void delete(Integer code) throws DataAccessException {
        estudianteDAO.delete(code);
    }

}
