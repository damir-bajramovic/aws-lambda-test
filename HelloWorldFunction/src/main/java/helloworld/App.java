package helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

/**
 * Handler for requests to Lambda function.
 */
public class App implements
//        RequestHandler<Map<String,String>, String>{
//        RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
          RequestHandler<Integer, String>{

//    public APIGatewayProxyResponseEvent handleRequest(final APIGatewayProxyRequestEvent input, final Context context) {
//        Map<String, String> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//        headers.put("X-Custom-Header", "application/json");
//
//        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent()
//                .withHeaders(headers);
//        try {
//            final String pageContents = this.getPageContents("https://checkip.amazonaws.com");
//            String output = String.format("{ \"message\": \"hello world\", \"location\": \"%s\", \"message\": \"clover\" }", pageContents);
//
//            return response
//                    .withStatusCode(200)
//                    .withBody(output);
//        } catch (IOException e) {
//            return response
//                    .withBody("{}")
//                    .withStatusCode(500);
//        }
//    }



//    @Override
//    public String handleRequest(Map<String,String> event, Context context)
//    {
////        LambdaLogger logger = context.getLogger();
//        String response = new String("200 OK");
//        // log execution details
////        logger.log("ENVIRONMENT VARIABLES: " + gson.toJson(System.getenv()));
////        logger.log("CONTEXT: " + gson.toJson(context));
////        // process event
////        logger.log("EVENT: " + gson.toJson(event));
////        logger.log("EVENT TYPE: " + event.getClass().toString());
//        return response;
//    }


    public String handleRequest(Integer myCount, Context context) {
        return String.valueOf(myCount);
    }

    private String getPageContents(String address) throws IOException{
        URL url = new URL(address);
        try(BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return br.lines().collect(Collectors.joining(System.lineSeparator()));
        }
    }
}
