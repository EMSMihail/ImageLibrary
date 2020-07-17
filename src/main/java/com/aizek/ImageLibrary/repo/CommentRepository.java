package com.aizek.ImageLibrary.repo;

import com.aizek.ImageLibrary.models.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
