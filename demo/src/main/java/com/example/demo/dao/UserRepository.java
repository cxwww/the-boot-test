package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.User;


/**
 * dao只要继承JpaRepository类就可以，
 * 几乎可以不用写方法，还有一个特别有尿性的功能非常赞，
 * 就是可以根据方法名来自动的生产SQL，比如findByUserName 会自动生产一个以 userName 
 * 为参数的查询方法，比如 findAlll 自动会查询表里面的所有数据，比如自动分页等等。
 * @author
 *
 */
public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUsername(String username);
	
	User findById(Long id);
	
	@Modifying
	@Query("update User set status = ?2 where id = ?1")
	void updateUserStatus(Long id, int status);
	
	@Query("select count(*) from User where username = ?1")
	long countByUsername(String username);
}
