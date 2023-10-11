package com.app.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.app.model.User;

@Mapper
public interface UserMapper {

	@Insert("INSERT INTO user (name, email) VALUES (#{name}, #{email})")
	public void insertUser(User user);

	@Select("SELECT * FROM user WHERE id = #{id}")
	public User selectUserById(Integer id);

	@Update("UPDATE user SET name = #{name}, email = #{email} WHERE id = #{id}")
	void updateUser(User user);

	@Delete("DELETE FROM user WHERE id = #{id}")
	void deleteUser(Integer id);
}
