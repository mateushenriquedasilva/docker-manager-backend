package com.mateush.docker_manager.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.Image;

@Service
public class DockerService {
    private final DockerClient dockerClient;

    public DockerService(DockerClient dockerClient) {
        this.dockerClient = dockerClient;
    }

    // list all containers
    public List<Container> listContainers(Boolean all) {
        return dockerClient.listContainersCmd().withShowAll(all).exec();
    }

    // list all images
    public List<Image> listImages() {
        return dockerClient.listImagesCmd().exec();
    }

    // list image by name
    public List<Image> filterImage(String imageName) {
        return dockerClient.listImagesCmd().withImageNameFilter(imageName).exec();
    }

    // create a container
    public void startContainer(String containerId) {
        dockerClient.startContainerCmd(containerId).exec();
    }

    // stop a container
    public void stopContainer(String containerId) {
        dockerClient.stopContainerCmd(containerId).exec();
    }

    // remove a container
    public void removeContainer(String containerId) {
        dockerClient.removeContainerCmd(containerId).exec();
    }

    // create a container
    public void createContainer(String imageId) {
        dockerClient.createContainerCmd(imageId).exec();
    }
}
