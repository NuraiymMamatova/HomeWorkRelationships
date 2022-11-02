package peaksoft.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "task")
public class Task {
    @Id
    @SequenceGenerator(name = "seq", sequenceName = "seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "task_id")
    private Long taskId;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "task_deadline")
    private LocalDate taskDeadline;

    @Column(name = "task")
    private String task;

    public Task(String taskName, LocalDate taskDeadline, String task) {
        this.taskName = taskName;
        this.taskDeadline = taskDeadline;
        this.task = task;
    }

    @Override
    public String toString() {
        return "\n-----Task-----" +
                "\ntask id: " + taskId +
                "\ntask name: " + taskName +
                "\ntask deadline: " + taskDeadline +
                "\ntask: " + task ;
    }
}
