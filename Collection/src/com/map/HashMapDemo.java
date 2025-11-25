package com.map;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Hashtable;
public class HashMapDemo {

	public static void main(String[] args) {
		
		
		
		
		//HashMap <String,String> map  = new HashMap<String ,String>();
		//HashMap<String ,String> map= new HashMap<String ,String>();
//		map.put("Sachin", "Cricketer");
//		map.put("Addi", "Youtuber");
//		System.out.println(map);
//		System.out.println(map.get("Addi"));
//		map.replace("Addi", "Developer");
//		System.out.println(map);
//		//map.remove("Addi");
//		map.put("Addi", "Youtuber");
//		System.out.println(map);
//		map.put("Sachin", "Cricketer");
//		map.put("Tanuraj", "Developer");
//		map.put("Bhushan", "Architecture");
		//Iterate the map
//		Set<Entry<String, String>> entrySet = map.entrySet();
//		for( Entry<String, String> set: entrySet) {
//			System.out.println(set.getKey()+ " = "+set.getValue());
//		}
//		System.out.println(map.keySet());//only keys are give
//		System.out.println(map.values());// only values
//		System.out.println(map.containsKey("Tanuraj"));
//		System.out.println(map.containsValue("Developer"));
//		map.clear();
//		System.out.println(map);
//		System.out.println(map.isEmpty());
		
		
		
		//LinkedHashMap
		//LinkedHashMap is same as HashMap but i follows insertion order,LinkedhashMap extends HashMap 
		
//		LinkedHashMap<Integer,String> lmap= new LinkedHashMap<Integer,String>();
//		lmap.put(1,"Tanuraj" );
//		lmap.put(2,"Bhushan");
//		lmap.put(3,"Suyog");
//		System.out.println(lmap);
		
		
		//TreeMap
		//TreeMap will sort the data using Key
		//TreeMap  can not contain  null key  because sorting time it will copare only key not null 
//		TreeMap<Integer,String> tmap= new TreeMap<>();
//		tmap.put(46, "Karan");
//		tmap.put(78, "bugati");
//		tmap.put(1, "tesla");
//		System.out.println(tmap);
		
		
		//HashTable
		//It is legacy class(old version)1.0 class
		//It is Synchronized class
		//It is threadSafe class 
		//It can not contain any null key or value 
		Hashtable <Integer,String> ht =new Hashtable<>();
		ht.put(4,"purogami");
		ht.put(2, "sarswati");
		System.out.println(ht);
		
		
		}
}
