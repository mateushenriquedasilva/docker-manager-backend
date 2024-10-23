package com.mateush.docker_manager.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.dockerjava.api.model.Container;
import com.mateush.docker_manager.services.DockerContainerService;

@RestController
@RequestMapping("/api/containers")
public class DockerContainerController {
    private DockerContainerService dockerService;

    public DockerContainerController(DockerContainerService dockerService) {
        this.dockerService = dockerService;
    }

    @GetMapping
    public List<Container> listContainers(@RequestParam(required = false, defaultValue = "true") Boolean showAll) {
        return dockerService.listContainers(showAll);
    }

    @PostMapping("/{imageId}/create")
    public void createContainer(@PathVariable String imageId) {
        dockerService.createContainer(imageId);
    }

    @PostMapping("/{id}/start")
    public void startContainer(@PathVariable String id) {
        dockerService.startContainer(id);
    }

    @PostMapping("/{id}/stop")
    public void stopContainer(@PathVariable String id) {
        dockerService.stopContainer(id);
    }

    @DeleteMapping("/{id}")
    public void removeContainer(@PathVariable String id) {
        dockerService.removeContainer(id);
    }
}
