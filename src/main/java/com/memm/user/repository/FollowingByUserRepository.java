package com.memm.user.repository;

import com.memm.user.model.FollowingByUser;
import com.memm.user.model.key.FollowingKey;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface FollowingByUserRepository extends CassandraRepository<FollowingByUser, FollowingKey> {
}
