package peaksoft.dao.impl;

import peaksoft.util.Util;
import peaksoft.dao.LessonDao;
import peaksoft.entity.Course;
import peaksoft.entity.Lesson;

import javax.persistence.EntityManager;

public class LessonDaoImpl implements LessonDao {

    static EntityManager entityManager = Util.entityManager();

    @Override
    public void saveLesson(Lesson lesson, Long courseId) {
        try {
            entityManager.getTransaction().begin();
            Course course = entityManager.find(Course.class, courseId);
            lesson.setCourseId(course);
            entityManager.merge(lesson);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateLesson(Long lessonId, Lesson lesson, Long courseId) {
        try {
            entityManager.getTransaction().begin();
            Lesson lesson1 = entityManager.find(Lesson.class, lessonId);
            lesson1.setLessonName(lesson.getLessonName());
            lesson1.setVideoLink(lesson.getVideoLink());
            lesson1.setCourseId(entityManager.find(Course.class, courseId));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getLessonById(Long lessonId) {
        try {
            entityManager.getTransaction().begin();
            System.out.println(entityManager.find(Lesson.class, lessonId));
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getLessonsByCourseId(Long courseId) {
        try {
            entityManager.getTransaction().begin();
            System.out.println(entityManager.find(Course.class, courseId).getLessons());
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
