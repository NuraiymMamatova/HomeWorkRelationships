package peaksoft.entity;

import lombok.*;

import javax.persistence.*;
import java.util.*;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "instructors")
@Setter
@Getter
@NoArgsConstructor
public class Instructor {
    @Id
    @SequenceGenerator(name = "instructor_seq", sequenceName = "instructor_sequence", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instructor_seq")
    @Column(name = "instructor_id")
    private Long instructorId;

    @Column(name = "instructor_first_name")
    private String instructorFirstName;

    @Column(name = "instructor_last_name")
    private String instructorLastName;

    @Column(name = "instructor_email")
    private String instructorEmail;

    @Column(name = "instructor_phone_number")
    private String instructorPhoneNumber;

    @ManyToMany(cascade = {DETACH, MERGE, REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "instructor_courses",
            joinColumns = @JoinColumn(name = "instructor_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses = new ArrayList<>();

    public Instructor(String instructorFirstName, String instructorLastName, String instructorEmail, String instructorPhoneNumber) {
        this.instructorFirstName = instructorFirstName;
        this.instructorLastName = instructorLastName;
        this.instructorEmail = instructorEmail;
        this.instructorPhoneNumber = instructorPhoneNumber;
    }

    @Override
    public String toString() {
        return "\n-----Instructor-----" +
                "\ninstructorId: " + instructorId +
                "\ninstructorFirstName: " + instructorFirstName +
                "\ninstructorLastName: " + instructorLastName +
                "\ninstructorEmail: " + instructorEmail +
                "\ninstructorPhoneNumber: " + instructorPhoneNumber;
    }
}