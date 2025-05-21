public class Consulta_Moneda {

    Moneda buscarMoneda(string moneda,
                        string monedaConversion,
                        double cantidad){

        URI direccion = URI.create("GET https://v6.exchangerate-api.com/v6/aqui-va-tu-api/pair/"+moneda+"/"+monedaConversion+"/"+cantidad);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> response = null;
        try{
            response=client
                    .send(request,HttpResponse.BodyHandlers.ofString());
        } catch(IOException | InterruptedException e){
            throw new RuntimeException(e);
        }


        return new Gson().fromJson(response.body(), Moneda.class);
    }
}
