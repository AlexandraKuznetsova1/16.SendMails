package com.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "is_cart")
    private Boolean isCart;

    @OneToMany(mappedBy = "order")
    List<ProductQuantityLink> wares;

    public void addProduct(ProductQuantityLink productQuantityLink){
        wares.add(productQuantityLink);
    }
}
