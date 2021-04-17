package ass_enterprise_application.ass_enterprise_application.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "jobs")
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int job_id;
    private String job_title;
    private double min_salary;
    private double max_salary;

    @OneToMany(mappedBy = "jobs")
    private List<Job_history> jobHistoryList;

    @OneToMany(mappedBy = "jobs")
    private List<Employees> employeesList;
}
