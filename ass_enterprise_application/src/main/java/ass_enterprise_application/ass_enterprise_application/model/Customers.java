package ass_enterprise_application.ass_enterprise_application.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_id;
    private String cust_first_name;
    private String cust_last_name;
    private String cust_address;
    private String phone_numbers;
    private String nls_language;
    private String nls_territory;
    private String credit_limit;
    private String cust_email;
    private String cust_geo_location;
    private Date date_of_birth;
    private int marital_status;
    private int gender;
    private String income_level;
    @ManyToOne
    @JoinColumn(name = "account_mgr_id",referencedColumnName = "employee_id")
    private Employees employees;

    @OneToMany(mappedBy = "customers")
    private List<Orders>ordersList;
}
