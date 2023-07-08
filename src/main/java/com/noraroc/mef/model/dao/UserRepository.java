package com.noraroc.mef.model.dao;

import com.noraroc.mef.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}
