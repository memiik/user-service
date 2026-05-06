package com.memm.user.repository;

import com.memm.user.model.FollowingByUser;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface FollowingByUserRepository extends CassandraRepository<FollowingByUser, UUID> {
}
