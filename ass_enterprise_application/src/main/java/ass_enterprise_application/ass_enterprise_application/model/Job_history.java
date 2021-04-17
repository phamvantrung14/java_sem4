package ass_enterprise_application.ass_enterprise_application.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "job_history")
public class Job_history {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date start_date;
    private Date end_date;

    @ManyToOne
    @JoinColumn(name = "job_id",referencedColumnName = "job_id")
    private Jobs jobs;

    @ManyToOne
    @JoinColumn(name = "department_id",referencedColumnName = "department_id")
    private Departments departments;

    @ManyToOne
    @JoinColumn(name = "employee_id",referencedColumnName ="employee_id" )
    private Employees employees;
}
