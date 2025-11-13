package api;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import core.model.AdventureType;
import core.model.ConfigResult;
import core.service.AdventureConfigurator;
import core.service.AdventureConfiguratorImpl;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class SimpleHttpServer {

    private static final AdventureConfigurator configurator = new AdventureConfiguratorImpl();

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/api/adventure/configure/", new ConfigureHandler());
        server.createContext("/api/adventure/types", new TypesHandler());

        server.setExecutor(null);
        server.start();

        System.out.println("===========================================");
        System.out.println("🚀 Servidor iniciado en http://localhost:8080");
        System.out.println("===========================================");
        System.out.println("Endpoints disponibles:");
        System.out.println("  GET /api/adventure/configure/{type}");
        System.out.println("  GET /api/adventure/types");
        System.out.println("===========================================");
        System.out.println("\n✨ Ahora abre el archivo index.html en tu navegador");
    }

    static class ConfigureHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
            exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, OPTIONS");
            exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type");
            exchange.getResponseHeaders().add("Content-Type", "application/json");

            if ("OPTIONS".equals(exchange.getRequestMethod())) {
                exchange.sendResponseHeaders(200, -1);
                return;
            }

            String path = exchange.getRequestURI().getPath();
            String type = path.substring(path.lastIndexOf('/') + 1).toUpperCase();

            String response;
            int statusCode;

            try {
                AdventureType adventureType = AdventureType.valueOf(type);
                ConfigResult result = configurator.configureAdventure(adventureType);

                response = String.format(
                        "{\"success\":true,\"adventureType\":\"%s\",\"configuration\":{" +
                                "\"engine\":\"%s\"," +
                                "\"tire\":\"%s\"," +
                                "\"suspension\":\"%s\"," +
                                "\"accessories\":\"%s\"}}",
                        adventureType.name(),
                        escapeJson(result.getEngine().getType()),
                        escapeJson(result.getTire().getTreadType()),
                        escapeJson(result.getSuspension().getSuspensionType()),
                        escapeJson(result.getAccessoryPack().getAccessories())
                );
                statusCode = 200;
                System.out.println("✅ Configuración generada para: " + type);

            } catch (IllegalArgumentException e) {
                response = String.format(
                        "{\"success\":false,\"error\":\"Tipo de aventura no válido: %s\"}",
                        type
                );
                statusCode = 400;
                System.out.println("❌ Error: tipo inválido " + type);
            }

            byte[] responseBytes = response.getBytes(StandardCharsets.UTF_8);
            exchange.sendResponseHeaders(statusCode, responseBytes.length);

            OutputStream os = exchange.getResponseBody();
            os.write(responseBytes);
            os.close();
        }
    }

    static class TypesHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
            exchange.getResponseHeaders().add("Content-Type", "application/json");

            String response = "{\"success\":true,\"types\":[\"DESERT\",\"MOUNTAIN\",\"URBAN\"]}";
            byte[] responseBytes = response.getBytes(StandardCharsets.UTF_8);

            exchange.sendResponseHeaders(200, responseBytes.length);
            OutputStream os = exchange.getResponseBody();
            os.write(responseBytes);
            os.close();
        }
    }

    private static String escapeJson(String text) {
        if (text == null) return "";
        return text.replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }
}