package com.bread.bbangpang.board.dto;

import com.bread.bbangpang.post.dto.PostDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "categories")
public class CategoryDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoriesNo;

    private String categoriesName;

    private String categoriesDescription;

    private LocalDateTime categoriesRegistered;

    @OneToMany(mappedBy = "categoryDTO", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<BoardDTO> boards;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<PostDTO> post;

}
