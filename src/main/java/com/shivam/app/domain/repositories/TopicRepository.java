package com.shivam.app.domain.repositories;

import com.shivam.app.domain.enities.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {
}
