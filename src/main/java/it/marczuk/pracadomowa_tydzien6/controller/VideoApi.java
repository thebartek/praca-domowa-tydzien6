package it.marczuk.pracadomowa_tydzien6.controller;

import it.marczuk.pracadomowa_tydzien6.aspect.EmailSendAnn;
import it.marczuk.pracadomowa_tydzien6.entity.Video;
import it.marczuk.pracadomowa_tydzien6.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/videos")
public class VideoApi {

    private VideoService service;

    @Autowired
    public VideoApi(VideoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Video> getCars() {
        return new ResponseEntity(service.getAllVideos(), HttpStatus.OK);
    }

    @PostMapping
    @EmailSendAnn
    public ResponseEntity<Video> addVideo(@RequestBody Video video) {
        Optional<Video> newVideo = service.addVideo(video);
        return newVideo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }
}
