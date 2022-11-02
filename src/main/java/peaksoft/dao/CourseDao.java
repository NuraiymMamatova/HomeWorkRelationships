package peaksoft.dao;


import peaksoft.entity.Course;

import java.util.List;

public interface CourseDao {
    void saveCourse(Course course);
    void getCourseById(Long courseId);
    List<Course> getAllCourse();
    void updateCourse(Long courseId, Course course);
    void deleteCourseById(Long courseId);
    void getCourseByName(String courseName);
}
