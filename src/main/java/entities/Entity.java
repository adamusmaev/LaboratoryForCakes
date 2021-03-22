package entities;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

abstract public class Entity {

    @Getter
    @Setter
    private UUID uuid;

    protected Entity() {
        uuid = UUID.randomUUID();
    }
}
