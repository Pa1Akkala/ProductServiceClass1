package dev.pavan.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
//    @Id
//    @GeneratedValue(generator = "pavan")
//    @GenericGenerator(name="pavan",strategy="uuid2")
//    @Column(name="id",columnDefinition = "binary(16)",nullable=false,updatable=false)
//    private UUID uuid;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
}
