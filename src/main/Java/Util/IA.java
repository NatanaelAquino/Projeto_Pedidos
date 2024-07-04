package main.Java.Util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.mysql.cj.xdevapi.DbDoc;
import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonParser;
import com.mysql.cj.xdevapi.JsonValue;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class IA {

    public void ia(String text, JTextArea jTextArea2) {
        String menu = """
            LANCHES:
              Picanha Bloomin Burger:
                - Burger picanha 200g
                - pão tipo brioche 
                - pétalas de Bloomin’ Onion
                - bacon grelhado 
                - molho Flame 
                - queijo tipo emmental 
                - Smoked Mayo
    
              Catupiry Madness Burger:
                - hambúrguer de 200g 
                - Catupiry® empanado
                - maionese verde Outback
                - Smoked Mayo 
                - picles de cebola roxa
                - pão tipo brioche
    
              Epic Cheddar Bunger:
                - hambúrguer de 200g 
                - queijo tipo ementhal e molho cheddar
                - bacon crocante 
                - Smoked Mayo 
                - cebolas caramelizadas 
                - pão tipo brioche
    
              Truffled Burger:
                - hambúrguer de 200g
                - pão tipo brioche
                - queijo cheddar
                - bacon
                - Bloom Petals 
                - Maionese trufada com azeite aromatizado com trufas
    
              Aussie Plant:
                - burger 100% vegetal 200g
                - molho vegetal tipo cheddar
                - alface 
                - tomate
                - cebola
                - picles 
                - pão brioche
    
              Veggie Blue Chees Burger:
                - Hambúrguer vegetariano empanado à base de brócolis
                - couve-flor
                - queijo gorgonzola, coberto por um mix de queijos derretidos 
                - molho de gorgonzola
                - smoked mayo
                - alface
                - tomate 
                - picles de pepino 
                - pão tipo brioche
    
            SOBREMESAS:
              S'mores Outback:
                - cookies com gotas de chocolate
                - pasta cremosa de Kit Kat
                - marshmallow gratinado
                - calda de chocolate 
                - pedaços de Kit Kat
    
              Super milkshake:
                - leite 
                - chocolate
    
              Chocolate Thunder From Down Under:
                - brownie 
                - sorvete de baunilha 
                - calda de chocolate 
                - chantilly e raspas de chocolate.
    
            APERITIVOS:
              Bloomin' Tower:
                - fritas
                - fonduta de queijo 
                - camarões empanados 
                - molho Billa Ranch
                - molho Bloom Ranch
              Veggie Crispy Nachos:
    
              Big Five Boomerang:
                - tortillas de milho 
                - molho vegetal tipo cheddar 
                - PlantPlus moído 100% vegetal 
                - molho vegetal tipo cheddar.
    
              Aussie Cheese Fries:
                - fritas 
                - queijos
                - bacon
                - molho Ranch.
                - Cheese Ranch Sauce.
            """;
        
        HttpClient client = HttpClient.newHttpClient();
        String key = "?key=AIzaSyCToWuyT0zvau_fBtQVNkZ8-0wfiUyhU7g";
        URI url = URI.create("https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent" + key);
        String jsonBody = String.format("""
                {
                  "contents": [
                    {
                      "parts": [
                        {
                          "text": "%s ESSE E O CARDÁPIO, escolha uma dessas opções:%n%s. Responda em texto plano, seja criativa. Até 2 linhas."
                        }
                      ]
                    }
                  ]
                }
                """, text, menu);
                
        HttpRequest request = HttpRequest.newBuilder(url)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            DbDoc json = JsonParser.parseDoc(response.body());
            JsonArray candidates = (JsonArray) json.get("candidates");
            JsonValue candidateDoc = candidates.get(0);
            DbDoc candidateJson = JsonParser.parseDoc(candidateDoc.toString());
            JsonValue contentDoc = candidateJson.get("content");
            DbDoc contentJson = JsonParser.parseDoc(contentDoc.toString());
            JsonArray parts = (JsonArray) contentJson.get("parts");
            JsonValue partDoc = parts.get(0);
            DbDoc partJson = JsonParser.parseDoc(partDoc.toString());
            String generatedText = partJson.get("text").toString().replaceAll("\"", "");
            jTextArea2.setText(generatedText);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
