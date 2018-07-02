package exercises;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class InputSources {

    public static void main(String[] args) {

        int n = args.length;
        if (n > 0) {
            for (int i = 0; i < n; i++)
                System.out.println("Argument [" + i + "] = " + args[i]);
        } else {
            System.out.println("There are no arguments");
        }

        // INPUT FROM COMMAND LINE
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String username = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.print("Enter your money as a float: ");
        float money = scanner.nextFloat();


        System.out.println(String.format("%s, your age is %d and you have %f euros", username, age, money));


        // READ FROM FILE
        // METHOD 1
        String fileName = "assets/example.txt";
        try {
            Stream<String> lines = Files.lines(Paths.get(fileName));
            System.out.println("<!-- METHOD 1 --!>");
            lines.forEach(System.out::println);
            lines.close();
        } catch (IOException io) {
            io.printStackTrace();
        }
        // METHOD 2
        try {
            BufferedReader br = Files.newBufferedReader(Paths.get(fileName));
            Stream<String> lines = br.lines();//.map(str -> str.toUpperCase());
            System.out.println("<!-- METHOD 2 --!>");
            lines.forEach(System.out::println);
            lines.close();
        } catch (IOException io) {
            io.printStackTrace();
        }

        // FYI: Write to a File
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            System.out.print("What do you want to add to the file? ");
            writer.append(scanner.nextLine());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // WEBERVICES
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpUriRequest request = RequestBuilder.get()
                    .setUri("https://reqres.in/api/users")
                    .setHeader("Accept", "application/json")
                    .setHeader("Content-type", "application/json")
                    .build();

            HttpResponse response = client.execute(request);

            System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

            BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            Stream<String> lines = br.lines();
            lines.forEach(System.out::println);
            lines.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
