package core.factory;

import core.products.AccessoryPack;
import core.products.Engine;
import core.products.Suspension;
import core.products.Tire;

/**
 * Fábrica concreta (ESQUELETO). En Etapa 2 devolverá instancias reales del modo urbano.
 */
public class UrbanExplorerFactory implements AdventureFactory {

    @Override
    public Engine createEngine() {
        return null; // Etapa 2: devolver UrbanEngine
    }

    @Override
    public Tire createTire() {
        return null; // Etapa 2: devolver UrbanTire
    }

    @Override
    public Suspension createSuspension() {
        return null; // Etapa 2: devolver UrbanSuspension
    }

    @Override
    public AccessoryPack createAccessoryPack() {
        return null; // Etapa 2: devolver UrbanAccessoryPack
    }
}