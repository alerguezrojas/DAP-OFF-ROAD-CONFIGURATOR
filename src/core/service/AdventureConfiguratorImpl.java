package core.service;

import core.factory.AdventureFactory;
import core.factory.DesertAdventureFactory;
import core.factory.MountainExpeditionFactory;
import core.factory.UrbanExplorerFactory;
import core.model.AdventureType;
import core.model.ConfigResult;

/**
 * Implementación del configurador: selecciona la fábrica según el tipo de aventura
 * y construye el conjunto completo de componentes.
 */
public class AdventureConfiguratorImpl implements AdventureConfigurator {

    @Override
    public ConfigResult configureAdventure(AdventureType type) {
        AdventureFactory factory = switch (type) {
            case DESERT -> new DesertAdventureFactory();
            case MOUNTAIN -> new MountainExpeditionFactory();
            case URBAN -> new UrbanExplorerFactory();
        };

        return new ConfigResult(
                factory.createEngine(),
                factory.createTire(),
                factory.createSuspension(),
                factory.createAccessoryPack()
        );
    }
}