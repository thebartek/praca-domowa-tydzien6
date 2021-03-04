package it.marczuk.pracadomowa_tydzien6.service;

import it.marczuk.pracadomowa_tydzien6.entity.Video;
import it.marczuk.pracadomowa_tydzien6.repository.VideoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoServiceImpl implements VideoService {

    private VideoRepo repository;

    @Autowired
    public VideoServiceImpl(VideoRepo repository) {
        this.repository = repository;
    }

    @Override
    public List<Video> getAllVideos() {
        return repository.getVideoList();
    }

    @Override
    public Optional<Video> addVideo(Video video) {
        List<Video> videoList = getAllVideos();
        boolean isVideoExists = videoList.stream().anyMatch(newVideo -> newVideo.getTitle().equals(video.getTitle()));
        return isVideoExists ? Optional.empty() : Optional.of(saveVideo(video));
    }

    private Video saveVideo(Video video) {
        repository.addVideo(video);
        return video;
    }
}
