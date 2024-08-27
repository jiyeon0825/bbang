package com.bread.bbangpang.comment.dto;

import com.bread.bbangpang.post.dto.PostDTO;
import com.bread.bbangpang.report.dto.ReportDTO;
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
@Table(name = "comment")
public class CommentDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_no")
    private PostDTO post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_comment_no")
    private CommentDTO parentCommentNo;

    @JsonIgnore
    @OneToMany(mappedBy = "comment")
    private List<ReportDTO> report;

    private LocalDateTime commentRegistered;
    private String commentContent;
    private String commentWriter;
    private String commentPassword;
    private Integer commentDepth;
    private String commentStatus;

    public Integer getPostNo() {
        return post != null ? post.getPostNo() : null;
    }
}
