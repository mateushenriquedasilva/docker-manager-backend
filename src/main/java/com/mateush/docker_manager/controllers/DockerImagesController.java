package com.mateush.docker_manager.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.dockerjava.api.model.Image;
import com.mateush.docker_manager.services.DockerService;

@RestController
@RequestMapping("/api/images")
public class DockerImagesController {

    private DockerService dockerService;

    public DockerImagesController(DockerService dockerService) {
        this.dockerService = dockerService;
    }

    @GetMapping
    public List<Image> listImage() {
        return dockerService.listImages();
    }

    @GetMapping("/filter")
    public Image filterImage(@RequestParam(required = false, defaultValue = "image-") String imageName) {
        return dockerService.filterImage(imageName).get(0);
    }
}