package org.tims.aliasnetwork.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "contacts")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Size(min = 1, max = 100, message = "Code name can be at most 20 characters long")
    @Column(name = "code_name")
    private String codeName;

    @NotNull
    @Size(min = 1, max = 20, message = "Phone number can be at most 20 characters long")
    @Column(name = "phone_number")
    private String phoneNumber;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
