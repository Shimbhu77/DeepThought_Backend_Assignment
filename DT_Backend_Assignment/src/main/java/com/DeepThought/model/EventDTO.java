package com.DeepThought.model;

import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventDTO {

	private String name;
    private String tagline;
    private LocalDateTime schedule;
    private String description;
    private String image;
    private String moderator;
    private String category;
    private String subCategory;
    private Integer rigorRank;
}
