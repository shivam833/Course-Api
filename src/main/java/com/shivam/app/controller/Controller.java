package com.shivam.app.controller;

import com.shivam.app.domain.Service;
import com.shivam.app.domain.enities.Course;
import com.shivam.app.domain.enities.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {


    private Service service;

    @Autowired
    public void setService(Service service) {
        this.service = service;
    }

    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        return service.getAllTopics();
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id) {
        return service.getTopic(id);
    }
    @RequestMapping(method= RequestMethod.POST,value="/topics")
    public void  addTopic(@RequestBody Topic topic ) {
        service.addTopic(topic);
    }

    @RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
    public void  UpdateTopic(@RequestBody Topic topic,@PathVariable String id ) {
        service.updateTopic(topic,id);
    }

    @RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
    public void  deleteTopic(@PathVariable String id ) {
        service.deleteTopic(id);
    }




    @RequestMapping("/topics/{topicId}/courses")
    public List<Course> getAllCourses(@PathVariable String topicId)
    {
        return service.getAllCourses(topicId);
    }
    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable String id)
    {
        return service.getCourse(id);
    }
    @RequestMapping(method= RequestMethod.POST,value="/topics/{topicId}/courses")
    public void  addCourse(@RequestBody Course course,@PathVariable String topicId) {
        course.setTopic(new Topic(topicId,"",""));
        service.addCourse(course);
    }

    @RequestMapping(method=RequestMethod.PUT,value="/topics/{topicId}/courses/{id}")
    public void  UpdateCourse(@RequestBody Course course,@PathVariable String topicId) {
        course.setTopic(new Topic(topicId,"",""));
        service.updateCourse(course);
    }

    @RequestMapping(method=RequestMethod.DELETE,value="/topics/{topicId}/courses/{id}")
    public void  deleteCourse(@PathVariable String id) {
        service.deleteCourse(id);
    }
}
