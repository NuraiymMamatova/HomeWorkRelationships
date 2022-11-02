package peaksoft.dao;

import peaksoft.entity.Lesson;

public interface LessonDao {
    void saveLesson(Lesson lesson, Long courseId);
    void updateLesson(Long lessonId, Lesson lesson, Long courseId);
    void getLessonById(Long lessonId);
    void getLessonsByCourseId(Long courseId);
}
