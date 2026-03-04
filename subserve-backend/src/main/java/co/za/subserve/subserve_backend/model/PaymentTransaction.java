package co.za.subserve.subserve_backend.model;

import co.za.subserve.subserve_backend.enums.PaymentStatus;
import co.za.subserve.subserve_backend.enums.TransactionProvider;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
public class PaymentTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID orderId;
    private TransactionProvider provider;
    private String providerReference;
    private String amount;
    private String currency;
    private PaymentStatus status;
    private String createdAt;
}
