package it.marczuk.pracadomowa_tydzien6.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Video {
    private Long id;
    private String title;
    private String producer;
    private int year;
}
