package it.marczuk.pracadomowa_tydzien6.repository;

import it.marczuk.pracadomowa_tydzien6.entity.Video;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VideoRepo {

    private List<Video> videoList;

    public VideoRepo() {
        this.videoList = new ArrayList<>();
        createListOfVideos();
    }

    public void addVideo(Video video) {
        videoList.add(video);
    }

    public List<Video> getVideoList() {
        return videoList;
    }

    public void createListOfVideos() {
        videoList.add(new Video(1L, "Black Mirror", "Charlie Brooker", 2011));
        videoList.add(new Video(2L, "Mr. Robot", "Sam Esmail", 2015));
        videoList.add(new Video(3L, "Breaking Bad", "Vince Gilligan", 2008));
    }
}
