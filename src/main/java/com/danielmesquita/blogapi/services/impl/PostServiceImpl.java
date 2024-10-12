package com.danielmesquita.blogapi.services.impl;

import com.danielmesquita.blogapi.exceptions.ResourceNotFoundException;
import com.danielmesquita.blogapi.models.Post;
import com.danielmesquita.blogapi.repositories.PostRepository;
import com.danielmesquita.blogapi.services.PostService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
  @Autowired private PostRepository repository;

  @Override
  public Post save(Post post) {
    return repository.save(post);
  }

  @Override
  public List<Post> getAll() {
    return repository.findAll();
  }

  @Override
  public Optional<Post> get(Long id) {
    return repository.findById(id);
  }

  @Override
  public Post update(Long id, Post post) {
    Post postToEdit =
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post not found"));

    postToEdit.setContent(post.getContent());
    postToEdit.setTitle(post.getTitle());

    return repository.save(post);
  }

  @Override
  public void delete(Long id) {
    repository.deleteById(id);
  }
}
