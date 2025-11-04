package core.service;

import core.model.AdventureType;
import core.model.ConfigResult;

/**
 * Servicio de alto nivel que usa una Abstract Factory interna
 * (la implementación lo decidirá) para producir una configuración completa.
 */
public interface AdventureConfigurator {

    /**
     * Configura un vehículo completo según el tipo de aventura elegido.
     *
     * @param type tipo de aventura (DESERT, MOUNTAIN, URBAN)
     * @return objeto con motor, neumáticos, suspensión y accesorios
     */
    ConfigResult configureAdventure(AdventureType type);
}
