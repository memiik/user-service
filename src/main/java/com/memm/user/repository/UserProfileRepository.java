package com.memm.user.repository;

import com.memm.user.model.UserProfile;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface UserProfileRepository extends CassandraRepository<UserProfile, UUID> {
}
