package com.mateush.docker_manager.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.dockerjava.api.model.Image;
import com.mateush.docker_manager.services.DockerImageService;

@RestController
@RequestMapping("/api/images")
public class DockerImagesController {

    private DockerImageService dockerImagesService;

    public DockerImagesController(DockerImageService dockerService) {
        this.dockerImagesService = dockerService;
    }

    @GetMapping("")
    public List<Image> listImage() {
        return dockerImagesService.listImages();
    }

    @GetMapping("/filter")
    public List<Image> filterImage(@RequestParam(required = false, defaultValue = "image-") String imageName) {
        return dockerImagesService.filterImage(imageName);
    }
}