package core.products;

/**
 * Producto abstracto del patrón: Paquete de accesorios.
 */
public interface AccessoryPack {
    /**
     * @return lista/resumen de accesorios incluidos (por ej., "Winch, baca, compresor")
     */
    String getAccessories();
}
