package com.genesisresources.GenesisResourcesRegistry.repository;

import com.genesisresources.GenesisResourcesRegistry.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
}
