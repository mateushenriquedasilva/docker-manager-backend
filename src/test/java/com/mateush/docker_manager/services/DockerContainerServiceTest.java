package com.mateush.docker_manager.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.ListContainersCmd;
import com.github.dockerjava.api.command.RemoveContainerCmd;
import com.github.dockerjava.api.command.StartContainerCmd;
import com.github.dockerjava.api.command.StopContainerCmd;
import com.github.dockerjava.api.model.Container;

import jakarta.ws.rs.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

class DockerContainerServiceTest {

    @Mock
    private DockerClient dockerClient;

    @Mock
    private ListContainersCmd listContainersCmd;

    @Mock
    private StartContainerCmd startContainerCmd;

    @Mock
    private StopContainerCmd stopContainerCmd;

    @Mock
    private RemoveContainerCmd removeContainerCmd;

    @InjectMocks
    private DockerContainerService dockerContainerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Testa se o metodo consulta os containers quando o parametro all é true")  
    public void testListContainersShowAllTrue() {
        // Arrange
        List<Container> mockContainers = Collections.emptyList();

        when(dockerClient.listContainersCmd()).thenReturn(listContainersCmd);
        when(listContainersCmd.withShowAll(true)).thenReturn(listContainersCmd);
        when(listContainersCmd.exec()).thenReturn(mockContainers);

        // Act
        List<Container> result = dockerContainerService.listContainers(true);

        // Assert
        assertEquals(mockContainers, result);
        verify(dockerClient).listContainersCmd();
        verify(listContainersCmd).withShowAll(true);
        verify(listContainersCmd).exec();
    }

    @Test
    @DisplayName("Testa se o metodo consulta os containers quando o parametro all é false")  
    public void testListContainersShowAllFalse() {
        // Arrange
        List<Container> mockContainers = Collections.emptyList();

        when(dockerClient.listContainersCmd()).thenReturn(listContainersCmd);
        when(listContainersCmd.withShowAll(false)).thenReturn(listContainersCmd);
        when(listContainersCmd.exec()).thenReturn(mockContainers);

        // Act
        List<Container> result = dockerContainerService.listContainers(false);

        // Assert
        assertEquals(mockContainers, result);
        verify(dockerClient).listContainersCmd();
        verify(listContainersCmd).withShowAll(false);
        verify(listContainersCmd).exec();
    }

    @Test
    @DisplayName("Testa se o metodo inicia um container")
    public void testStartContainer() {
        // Arrange
        String containerId = UUID.randomUUID().toString();
        
        when(dockerClient.startContainerCmd(containerId)).thenReturn(startContainerCmd);

        // Act
        dockerContainerService.startContainer(containerId);

        // Assert
        verify(dockerClient).startContainerCmd(containerId);
        verify(startContainerCmd).exec();
    }

    @Test
    @DisplayName("Testa se o metodo lança uma exceção quando o container não é encontrado")
    public void testStartContainerThrowExeptionIfContainerNotFound() {
        // Arrange
        String containerId = UUID.randomUUID().toString();
        
        when(dockerClient.startContainerCmd(containerId)).thenReturn(startContainerCmd);
        when(startContainerCmd.exec()).thenThrow(new NotFoundException("Container not found"));

        // Act
        assertThrows(NotFoundException.class, () -> dockerContainerService.startContainer(containerId));

        // Assert
        verify(dockerClient).startContainerCmd(containerId);
        verify(startContainerCmd).exec();
    }

    @Test
    @DisplayName("Testa se o metodo para um container")
    public void testStopContainer() {
        // Arrange
        String containerId = UUID.randomUUID().toString();
        
        when(dockerClient.stopContainerCmd(containerId)).thenReturn(stopContainerCmd);

        // Act
        dockerContainerService.stopContainer(containerId);

        // Assert
        verify(dockerClient).stopContainerCmd(containerId);
        verify(stopContainerCmd).exec();
    }

    @Test
    @DisplayName("Testa se o metodo lança uma exceção quando o container não é encontrado")
    public void testStopContainerThrowExeptionIfContainerNotFound() {
        // Arrange
        String containerId = UUID.randomUUID().toString();
        
        when(dockerClient.stopContainerCmd(containerId)).thenReturn(stopContainerCmd);
        when(stopContainerCmd.exec()).thenThrow(new NotFoundException("Container not found"));

        // Act
        assertThrows(NotFoundException.class, () -> dockerContainerService.stopContainer(containerId));

        // Assert
        verify(dockerClient).stopContainerCmd(containerId);
        verify(stopContainerCmd).exec();
    }

    @Test
    @DisplayName("Testa se o metodo remove um container")
    public void testRemoveContainer() {
        // Arrange
        String containerId = UUID.randomUUID().toString();
        
        when(dockerClient.removeContainerCmd(containerId)).thenReturn(removeContainerCmd);

        // Act
        dockerContainerService.removeContainer(containerId);

        // Assert
        verify(dockerClient).removeContainerCmd(containerId);
        verify(removeContainerCmd).exec();
    }

    @Test
    @DisplayName("Testa se o metodo lança uma exceção quando o container não é encontrado")
    public void testRemoveContainerThrowExeptionIfContainerNotFound() {
        // Arrange
        String containerId = UUID.randomUUID().toString();
        
        when(dockerClient.removeContainerCmd(containerId)).thenReturn(removeContainerCmd);
        when(removeContainerCmd.exec()).thenThrow(new NotFoundException("Container not found"));

        // Act
        assertThrows(NotFoundException.class, () -> dockerContainerService.removeContainer(containerId));

        // Assert
        verify(dockerClient).removeContainerCmd(containerId);
        verify(removeContainerCmd).exec();
    }
}
