import java.util.Comparator;import java.util.HashMap;import java.util.Map;import java.util.Scanner;import java.util.TreeMap;public class telCount {	public static void main(String[] args) {		Scanner sc = new Scanner(System.in);		HashMap<String, HashMap<String, Integer>> mapmap = new HashMap<String, HashMap<String, Integer>>();		// 홍길동 : { 아무개 : 1 , 이몽룡 : 3 }		StringBuffer sb = new StringBuffer();		StringBuffer temp = new StringBuffer();		HashMap<String, Integer> temptemp = null;		String tem = "";		HashMap<String, Integer> user = new HashMap<String, Integer>();		user.put("박서현", 0);		user.put("김현수", 0);		user.put("이경원", 0);		user.put("박지호", 0);		user.put("정광균", 0);		user.put("박선진", 0);				while (sc.hasNextLine()) {			temp.setLength(0);			tem = sc.nextLine().trim();			temp.append(tem);						if(tem.equals(".")) break;						if (temp.length() != 0) {				if(!user.containsKey(temp.substring(0, 3))) {					temp.setLength(0);					continue;				}				sb.append(temp.substring(0, 3));				user.put(temp.substring(0, 3), user.get(temp.substring(0, 3)) + 1);			}			if (sb.length() == 6) {				if (mapmap.containsKey(sb.substring(0, 3).toString())) {					temptemp = mapmap.get(sb.substring(0, 3).toString());					if (temptemp.containsKey(sb.substring(3, 6))) {						temptemp.put(sb.substring(3, 6).toString(), temptemp.get(sb.substring(3, 6).toString()) + 1);					} else {						temptemp.put(sb.substring(3, 6).toString(), 1);					}					sb.delete(0, 3);				} else {					mapmap.put(sb.substring(0, 3).toString(), new HashMap<String, Integer>());					mapmap.get(sb.substring(0, 3).toString()).put(sb.substring(3, 6).toString(), 1);					sb.delete(0, 3);				}			}					}				int max = 0;		String kkey = "";		for (String key : mapmap.keySet()) {			System.out.print("전사람 : " + key + " 총회수 : " + user.get(key) + " ");			max = 0;						HashMap<String,Integer> map = mapmap.get(key);	        ValueComparator bvc =  new ValueComparator(map);	        TreeMap<String,Integer> sorted_map = new TreeMap<String,Integer>(bvc);	 	 	        sorted_map.putAll(map);	        	        for (Map.Entry<String,Integer> entry : sorted_map.entrySet()) {	            //정렬한 리스트에서 순번을 배열번호로 변경하여 원본 리스트에서 추출	            System.out.print(entry.getKey()+" : "+map.get(entry.getKey()) + " ");	        }	        	        			/*			 * for (Integer keykey : (LinkedList<Integer>)mapmap.get(key).values()) { if(max			 * <= mapmap.get(key).get(keykey)) { max = mapmap.get(key).get(keykey); kkey =			 * keykey; } System.out.print(" " + keykey + " : 호출수 : " +			 * mapmap.get(key).get(keykey) + " "); }			 */			System.out.print(" " + kkey + " : 호출수 : " + max + " ");			System.out.println();		}		sc.nextLine();		sc.close();	}}class ValueComparator implements Comparator<String> {	     Map<String, Integer> base;        public ValueComparator(Map<String, Integer> base) {        this.base = base;    }     // Note: this comparator imposes orderings that are inconsistent with equals.        public int compare(String a, String b) {        if (base.get(a) >= base.get(b)) { //반대로 하면 오름차순 <=            return -1;        } else {            return 1;        } // returning 0 would merge keys    }}