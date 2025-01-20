package io.streaming.project.model;

import lombok.Data;

@Data
public class Info {
    private String seed;
    private int results;
    private int page;
    private String version;
}

