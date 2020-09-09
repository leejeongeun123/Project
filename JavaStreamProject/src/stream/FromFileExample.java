package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FromFileExample {
	public static void main(String[] args) {
		String file = "src/stream/StreamExample.java"; 
		Path path = Paths.get(file); //위치의 값을 읽어옴.
		try {
			Stream<String> stream = Files.lines(path); //예외처리 
			stream.forEach(s -> System.out.println(s));
			stream.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
				
	}
}

