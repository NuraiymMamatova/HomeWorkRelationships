package peaksoft.dao.impl;

import org.hibernate.HibernateException;
import peaksoft.util.Util;
import peaksoft.dao.TaskDao;
import peaksoft.entity.Lesson;
import peaksoft.entity.Task;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class TaskDaoImpl implements TaskDao {


    static EntityManager entityManager = Util.entityManager();
    @Override
    public void saveTask(Task task, Long lessonId) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(task);
            Lesson lesson = entityManager.find(Lesson.class, lessonId);
            lesson.getTaskId().add(task);
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateTask(Long taskId, Task task) {
        try{
            entityManager.getTransaction().begin();
            Task updateTask = new Task();
            updateTask.setTaskName(task.getTaskName());
            updateTask.setTask(task.getTask());
            updateTask.setTaskDeadline(task.getTaskDeadline());
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Task> getAllTaskByLessonId(Long lessonId) {
        List<Task> tasks = null;
        try{
            entityManager.getTransaction().begin();
            Lesson lesson = entityManager.find(Lesson.class, lessonId);
            tasks = new ArrayList<>(lesson.getTaskId());
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return tasks.stream().toList();
    }

    @Override
    public void deleteTaskById(Long taskId) {
        try{
            entityManager.getTransaction().begin();
            Task task = entityManager.find(Task.class, taskId);
            entityManager.remove(task);
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
