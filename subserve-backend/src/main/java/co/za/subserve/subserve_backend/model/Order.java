package co.za.subserve.subserve_backend.model;

import co.za.subserve.subserve_backend.enums.OrderStatus;
import co.za.subserve.subserve_backend.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID userId;
    private UUID odooOrderId;
    private String totalAmount;
    private PaymentStatus paymentStatus;
    private OrderStatus orderStatus;
    private String deliveryAddress;
    private String createdAt;
}
