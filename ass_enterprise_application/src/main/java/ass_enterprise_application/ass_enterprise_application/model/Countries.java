package ass_enterprise_application.ass_enterprise_application.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "countries")
public class Countries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int country_id;
    private String country_name;

    @ManyToOne
    @JoinColumn(name = "region_id",referencedColumnName = "region_id")
    private Regions region;

    @OneToMany(mappedBy = "countries")
    private List<Countries> countries;
}
