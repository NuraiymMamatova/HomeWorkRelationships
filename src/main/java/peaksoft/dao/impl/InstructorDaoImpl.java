package peaksoft.dao.impl;

import peaksoft.util.Util;
import peaksoft.dao.InstructorDao;
import peaksoft.entity.Course;
import peaksoft.entity.Instructor;

import javax.persistence.EntityManager;

public class InstructorDaoImpl implements InstructorDao {
    static EntityManager entityManager = Util.entityManager();

    @Override
    public void saveInstructor(Instructor instructor) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(instructor);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Instructor with name: " + instructor.getInstructorFirstName() + " successfully saved");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateInstructor(Long instructorId, Instructor instructor) {
        try {
            entityManager.getTransaction().begin();
            Instructor instructor1 = entityManager.find(Instructor.class, instructorId);
            if (instructorId != null) {
                instructor1.setInstructorEmail(instructor.getInstructorEmail());
                instructor1.setInstructorFirstName(instructor.getInstructorFirstName());
                instructor1.setInstructorLastName(instructor.getInstructorLastName());
                instructor1.setInstructorPhoneNumber(instructor.getInstructorPhoneNumber());
                entityManager.getTransaction().commit();
                entityManager.close();
            } else {
                System.out.println("Instructor with id: " + instructorId + " not found");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Instructor getInstructorById(Long instructorId) {
        Instructor instructor = new Instructor();
        try {
            entityManager.getTransaction().begin();
            instructor = entityManager.find(Instructor.class, instructorId);

            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return instructor;
    }

    @Override
    public void getInstructorsByCourseId(Long courseId) {
        try {
            entityManager.getTransaction().begin();
            Course course = entityManager.find(Course.class, courseId);
            course.getInstructors().forEach(System.out::println);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void deleteInstructorById(Long instructorId) {
        try {
            entityManager.getTransaction().begin();
            Instructor instructor = entityManager.find(Instructor.class, instructorId);
            entityManager.remove(instructor);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void assignInstructorToCourse(Long instructorId, Long courseId) {
        try {
            if (instructorId != 0 && courseId != 0) {
                entityManager.getTransaction().begin();
                Instructor instructor = entityManager.find(Instructor.class, instructorId);
                if (instructor != null) {
                    Course course = entityManager.find(Course.class, courseId);
                    if (course != null) {
                        instructor.getCourses().add(course);
                        entityManager.getTransaction().commit();
                        entityManager.close();
                        System.out.println("Instructor with id: " + instructorId + " successfully added to course with id: " + courseId);
                    } else {
                        System.out.println("course with id: " + courseId + " not found");
                    }
                } else {
                    System.out.println("instructor with id: " + instructorId + " not found");
                }
            } else {
                System.out.println("instructorId || courseId = 0");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}
