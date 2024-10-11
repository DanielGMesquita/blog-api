package com.danielmesquita.blogapi.services.impl;

import com.danielmesquita.blogapi.models.Tag;
import com.danielmesquita.blogapi.repositories.TagRepository;
import com.danielmesquita.blogapi.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagRepository repository;
    @Override
    public Tag save(Tag tag) {
        return repository.save(tag);
    }

    @Override
    public List<Tag> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Tag> get(Long id) {
        return repository.findById(id);
    }

    @Override
    public Tag update(Long id, Tag tag) {
        Optional<Tag> originalTag = repository.findById(id);

        return repository.save(tag);
    }

    @Override
    public void delete(Long id) {

    }
}
