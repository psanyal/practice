import java.util.HashMap;
import java.util.Map;

public class TinyUrl {
	
	TinyUrl(){
		Codec codec = new Codec();
		String es = codec.encode("https://leetcode.com/problems/design-tinyurl");
		System.out.println(es);
		System.out.println(codec.decode(es));
	}

	public static void main(String[] args) {
		new TinyUrl();
	}
	
	class Codec {

	    Map<Integer, String> map = new HashMap<Integer, String>();
	    String host = "http://tinyurl.com/";

	    public String encode(String longUrl) {
	      int key = longUrl.hashCode();
	      map.put(key, longUrl);
	      return host+key;
	    }

	    public String decode(String shortUrl) {
	      int key = Integer.parseInt(shortUrl.replace(host,""));
	      return map.get(key);
	    }
	}


}
