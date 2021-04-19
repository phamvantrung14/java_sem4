package ass_enterprise_application.ass_enterprise_application.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "warehouses")
public class Warehouses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int warehouse_id;
    private String warehouse_spec;
    private String warehouse_name;
    private String wh_geo_location;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Locations locations;

    @OneToMany(mappedBy = "warehouses")
    private List<Inventories>inventoriesList;
}
