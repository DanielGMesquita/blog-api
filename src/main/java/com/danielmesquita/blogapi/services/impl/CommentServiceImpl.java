package com.danielmesquita.blogapi.services.impl;

import com.danielmesquita.blogapi.exceptions.ResourceNotFoundException;
import com.danielmesquita.blogapi.models.Comment;
import com.danielmesquita.blogapi.repositories.CommentRepository;
import com.danielmesquita.blogapi.services.CommentService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
  @Autowired private CommentRepository repository;

  @Override
  public Comment save(Comment comment) {
    return repository.save(comment);
  }

  @Override
  public List<Comment> getAll() {
    return repository.findAll();
  }

  @Override
  public Optional<Comment> get(Long id) {
    return repository.findById(id);
  }

  @Override
  public Comment update(Long id, Comment comment) {
    Comment commentToEdit =
        repository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Comment not found"));

    commentToEdit.setCommentText(comment.getCommentText());

    return repository.save(comment);
  }

  @Override
  public void delete(Long id) {
    repository.deleteById(id);
  }
}
