CREATE KEYSPACE IF NOT EXISTS user_service
    WITH REPLICATION = {
        'class'              : 'NetworkTopologyStrategy',
        'my-datacenter-1'    : 1
        }
     AND DURABLE_WRITES = true;
