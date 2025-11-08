package core.factory;

import core.products.AccessoryPack;
import core.products.Engine;
import core.products.Suspension;
import core.products.Tire;

/**
 * Fábrica concreta (ESQUELETO). En Etapa 2 devolverá instancias reales del modo montaña.
 */
public class MountainExpeditionFactory implements AdventureFactory {

    @Override
    public Engine createEngine() {
        return null; // Etapa 2: devolver MountainEngine
    }

    @Override
    public Tire createTire() {
        return null; // Etapa 2: devolver MountainTire
    }

    @Override
    public Suspension createSuspension() {
        return null; // Etapa 2: devolver MountainSuspension
    }

    @Override
    public AccessoryPack createAccessoryPack() {
        return null; // Etapa 2: devolver MountainAccessoryPack
    }
}