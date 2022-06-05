package com.shivam.app.domain.repositories;

import com.shivam.app.domain.enities.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> {
     List<Course> findByTopicId(String topicId);

}
