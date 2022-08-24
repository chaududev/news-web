package com.tintuc.dunews.Repository;

import com.tintuc.dunews.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Long> {


    List<Role> findAllByName(String name);
}
