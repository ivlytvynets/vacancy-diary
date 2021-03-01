package vacancy.diary.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vacancy")
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String company;
    private String position;
    private int expectedSalary;
    private String vacancyLink;
    private String recruiterContacts;
    private Status status;
    private LocalDateTime lastStatusUpdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getExpectedSalary() {
        return expectedSalary;
    }

    public void setExpectedSalary(int expectedSalary) {
        this.expectedSalary = expectedSalary;
    }

    public String getVacancyLink() {
        return vacancyLink;
    }

    public void setVacancyLink(String vacancyLink) {
        this.vacancyLink = vacancyLink;
    }

    public String getRecruiterContacts() {
        return recruiterContacts;
    }

    public void setRecruiterContacts(String recruiterContacts) {
        this.recruiterContacts = recruiterContacts;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getLastStatusUpdate() {
        return lastStatusUpdate;
    }

    public void setLastStatusUpdate(LocalDateTime lastStatusUpdate) {
        this.lastStatusUpdate = lastStatusUpdate;
    }

    @Override
    public String toString() {
        return "Vacancy{"
                + "id=" + id
                + ", company='" + company + '\''
                + ", position='" + position + '\''
                + ", expectedSalary=" + expectedSalary
                + ", vacancyLink='" + vacancyLink + '\''
                + ", recruiterContacts='" + recruiterContacts + '\''
                + ", status=" + status
                + ", lastStatusUpdate=" + lastStatusUpdate
                + '}';
    }
}
