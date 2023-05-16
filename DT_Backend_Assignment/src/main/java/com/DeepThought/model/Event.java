package com.DeepThought.model;

import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer uid;
	
    private String type = "event";
    private String name;
    private String tagline;
    private LocalDateTime schedule;
    private String description;
    private String image;
    private String moderator;
    private String category;
    private String subCategory;
    private Integer rigorRank;
    private Integer[] attendees;
}
