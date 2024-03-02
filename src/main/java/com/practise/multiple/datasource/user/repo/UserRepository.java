package com.practise.multiple.datasource.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.practise.multiple.datasource.user.data.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
}