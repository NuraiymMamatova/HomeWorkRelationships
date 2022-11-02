package peaksoft.dao;

import peaksoft.entity.Instructor;

public interface InstructorDao {
    void saveInstructor(Instructor instructor);
    void updateInstructor(Long instructorId, Instructor instructor);
    Instructor getInstructorById(Long instructorId);
    void getInstructorsByCourseId(Long courseId);
    void deleteInstructorById(Long instructorId);
    void assignInstructorToCourse(Long instructorId, Long courseId);
}
