package it.marczuk.pracadomowa_tydzien6.service;

import it.marczuk.pracadomowa_tydzien6.entity.Video;

import java.util.List;
import java.util.Optional;

public interface VideoService {

    List<Video> getAllVideos();

    Optional<Video> addVideo(Video video);
}
