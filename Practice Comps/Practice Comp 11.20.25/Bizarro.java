import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Bizarro {
	
	public void run() throws Exception{
		Scanner file = new Scanner(new File("bizarro.dat"));
		int times = file.nextInt(), opps = file.nextInt();
		file.nextLine();
		HashMap<String,String> hm1 = new HashMap<String,String>(), hm2 = new HashMap<String,String>(),
				 hm3 = new HashMap<String,String>(), hm4 = new HashMap<String,String>(),
				 hm5 = new HashMap<String,String>(), hm6 = new HashMap<String,String>();
		fill(hm3, hm4);
		for(int u = 0; u < opps * 2; u += 2) {
			String a = file.next(), b = file.next();
			file.nextLine();
			hm1.put(a, "<"+u+">");
			hm5.put("<"+(u)+">", b);
			hm1.put(b, "<"+(u+1)+">");
			hm5.put("<"+(u+1)+">", a);
			a = Character.toUpperCase(a.charAt(0)) + a.substring(1);
			b = Character.toUpperCase(b.charAt(0)) + b.substring(1);
			hm2.put(a, "<"+u+">");
			hm6.put("<"+(u)+">", b);
			hm2.put(b, "<"+(u+1)+">");
			hm6.put("<"+(u+1)+">", a);
		}
		while(times-- > 0) {
			String sentence = file.nextLine().trim();
			//System.out.println(sentence);
			sentence = replace(sentence, hm1, hm2);
			sentence = replace(sentence, hm5, hm6);
			sentence = replace(sentence, hm3, hm4);
			//System.out.println(sentence);
			//System.out.println(sentence);
			sentence = sentence.replaceAll("ing([\\\\.\\\\,\\\\?\\\\! ])", "ed$1");
			//System.out.println(sentence);
			sentence = sentence.replaceAll("ed([\\\\.\\\\,\\\\?\\\\! ])", "ing$1");
			if(Character.isLowerCase(sentence.charAt(0)))
				sentence = Character.toUpperCase(sentence.charAt(0)) + sentence.substring(1);
			System.out.println(sentence);
		}
	}
	
	public String replace(String sentence, HashMap<String, String> hm1, HashMap<String, String> hm2) {
		String sentence2 = sentence;
		for(String st:hm1.keySet())
			sentence2 = sentence2.replaceAll(" "+st+"([\\.(\\, )\\?\\! ])", " "+hm1.get(st)+"$1");
		for(String st:hm2.keySet())
			sentence2 = sentence2.replaceAll(st+"([, ])", hm2.get(st)+"$1");
		return sentence2;
	}
	
	public static void main(String[]args)throws Exception{
		new Bizarro().run();
	}
	
	public void fill(HashMap<String,String> hm1, HashMap<String,String> hm2) {
		hm2.put("Don't", "Do not");
		hm1.put("don't", "do not");
		hm2.put("I", "Me");
		hm2.put("It's", "It is");
		hm2.put("Can't", "Can not");
		hm2.put("Wouldn't", "Would not");
		hm2.put("Not", "Yes");
		hm2.put("Shouldn't", "Should not");
		hm2.put("Couldn't", "Could not");
		hm2.put("Isn't", "Is not");
		hm2.put("Won't", "Will not");
		hm2.put("Could've","Could have");
		hm2.put("We're", "We are");
		hm2.put("Should've", "Should have");
		hm2.put("Would've", "Would have");
		hm2.put("They're", "They are");
		hm2.put("I'm", "I am");
		hm2.put("You're", "You are");
		hm2.put("Doesn't", "Does not");
		hm2.put("I've", "I have");
		hm2.put("They've", "They have");
		hm2.put("Didn't", "Did not");
		hm2.put("Me", "I");
		hm2.put("That's", "That is");
		hm2.put("Let's", "Let us");
		hm2.put("Aren't", "Are not");
		hm2.put("I'd", "I would");
		hm2.put("Are", "Is");
		hm2.put("Is", "Are");
		hm2.put("Am", "Is");
		hm2.put("Yes", "No");
		
		hm1.put("it's", "it is");
		hm1.put("yes", "no");
		hm1.put("not", "yes");
		hm2.put("I'm", "I am");
		hm2.put("I", "me");
		hm2.put("I'd", "I would");
		hm2.put("I've", "I have");
		hm1.put("can't", "can not");
		hm1.put("wouldn't", "would not");
		hm1.put("shouldn't", "should not");
		hm1.put("couldn't", "could not");
		hm1.put("isn't", "is not");
		hm1.put("won't", "will not");
		hm1.put("could've","could have");
		hm1.put("we're", "we are");
		hm1.put("should've", "should have");
		hm1.put("would've", "would have");
		hm1.put("they're", "they are");
		hm1.put("you're", "you are");
		hm1.put("doesn't", "does not");
		hm1.put("they've", "they have");
		hm1.put("didn't", "did not");
		hm1.put("me", "I");
		hm1.put("that's", "that is");
		hm1.put("let's", "let us");
		hm1.put("aren't", "are not");
		hm1.put("are", "is");
		hm1.put("is", "are");
		hm1.put("am", "is");
	}
}