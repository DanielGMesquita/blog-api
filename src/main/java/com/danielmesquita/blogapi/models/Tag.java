package com.danielmesquita.blogapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Tag")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tag {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "tag_id")
  private Long tagId;

  @Column(name = "tag_title", unique = true)
  private String tagTitle;

  @ManyToMany private Post postId;

  public void setTagTitle(String title) {
    this.tagTitle = title.toLowerCase();
  }
}
