package entities;

import lombok.Getter;

import java.util.UUID;

abstract public class Entity {

    @Getter
    private final UUID uuid;

    protected Entity() {
        uuid = UUID.randomUUID();
    }
}
