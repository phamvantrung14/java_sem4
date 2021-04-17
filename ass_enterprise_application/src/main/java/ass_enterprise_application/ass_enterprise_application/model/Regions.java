package ass_enterprise_application.ass_enterprise_application.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "regions")
public class Regions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int region_id;
    private String region_name;

    @OneToMany(mappedBy = "region")
    private List<Countries> listCountries;
}
