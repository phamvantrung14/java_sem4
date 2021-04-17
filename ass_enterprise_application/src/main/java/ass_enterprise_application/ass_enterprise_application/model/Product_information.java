package ass_enterprise_application.ass_enterprise_application.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_information")
public class Product_information {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;
    private String product_name;
    private String product_description;
    private int category_id;
    private double weight_class;
    private String warranty_period;
    private int supplier_id;
    private int product_status;
    private double list_price;
    private double min_price;
    private String catalog_url;

    @OneToMany(mappedBy = "product_information")
    private List<Order_items> orderItemsList;

    @OneToMany(mappedBy = "product_information")
    private List<Product_descriptions> productDescriptionsList;

    @OneToMany(mappedBy = "product_information")
    private List<Inventories> inventoriesList;
}
