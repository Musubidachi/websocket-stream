package io.streaming.project.model;

import java.util.List;

import lombok.Data;

@Data
public class RandomUserResponse {
    private List<User> results;
    private Info info;
}
