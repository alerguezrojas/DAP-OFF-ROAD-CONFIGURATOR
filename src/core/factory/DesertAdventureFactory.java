package core.factory;

import core.products.AccessoryPack;
import core.products.Engine;
import core.products.Suspension;
import core.products.Tire;

/**
 * Fábrica concreta (ESQUELETO). En Etapa 2 devolverá instancias reales del modo desierto.
 */
public class DesertAdventureFactory implements AdventureFactory {

    @Override
    public Engine createEngine() {
        return null; // Etapa 2: devolver DesertEngine
    }

    @Override
    public Tire createTire() {
        return null; // Etapa 2: devolver DesertTire
    }

    @Override
    public Suspension createSuspension() {
        return null; // Etapa 2: devolver DesertSuspension
    }

    @Override
    public AccessoryPack createAccessoryPack() {
        return null; // Etapa 2: devolver DesertAccessoryPack
    }
}