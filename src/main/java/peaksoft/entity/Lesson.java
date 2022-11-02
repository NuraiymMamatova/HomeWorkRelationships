package peaksoft.entity;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "lessons")
public class Lesson {
    @Id
    @SequenceGenerator(name = "seq_name", sequenceName = "sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_name")
    @Column(name = "lesson_id")
    private Long lessonId;

    @Column(name = "lesson_name")
    private String lessonName;

    @Column(name = "video_link")
    private String videoLink;

    @ManyToOne(cascade = {DETACH, MERGE, REFRESH, PERSIST}, fetch = FetchType.EAGER)
    private Course courseId;

    @OneToMany(cascade = ALL, fetch = FetchType.LAZY)
    @Column(name = "task_id")
    List<Task> taskId = new ArrayList<>();

    public Lesson(String lessonName, String videoLink) {
        this.lessonName = lessonName;
        this.videoLink = videoLink;
    }

    @Override
    public String toString() {
        return "\n----Lesson----- " +
                "\nlesson id: " + lessonId +
                "\nlesson name: " + lessonName +
                "\nvideo link: " + videoLink +
                "\ncourse id: " + courseId;
    }
}
