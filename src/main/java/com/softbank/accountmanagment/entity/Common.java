package com.softbank.accountmanagment.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class Common {

    @Column(name = "created_when", nullable = false)
    private LocalDateTime createdWhen;

    @Column(name = "modified_when", nullable = false)
    private LocalDateTime modifiedWhen;
}
