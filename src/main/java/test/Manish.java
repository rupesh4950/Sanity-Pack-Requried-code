package test;
//
//public class Manish {
//	public static void main(String[] args) {
//		check("asdf");
//	}
//
//	private static void check(String s) {
//		String c[]= {"ab","cde","fgh","ijk","lmn","opq","rst","uvw","xyz"};
//		int inc=0;
//		int count=0;
//		for(int i=0;i<s.length();i++) {
//			inc=i;
//			for(int j=0;j<s.length()-i;j++) {
//				String a=(s.substring(j,j+i+1));
//				String val[]=a.split("");
//				int sum=0;
//				for(int k=0;k<val.length;k++) {
//					int value=0;
//					for(int p=0;p<c.length;p++) {
//						if(c[p].contains(val[k])) {
//							sum+=(p+1);
//							break;
//						}
//					}
//				}
//				if(sum%val.length==0) {
//					count++;
//				}
//			}	
//		}
//		System.out.println(count);
//		
//	}
//}
public class Manish {
    public static void main(String[] args) {
        // Sample input string
        String input_str = "asdf";
        // Call the function and print the result
        System.out.println(countSubstrings(input_str));
    }

    public static int countSubstrings(String input_str) {
        // Initialize a variable to store the count of extraordinary substrings
        int count = 0;
        // Loop through each possible substring
        for (int i = 0; i < input_str.length(); i++) {
            for (int j = i + 1; j <= input_str.length(); j++) {
                // Extract the current substring
                String substring = input_str.substring(i, j);
                // Calculate the sum of mapped values of each letter in the substring
                int sum = 0;
                for (char c : substring.toCharArray()) {
                	
                    sum += c - 'a' + 1;
                }
                // Check if the sum is divisible by the length of the substring
                if (sum % substring.length() == 0) {
                    // If divisible, increment the count
                    count++;
                }
            }
        }
        // Return the total count of extraordinary substrings
        return count;
    }
}