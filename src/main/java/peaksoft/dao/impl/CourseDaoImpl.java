package peaksoft.dao.impl;

import peaksoft.util.Util;
import peaksoft.dao.CourseDao;
import peaksoft.entity.Course;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseDaoImpl implements CourseDao {


    @Override
    public void saveCourse(Course course) {
        try {
            EntityManager entityManager = Util.entityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(course);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Course with name: " + course.getCourseName() + " successfully saved!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getCourseById(Long courseId) {
        try{
        EntityManager entityManager = Util.entityManager();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, courseId);
        System.out.println("Course id: " + course.getCourseId() +
                "\nCourse name: " + course.getCourseName() +
                "\nCourse duration: " + course.getCourseDuration() +
                "\nCourse create at: " + course.getCourseCreateAt() +
                "\nCourse image link: " + course.getCourseImageLink() +
                "\nCourse description: " + course.getCourseDescription());
        course.getInstructors().forEach(System.out::println);
        course.getLessons().forEach(System.out::println);
        entityManager.getTransaction().commit();
        entityManager.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Course> getAllCourse() {
        try{
        EntityManager entityManager = Util.entityManager();
        entityManager.getTransaction().begin();

        List<Course> courses = entityManager.createQuery("select  p from Course p order by p.courseDuration", Course.class).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        return courses.stream().toList();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void updateCourse(Long courseId, Course course) {
        try{
        EntityManager entityManager = Util.entityManager();
        entityManager.getTransaction().begin();
        Course course1 = entityManager.find(Course.class, courseId);
        course1.setCourseName(course.getCourseName());
        course1.setCourseCreateAt(course.getCourseCreateAt());
        course1.setCourseDescription(course.getCourseDescription());
        course1.setCourseDuration(course.getCourseDuration());
        course1.setCourseImageLink(course.getCourseImageLink());
            entityManager.getTransaction().commit();
        entityManager.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteCourseById(Long curseId) {
        try{
        EntityManager entityManager = Util.entityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Course.class, curseId));
        entityManager.getTransaction().commit();
        entityManager.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void getCourseByName(String courseName) {
        try{
        EntityManager entityManager = Util.entityManager();
        entityManager.getTransaction().begin();
        List<Course> courses = entityManager.createQuery("select c from Course c").getResultList();
            for (Course course : courses) {
                if (course.getCourseName().equals(courseName)){
                    System.out.println("\nCourse id: " + course.getCourseId() +
                            "\nCourse name: " + course.getCourseName() +
                            "\nCourse description: " + course.getCourseDescription() +
                            "\nCourse duration: " + course.getCourseDuration() +
                            "\nCourse create at: " + course.getCourseCreateAt() +
                            "\nCourse image link: " + course.getCourseImageLink())
                    ;
                    course.getLessons().forEach(System.out::println);
                    course.getInstructors().forEach(System.out::println);
                }
            }
        entityManager.getTransaction().commit();
        entityManager.close();
    }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
