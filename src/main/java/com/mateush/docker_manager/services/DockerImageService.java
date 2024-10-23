package com.mateush.docker_manager.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Image;

@Service
public class DockerImageService {
    private final DockerClient dockerClient;

    public DockerImageService(DockerClient dockerClient) {
        this.dockerClient = dockerClient;
    }

    // list all images
    public List<Image> listImages() {
        return dockerClient.listImagesCmd().exec();
    }

    // list image by name
    public List<Image> filterImage(String imageName) {
        return dockerClient.listImagesCmd().withImageNameFilter(imageName).exec();
    }
}