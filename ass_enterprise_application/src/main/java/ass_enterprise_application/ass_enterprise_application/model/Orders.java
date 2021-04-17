package ass_enterprise_application.ass_enterprise_application.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;
    private Date order_date;
    private String order_mode;
    private int order_status;
    private double order_total;
    private int promotion_id;
    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "customer_id")
    private Customers customers;

    @ManyToOne
    @JoinColumn(name = "sales_rep_id",referencedColumnName = "employee_id")
    private Employees employees;

    @OneToMany(mappedBy = "orders")
    private List<Order_items> order_items;
}
