package org.hunterxdk.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {

    @Column(updatable = false)
    private LocalDateTime created_at;

    @Column(updatable = false)
    private String created_by;

    @Column(insertable = false)
    private LocalDateTime updated_at;

    @Column(insertable = false)
    private String updated_by;
}
