package core.model;

import core.products.Engine;
import core.products.Tire;
import core.products.Suspension;
import core.products.AccessoryPack;

/**
 * DTO que agrupa los componentes resultantes de una configuración.
 */
public class ConfigResult {
    private final Engine engine;
    private final Tire tire;
    private final Suspension suspension;
    private final AccessoryPack accessoryPack;

    public ConfigResult(Engine engine, Tire tire, Suspension suspension, AccessoryPack accessoryPack) {
        this.engine = engine;
        this.tire = tire;
        this.suspension = suspension;
        this.accessoryPack = accessoryPack;
    }

    public Engine getEngine() {
        return engine;
    }

    public Tire getTire() {
        return tire;
    }

    public Suspension getSuspension() {
        return suspension;
    }

    public AccessoryPack getAccessoryPack() {
        return accessoryPack;
    }

    @Override
    public String toString() {
        return "ConfigResult{" +
                "engine=" + (engine != null ? engine.getType() : "null") +
                ", tire=" + (tire != null ? tire.getTreadType() : "null") +
                ", suspension=" + (suspension != null ? suspension.getSuspensionType() : "null") +
                ", accessoryPack=" + (accessoryPack != null ? accessoryPack.getAccessories() : "null") +
                '}';
    }
}