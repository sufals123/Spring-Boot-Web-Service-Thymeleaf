package com.boot.springrestjpa.Dao;

import org.springframework.data.repository.CrudRepository;
import com.boot.springrestjpa.Model.Emp;

public interface EmpRepository extends CrudRepository<Emp, Integer> {
}
