package com.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	 	@Modifying
	 	 
	    @Query("UPDATE Student u SET u.name = :name, u.email = :email, u.address = :address, u.phone = :phone, u.image = :image WHERE u.id = :id")
	    void updateImage(@Param("id") int id, @Param("name") String name, @Param("email") String email,
	                    @Param("address") String address, @Param("phone") String phone, @Param("image") byte[] image);
	}

