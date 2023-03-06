package com.user.management.repository;

import com.user.management.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserSortRepository extends PagingAndSortingRepository<User,Long> {


}
