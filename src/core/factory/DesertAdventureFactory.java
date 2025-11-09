package core.factory;

import core.products.*;
import core.products.impl.desert.DesertEngine;
import core.products.impl.desert.DesertTire;
import core.products.impl.desert.DesertSuspension;
import core.products.impl.desert.DesertAccessoryPack;

public class DesertAdventureFactory implements AdventureFactory {

    @Override
    public Engine createEngine() {
        return new DesertEngine();
    }

    @Override
    public Tire createTire() {
        return new DesertTire();
    }

    @Override
    public Suspension createSuspension() {
        return new DesertSuspension();
    }

    @Override
    public AccessoryPack createAccessoryPack() {
        return new DesertAccessoryPack();
    }
}
