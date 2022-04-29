package org.example;

import com.example.myprotoproject.GreetingServiceOuterClass;
import org.json.JSONObject;

public class Formatter {

    public static void main(String[] args){
        com.example.myprotoproject.GreetingServiceOuterClass.HelloRequest helloRequest =
                com.example.myprotoproject.GreetingServiceOuterClass.HelloRequest.newBuilder()
                        .setName("Roma")
                        .addHobbies("basketball")
                        .build();

        JSONObject json = new JSONObject();
        json.put("name", "Roma");
        json.put("hobbies", "basketball");

        System.out.println("proto example:\n" + helloRequest);
        System.out.println("json example:\n" + json + "\n");

        Formatter formatter = new Formatter();
        System.out.println("Method toJson test:\n" + formatter.toJson(helloRequest) + "\n");
        System.out.println("Method toProto test:\n" + formatter.toProto(json));
    }

    public GreetingServiceOuterClass.HelloRequest toProto(JSONObject json){
        return GreetingServiceOuterClass.HelloRequest.newBuilder()
                .setName(json.getString("name"))
                .addHobbies(json.getString("hobbies"))
                .build();
    }

    public JSONObject toJson(GreetingServiceOuterClass.HelloRequest helloRequest){
        JSONObject json = new JSONObject();
        json.put("name", helloRequest.getName());
        json.put("hobbies", helloRequest.getHobbiesList());
        return json;
    }
}
