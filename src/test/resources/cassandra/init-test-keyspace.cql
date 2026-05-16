CREATE KEYSPACE IF NOT EXISTS user_service_test
    WITH REPLICATION = {
        'class': 'SimpleStrategy',
        'replication_factor': 1
    }
    AND DURABLE_WRITES = true;
