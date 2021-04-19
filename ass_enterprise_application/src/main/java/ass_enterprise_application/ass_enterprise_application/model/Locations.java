package ass_enterprise_application.ass_enterprise_application.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "locations")
public class Locations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int location_id;
    private String street_address;
    private String postal_code;
    private String state_province;


    @ManyToOne
    @JoinColumn(name = "country_id",referencedColumnName = "country_id")
    private Countries countries;

    @OneToMany(mappedBy = "locations")
    private List<Departments> departmentsList;


}
