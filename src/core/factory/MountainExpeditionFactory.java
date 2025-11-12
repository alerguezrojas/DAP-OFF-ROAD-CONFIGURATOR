package core.factory;

import core.products.AccessoryPack;
import core.products.Engine;
import core.products.Suspension;
import core.products.Tire;
import core.products.impl.mountain.MountainAccessoryPack;
import core.products.impl.mountain.MountainEngine;
import core.products.impl.mountain.MountainSuspension;
import core.products.impl.mountain.MountainTire;

public class MountainExpeditionFactory implements AdventureFactory {

    @Override
    public Engine createEngine() {
        return new MountainEngine();
    }

    @Override
    public Tire createTire() {
        return new MountainTire();
    }

    @Override
    public Suspension createSuspension() {
        return new MountainSuspension();
    }

    @Override
    public AccessoryPack createAccessoryPack() {
        return new MountainAccessoryPack();
    }
}