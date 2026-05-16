package com.memm.user.repository;

import com.memm.user.model.FollowersByUser;
import com.memm.user.model.key.FollowerKey;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface FollowersByUserRepository extends CassandraRepository<FollowersByUser, FollowerKey> {
}
