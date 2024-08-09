package com.file.FileSpring.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="user_info_file")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String fileName;
    private String folder;
}
