package snippets;

import java.util.Comparator;

public class AgeComparator implements Comparator<Member>{
public int compare(Member m1, Member m2){
	if (m1.getAge()< m2.getAge()) return -1;
	if (m1.getAge()>m2.getAge()) return +1;
	else return 0;
	
}
}
