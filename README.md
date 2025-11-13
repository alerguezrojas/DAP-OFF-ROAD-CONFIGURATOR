# 🏞️ Adventure Configurator

Adventure Configurator es una aplicación Java diseñada para generar configuraciones completas de aventuras (**Desert**, **Mountain**, **Urban**) utilizando el **patrón Abstract Factory**.  
Incluye también un **servidor HTTP ligero** que expone un endpoint para obtener las configuraciones en formato JSON.

---

## 📁 Estructura del proyecto

La estructura final del proyecto dentro de `src/` es:

```
src/
├── api/
│   └── SimpleHttpServer.java
│
├── core/
│   ├── factory/
│   │   ├── AdventureFactory.java
│   │   ├── DesertAdventureFactory.java
│   │   ├── MountainExpeditionFactory.java
│   │   └── UrbanExplorerFactory.java
│   │
│   ├── model/
│   │   ├── AdventureType.java
│   │   └── ConfigResult.java
│   │
│   ├── products/
│   │   ├── Engine.java
│   │   ├── Tire.java
│   │   ├── Suspension.java
│   │   ├── AccessoryPack.java
│   │   │
│   │   └── impl/
│   │       ├── DesertEngine.java
│   │       ├── MountainEngine.java
│   │       ├── UrbanEngine.java
│   │       ├── DesertSuspension.java
│   │       ├── MountainSuspension.java
│   │       ├── UrbanSuspension.java
│   │       ├── DesertTire.java
│   │       ├── MountainTire.java
│   │       ├── UrbanTire.java
│   │       ├── DesertAccessoryPack.java
│   │       ├── MountainAccessoryPack.java
│   │       └── UrbanAccessoryPack.java
│   │
│   └── service/
│       ├── AdventureConfigurator.java
│       └── AdventureConfiguratorImpl.java
```

---

## 🧭 Descripción general

Este proyecto genera configuraciones completas para diferentes tipos de aventuras en base a una arquitectura bien estructurada:

- Una **fábrica** por tipo de aventura  
- Un conjunto de **productos** (Engine, Tire, Suspension, AccessoryPack)  
- Un **configurador** que selecciona dinámicamente la fábrica correcta  
- Un **servidor HTTP** que expone un endpoint para solicitar configuraciones  

---

## 🧱 Patrón de diseño: Abstract Factory

El patrón Abstract Factory permite:

- Crear familias de objetos relacionados sin acoplarlos  
- Facilitar la extensibilidad del sistema  
- Garantizar que los componentes generados pertenezcan a la misma familia  
- Mantener un diseño limpio, mantenible y escalable  

Diagrama conceptual simplificado:

```
AdventureConfigurator
        └── AdventureFactory
              ├── DesertAdventureFactory
              ├── MountainExpeditionFactory
              └── UrbanExplorerFactory
```

Cada fábrica crea:

- Engine  
- Suspension  
- Tire  
- AccessoryPack  

---

## 🚀 Ejemplo de uso

```java
AdventureConfigurator configurator = new AdventureConfiguratorImpl();

ConfigResult result = configurator.configureAdventure(AdventureType.DESERT);

System.out.println(result.toJson());
```

Ejemplo de salida:

```json
{
  "adventureType": "DESERT",
  "engine": "DesertEngine: optimized for extreme heat",
  "suspension": "DesertSuspension: soft high-travel",
  "tire": "DesertTire: sand-optimized",
  "accessories": "DesertAccessoryPack: hydration + tools"
}
```

---

## 🌐 API HTTP

La clase `SimpleHttpServer` expone un endpoint:

### ▶️ Iniciar el servidor

```bash
java api/SimpleHttpServer
```

### Endpoint

```
GET /configure?adventure=DESERT
GET /configure?adventure=MOUNTAIN
GET /configure?adventure=URBAN
```

### Ejemplo de uso:

```bash
curl "http://localhost:8000/configure?adventure=URBAN"
```

---

## ▶️ Compilación y ejecución

Compilar:

```bash
javac src/**/*.java
```

Ejecutar servidor:

```bash
java src/api/SimpleHttpServer
```

---

## 🧩 Cómo extender el sistema

1. Añadir una nueva opción en `AdventureType`.
2. Crear nuevos productos dentro de `core/products/impl/`:
   - `NewEngine.java`
   - `NewSuspension.java`
   - `NewTire.java`
   - `NewAccessoryPack.java`
3. Crear `NewAdventureFactory.java` en `core/factory/`.
4. Registrar la nueva fábrica en `AdventureConfiguratorImpl`.
