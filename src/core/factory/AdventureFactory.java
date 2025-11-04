package core.factory;

import core.products.AccessoryPack;
import core.products.Engine;
import core.products.Suspension;
import core.products.Tire;

/**
 * Abstract Factory: define los métodos de creación para cada producto
 * de la familia (motor, neumático, suspensión, accesorios).
 */
public interface AdventureFactory {
    Engine createEngine();
    Tire createTire();
    Suspension createSuspension();
    AccessoryPack createAccessoryPack();
}
