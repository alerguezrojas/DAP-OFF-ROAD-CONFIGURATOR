package core.factory;

import core.products.*;
import core.products.impl.urban.*;

public class UrbanExplorerFactory implements AdventureFactory {

    @Override
    public Engine createEngine() {
        return new UrbanEngine();
    }

    @Override
    public Tire createTire() {
        return new UrbanTire();
    }

    @Override
    public Suspension createSuspension() {
        return new UrbanSuspension();
    }

    @Override
    public AccessoryPack createAccessoryPack() {
        return new UrbanAccessoryPack();
    }
}