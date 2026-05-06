package com.memm.user.service;

import com.memm.user.model.SampleUser;

import java.util.UUID;

public interface SampleService {

    SampleUser findById(UUID id);
}
