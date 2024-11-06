package net.yyhis.flavormap_map_demo.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReverseGcResponseDto {
    private Status status;
    private List<Result> results;

    @Getter
    @Setter
    @ToString
    public static class Status {
        private int code;
        private String name;
        private String message;
    }

    @Getter
    @Setter
    @ToString
    public static class Result {
        private String name;
        private Code code;
        private Region region;
        private Land land;
    }

    @Getter
    @Setter
    @ToString
    public static class Code {
        private String id;
        private String type;
        private String mappingId;
    }

    @Getter
    @Setter
    @ToString
    public static class Region {
        private Area area0;
        private Area area1;
        private Area area2;
        private Area area3;
        private Area area4;
    }

    @Getter
    @Setter
    @ToString
    public static class Area {
        private String name;
        private Coords coords;
        private String alias;
    }

    @Getter
    @Setter
    @ToString
    public static class Coords {
        private Center center;
    }

    @Getter
    @Setter
    @ToString
    public static class Center {
        private String crs;
        private double x;
        private double y;
    }

    @Getter
    @Setter
    @ToString
    public static class Land {
        private String type;
        private String number1;
        private String number2;
        private List<Addition> additions;
        private Coords coords;
    }

    @Getter
    @Setter
    @ToString
    public static class Addition {
        private String type;
        private String value;
    }
}
