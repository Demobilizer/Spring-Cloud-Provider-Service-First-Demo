/**
 * 
 */
package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Employee;

/**
 * @author Mehul
**/

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
