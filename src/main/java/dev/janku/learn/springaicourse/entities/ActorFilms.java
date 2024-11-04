package dev.janku.learn.springaicourse.entities;

import java.util.List;

public record ActorFilms (String actor, List<String> movies) {
}
