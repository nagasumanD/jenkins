package core.java.volume2.lesson1;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCreation {

	
	public static <T> void show(String title,Stream<T> stream){
		
		System.out.println("title of the steram "+title);
		final int SIZE=10;
		
		List<T> firstelements=stream.limit(SIZE+1).collect(Collectors.toList());
		for(int i=0;i<firstelements.size();i++)
		{
			if(i>0) {
				System.out.print(",");
			}
			if(i<SIZE)
			{
				System.out.print(firstelements.get(i));
			}else {
				System.out.print("...");
			}
			
		}
		
		
	}
	public static void main(String[] args) throws IOException {

		Path path=Paths.get("/xmlsignaturevalidation/Listofwords");
		String content=new String(Files.readAllBytes(path),StandardCharsets.UTF_8);
		
		//Stream.of return the stream from the elements arrays
		Stream<String> fileStream=Stream.of(content.split("\\PL+"));
		show("fileStream",fileStream);
		
		//Stream can be ruturn from the group of string arguments
		Stream<String> object =Stream.of("suman","naga","dhanenkula","pakasam");
		show("object",object);
		
		//we can get empty Stream from Stream.empty()
		Stream<String> emptyStream = Stream.empty();
		show("EmptyStream",emptyStream);
		
		// Generating infinity Stream from Stream.generate(lanbda function that returnt the series)
		Stream<String> infinityStream=Stream.generate(() -> "Echo");
		show("inifinity", infinityStream);
		
		//to generate the sequance stream by using stream.iterate(starting value,labda function to add itself by incrating value
		Stream<BigInteger> sequance=Stream.iterate(BigInteger.ZERO,n -> n.add(BigInteger.ONE));
		show("Seaquance",sequance);
		
		Stream<Double> random=Stream.generate(Math::random);
		show("random",random);
		
		//Pattren.complile().splitasStream() return the stream
		Stream<String> patterns=Pattern.compile("\\PL+").splitAsStream(content);
		show("pattern",patterns);
		
		//Files.lines(path) ruturn a stream of lines
		try(Stream<String> lines=Files.lines(path,StandardCharsets.UTF_8)){
			show("lines",lines);
		}
		
		
		
		
		
	}

}
