package peaksoft;

import peaksoft.util.Util;
import peaksoft.dao.impl.*;
import peaksoft.entity.*;

import java.time.LocalDate;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Util.entityManager();
        TaskDaoImpl taskDao = new TaskDaoImpl();
        LessonDaoImpl lessonDao = new LessonDaoImpl();
        CourseDaoImpl courseDao = new CourseDaoImpl();
        InstructorDaoImpl instructorDao = new InstructorDaoImpl();

        //save task
        Task task = new Task("HackerRank", LocalDate.of(2022, 10, 5), "https://docs.google.com/document/d/1ysN6rVHeusp=sharing");
        taskDao.saveTask(task, 202L);
        //update task
        Task newTask = new Task("LeetCode", LocalDate.of(2022, 3, 7), "problems/ add - binary");
//         taskDao.updateTask(1L, newTask);
        //get all task by id
//        taskDao.getAllTaskByLessonId(1L);
        //delete task by id
       /// taskDao.deleteTaskById(1L);

        //save lesson
        Lesson lesson = new Lesson("JDBC", "youtu.be/_nybxEITSSA");
//        lessonDao.saveLesson(lesson, 2L);
        //update lesson
        Lesson updateLesson = new Lesson("wrap up", "youtu.be/GybB8VAVTso");
//        lessonDao.updateLesson(1L, updateLesson, 2L);
        //get lesson by id
//        lessonDao.getLessonById(1L);
        //get lesson by course id
//        lessonDao.getLessonsByCourseId(2L);

        //save instructor
        Instructor instructor = new Instructor("Maria", "Montessori", "maria@gmail.com", "47895128");
//        instructorDao.saveInstructor(instructor);
        //update instructor
        Instructor newInstructor = new Instructor("update example instructor name", "update example instructor surname", "update example instructor email", "update example instructor phone number");
//        instructorDao.updateInstructor(352L, newInstructor);
        //get instructor by id
//        System.out.println(instructorDao.getInstructorById(352L));
        //assign instructor to course
//        instructorDao.assignInstructorToCourse(52L, 3L);
        //get instructor by course id
//        instructorDao.getInstructorsByCourseId(8L);
        //delete instructor by id
//        instructorDao.deleteInstructorById(352L);

        //save course
        Course course = new Course("course name example ", LocalDate.of(3000, 10, 27), "course create at example", "course image link example", "course description");
//        courseDao.saveCourse(course);
        //update course
        Course newCourse = new Course("new course name update example", LocalDate.of(5000, 5, 15), "new course create at update example", "new course image link update example", "new course description update example");
//        courseDao.updateCourse(1L, newCourse);
        //get course by id
//        courseDao.getCourseById(1L);
        //get course by name
//        courseDao.getCourseByName("new course name update example");
        //get all course
//        System.out.println(courseDao.getAllCourse());
        //delete course by id
//        courseDao.deleteCourseById(6L);
    }
}