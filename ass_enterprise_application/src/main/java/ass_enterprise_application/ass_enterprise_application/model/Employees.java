package ass_enterprise_application.ass_enterprise_application.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;
    private Date hire_date;
    private double salary;
    private double commission_pct;
    private int manager_id;
    @ManyToOne
    @JoinColumn(name = "department_id",referencedColumnName = "department_id")
    private Departments departments;

    @ManyToOne
    @JoinColumn(name = "job_id",referencedColumnName = "job_id")
    private Jobs jobs;

    @OneToMany(mappedBy = "employees")
    private List<Job_history> jobHistoryList;

    @OneToMany(mappedBy = "employees")
    private List<Orders> ordersList;

    @OneToMany(mappedBy = "employees")
    private List<Customers> customersList;

}
