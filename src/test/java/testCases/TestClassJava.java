package testCases;

public class TestClassJava {
	
	public static boolean charInUserName() {
		String name = "Thunder Storm";
		char[] nameArr = name.toCharArray();
		char[] forbiddenCharArr = {'A', 'C', 'G', 'I', 'L', 'K'};
		for(int i=0;i<nameArr.length;i++) {
			for(int j=0;j<forbiddenCharArr.length;j++) {
				if(nameArr[i] == forbiddenCharArr[j]) {
					return false;
				}
			}
		}
		return true;
	}
	
    public static void main(String[] args) {
    	charInUserName();
    }
}






