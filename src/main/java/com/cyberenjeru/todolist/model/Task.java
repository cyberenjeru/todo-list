package com.cyberenjeru.todolist.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tasks")
@Setter
@Getter
@ToString
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false) //não pode ser nulo
    private String description;

    @Column(nullable = false)
    private LocalDateTime deadline;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false, insertable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "created_at")
    private LocalDateTime updateAt;
}
