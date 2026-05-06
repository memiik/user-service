package com.memm.user.repository;

import com.memm.user.model.FollowersByUser;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface FollowersByUserRepository extends CassandraRepository<FollowersByUser, UUID> {
}
