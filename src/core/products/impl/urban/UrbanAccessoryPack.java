package core.products.impl.urban;

import core.products.AccessoryPack;

public class UrbanAccessoryPack implements AccessoryPack {
    @Override
    public String getAccessories() {
        return "GPS, aire acondicionado, sensores de aparcamiento";
    }
}