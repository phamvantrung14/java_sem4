package ass_enterprise_application.ass_enterprise_application.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "departments")
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int department_id;

    private String department_name;
    private String manager_id;

    @ManyToOne
    @JoinColumn(name = "location_id",referencedColumnName = "location_id")
    private Locations locations;

    @OneToMany(mappedBy = "departments")
    private List<Job_history> jobHistoryList;

    @OneToMany(mappedBy = "departments")
    private List<Employees> employeesList;

}
