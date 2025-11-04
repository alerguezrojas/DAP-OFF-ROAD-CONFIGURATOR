package core.products;

/**
 * Producto abstracto del patrón: Neumático.
 */
public interface Tire {
    /**
     * @return tipo de dibujo/uso del neumático (por ej., "Mud Terrain", "All Season")
     */
    String getTreadType();
}
