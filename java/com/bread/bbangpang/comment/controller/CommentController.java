package com.bread.bbangpang.comment.controller;

import com.bread.bbangpang.board.dto.CategoryDTO;
import com.bread.bbangpang.board.service.CategoryService;
import com.bread.bbangpang.comment.dto.CommentDTO;
import com.bread.bbangpang.comment.service.CommentService;
import com.bread.bbangpang.post.dto.PostDTO;
import com.bread.bbangpang.post.repositiory.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("post/{postNo}/comments/new")
    public String createNewComment(@PathVariable("postNo") Integer postNo, Model model) {
        PostDTO post = postRepository.findById(postNo).orElseThrow();
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setPost(post);
        model.addAttribute("comment", commentDTO);
        model.addAttribute("postNo", postNo);

        return "comment/comment";
    }

    // 댓글 저장
    @PostMapping("post/{postNo}/comments")
    public String saveNewComment(@PathVariable("postNo") Integer postNo,
                                 @RequestParam("commentWriter") String commentWriter,
                                 @RequestParam("commentContent") String commentContent,
                                 @RequestParam("commentPassword") String commentPassword,
                                 Model model) {

        PostDTO post = postRepository.findById(postNo).orElseThrow(() -> new IllegalArgumentException("Invalid post ID: " + postNo));

        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setPost(post);
        commentDTO.setCommentWriter(commentWriter);
        commentDTO.setCommentContent(commentContent);
        commentDTO.setCommentPassword(commentPassword);

        commentService.saveComment(commentDTO);

        return "redirect:/post/" + postNo;
    }

    // 댓글 삭제 비밀 번호 확인 화면
    @GetMapping("comment/delete/check")
    public String checkCommentDelete(@RequestParam("postNo") Integer postNo,
                                     @RequestParam("commentNo") Integer commentNo,
                                     Model model) {
        // sidebar
        List<CategoryDTO> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);

        model.addAttribute("postNo", postNo);
        model.addAttribute("commentNo", commentNo);
        return "client/check/checkCommentDelete";
    }

    // 댓글 삭제
    @PostMapping("post/{postNo}/comments/delete/{commentNo}")
    public String deleteComment(@PathVariable("commentNo") Integer commentNo,
                                @PathVariable("postNo") Integer postNo,
                                @RequestParam("commentPassword") String commentPassword,
                                Model model) {
        // 비밀번호 확인 로직
        boolean isPasswordCorrect = commentService.checkPassword(commentNo, commentPassword);

        if (isPasswordCorrect) {
            commentService.deleteCommentById(commentNo);

            return "redirect:/post/" + postNo;
        } else {
            // 비밀번호가 일치하지 않으면 오류 메시지 전달
            model.addAttribute("postNo", postNo);
            model.addAttribute("commentNo", commentNo);
            model.addAttribute("errorMessage", "비밀번호가 일치하지 않습니다.");
            return "client/check/checkCommentDelete";
        }
    }

}
