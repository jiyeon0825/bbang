package com.bread.bbangpang.board.dto;

import com.bread.bbangpang.post.dto.PostDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "board")
public class BoardDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardNo;

    @ManyToOne
    @JoinColumn(name = "category_no")
    private CategoryDTO categoryDTO;

    @JsonIgnore
    @OneToMany(mappedBy = "board")
    private List<PostDTO> post;

    private String boardName;
    private String boardDescription;
    private LocalDateTime boardRegistered;
    private LocalDateTime boardUpdated;

}
