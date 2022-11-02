package peaksoft.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = ("courses"))
@Getter
@Setter
@NoArgsConstructor
public class Course {
    @Id
    @SequenceGenerator(name = "course_seq", sequenceName = "course_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long courseId;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_duration")
    private LocalDate courseDuration;

    @Column(name = "course_create_at")
    private String courseCreateAt;

    @Column(name = "course_image_link")
    private String courseImageLink;

    @Column(name = "course_description")
    private String courseDescription;

    @ManyToMany(cascade = {DETACH, MERGE, REFRESH, PERSIST}, fetch = FetchType.LAZY, mappedBy = "courses" )
    private List<Instructor> instructors = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = ALL, mappedBy = "courseId")
    private List<Lesson> lessons;

    public Course(String courseName, LocalDate courseDuration, String courseCreateAt, String courseImageLink, String courseDescription) {
        this.courseName = courseName;
        this.courseDuration = courseDuration;
        this.courseCreateAt = courseCreateAt;
        this.courseImageLink = courseImageLink;
        this.courseDescription = courseDescription;
    }

    @Override
    public String toString() {
        return "\n-----Course-----" +
                "\ncourse_id: " + courseId +
                "\ncourseName: " + courseName +
                "\ncourseDuration: " + courseDuration +
                "\ncourseCreateAt: " + courseCreateAt +
                "\ncourseImageLink: " + courseImageLink +
                "\ncourseDescription: " + courseDescription;
    }
}
