package ass_enterprise_application.ass_enterprise_application.model;


import javax.persistence.*;

@Entity
@Table(name = "product_descriptions")
public class Product_descriptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int language_id;
    private String translated_name;
    private String translated_description;
    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "product_id")
    private Product_information product_information;

}
