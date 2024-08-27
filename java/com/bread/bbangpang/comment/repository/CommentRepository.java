package com.bread.bbangpang.comment.repository;

import com.bread.bbangpang.comment.dto.CommentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentDTO, Integer> {

    List<CommentDTO> findByPost_PostNo(Integer postNo);

}