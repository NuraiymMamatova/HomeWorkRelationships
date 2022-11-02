package peaksoft.dao;

import peaksoft.entity.Task;

import java.util.List;

public interface TaskDao {
    void saveTask(Task task, Long lessonId);
    void updateTask(Long taskId, Task task);
    List<Task> getAllTaskByLessonId(Long lessonId);
    void deleteTaskById(Long taskId);
}
