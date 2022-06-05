package com.shivam.app.domain;

import com.shivam.app.domain.enities.Course;
import com.shivam.app.domain.enities.Topic;
import com.shivam.app.domain.repositories.CourseRepository;
import com.shivam.app.domain.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceIml implements Service {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Topic> getAllTopics(){
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    @Override
    public  Topic getTopic(String id)
    {
        return topicRepository.findById(id).orElse(null);
    }

    @Override
    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    @Override
    public void updateTopic(Topic topic, String id) {
        addTopic(topic);
    }

    @Override
    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
    }


    @Override
    public List<Course> getAllCourses(String topicId)
    {
        return courseRepository.findByTopicId(topicId);
    }
    @Override
    public Course getCourse(String courseId)
    {
        return courseRepository.findById(courseId).orElse(null);
    }
    @Override
    public  void addCourse(Course course)
    {
        courseRepository.save(course);
    }

    @Override
    public void updateCourse(Course course) {
        addCourse(course);
    }

    @Override
    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}
