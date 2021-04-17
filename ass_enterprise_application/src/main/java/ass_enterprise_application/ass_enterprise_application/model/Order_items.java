package ass_enterprise_application.ass_enterprise_application.model;

import javax.persistence.*;

@Entity
@Table(name = "order_items")
public class Order_items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int line_item_id;
    private double unit_price;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "order_id",referencedColumnName = "order_id")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "product_id")
    private Product_information product_information;
}
