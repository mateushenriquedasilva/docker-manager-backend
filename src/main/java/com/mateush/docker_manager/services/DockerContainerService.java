package com.mateush.docker_manager.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;

@Service
public class DockerContainerService {
    private final DockerClient dockerClient;

    public DockerContainerService(DockerClient dockerClient) {
        this.dockerClient = dockerClient;
    }

    // list all containers
    public List<Container> listContainers(Boolean all) {
        return dockerClient.listContainersCmd().withShowAll(all).exec();
    }

    // start a container
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
