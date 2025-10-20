package com.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8IntegerTest {
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,3,5,-6,8,-9,53,2,1,3,5);
		
		Set<Integer> Unique=new HashSet<>();
		Set<Integer> hs = list.stream().filter(e-> !Unique.add(e)).collect(Collectors.toSet());
		System.out.println("Print duplicates  : "+hs);
		
		List<Integer> hs1 = list.stream().filter(e -> e != 3).collect(Collectors.toList());
	    System.out.println("Print all integer values without 3   : "+hs1);
		
		List<Integer> d= list.stream().filter(i -> String.valueOf(i).startsWith("3")).collect(Collectors.toList());
        System.out.println("starts with 3: "+d);
	    
		Integer hs4=list.stream().sorted(Comparator.reverseOrder()).distinct().skip(1).findFirst().get();
        System.out.println("second highest value : "+hs4);
        
        Integer hs5=list.stream().sorted().distinct().skip(1).findFirst().get();
        System.out.println("second lowest value : "+hs5);
        
        
        List<Integer> r=list.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	    System.err.println("Max to Min : "+r);
	    
	    Map<Integer, Long> counts = list.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting()));
	    System.out.println("occurancy each integer :"+counts);
	    
	    List<Integer> hs2 = list.stream().filter(e-> e % 2!= 0).collect(Collectors.toList());
		System.out.println("odd  : "+hs2);
		
		List<Integer> hs3 = list.stream().filter(e-> e % 2== 0).collect(Collectors.toList());
		System.out.println("Even  : "+hs3);
	     
		Set<Integer> result = list.stream().filter(n->list.indexOf(n)!=list.lastIndexOf(n)).collect(Collectors.toSet());
	    System.out.println("Print duplicates : "+result);
	     
	    List<String> s1=list.stream().map(String::valueOf).filter(e->e.startsWith("3")).collect(Collectors.toList());
	    System.out.println("Starts with 3 :"+s1); 
	    
	    List<Integer> result1 = list.stream().sorted(Comparator.comparingInt(e->e >= 0? 1:0)).collect(Collectors.toList());
	    System.out.println("Negative first :"+result1);
   
			     
	    
	    
			     double avg = list.stream().collect(Collectors.averagingInt(n -> n));   
			     System.out.println("avg :"+avg);
			     
			     int re4=list.stream().reduce((a,b)-> a+b).get();                       
			     System.out.println("count: "+re4);
				 
				 long lss = list.stream().count();                                      
				 System.err.println("sum : "+lss);
			     
			     int ls = list.stream().filter(e->e% 2== 0).mapToInt(e->e).sum();       
			     System.err.println("Even sum : "+ls);
			     
			     long ls1 = list.stream().filter(e -> e != 3).mapToInt(e -> e).sum();   
			     System.out.println("sum without 3 :"+ls1);
			    
			     
	             List<Integer> ls4 = list.stream().filter(e -> e != 3).collect(Collectors.toList()); 
	             System.out.println("print without 3 :"+ls4);
			     
	             List<Integer> s= list.stream().sorted().distinct().collect(Collectors.toList()); 	 
	             System.out.println("Remove duplicates : "+ s);

			        
			     List<Integer> hs7 =list.stream().skip(5).collect(Collectors.toList());      
			     System.out.println("skip first 5 :" + hs7);
			        
			     List<Integer> hs6 =list.stream().limit(5).collect(Collectors.toList());     
			     System.out.println("print first 5 :" + hs6);
			        
			     int count = list.stream().limit(5).reduce((a,b)->a+b).get();                
			     System.out.println("count first 5 :" + count);
			   
			     int count1 = list.stream().skip(list.size()-5).reduce((a,b)->a+b).get();    
			     System.out.println("count last 5 :" + count1);  
			     
			     Optional<Integer> max = list.stream().collect(Collectors.maxBy(Comparator.naturalOrder()));
			     System.out.println("MAX-------------------------------: "+max);
			     
			     Optional<Integer> min = list.stream().collect(Collectors.minBy(Comparator.naturalOrder()));
			     System.out.println("MIN-------------------------------: "+min);
			   
			     // sumOf Integer Values
			     Optional<Integer> sumOfValues = list.stream().reduce((a,b) -> a+b);
			     System.out.println("sumOf Integer Values-------------------------------: "+  sumOfValues);
			     
			     // Average Integer Values
			     double avg1=list.stream().mapToInt(e -> e).average().getAsDouble();
			     System.out.println("Average Integer Values-------------------------------: "+  avg1);
		
	}

}
