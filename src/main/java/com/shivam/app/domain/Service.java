package com.shivam.app.domain;

import com.shivam.app.domain.enities.Course;
import com.shivam.app.domain.enities.Topic;

import java.util.List;


@org.springframework.stereotype.Service
public interface Service {
    List<Topic> getAllTopics();
    Topic getTopic(String id);
    void addTopic(Topic topic);
    void updateTopic(Topic topic, String id);
    void deleteTopic(String id);
    List<Course> getAllCourses(String topicId);
    Course getCourse(String courseId);
    void addCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(String id);
}
