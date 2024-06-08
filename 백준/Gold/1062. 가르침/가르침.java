import java.io.*;
import java.util.*;
public class Main {
	static int N,K,result = Integer.MIN_VALUE;
	static boolean[] alphabet = new boolean[26];	//배운 알파벳 확인 배열
	static ArrayList<String> word = new ArrayList<>();	//입력되는 단어 저장 리스트
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        	//입력값 처리하는 BufferedReader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        	//결과값 출력하는 BufferedWriter
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		alphabetInit();	//'a', 'c', 'i', 'n', 't' 배웠다고 초기화
		if(K<5)		//배울 수 있는 글자가 5개 이하일 때
			bw.write("0");
		else if(K==26)	//배울 수 있는 글자가 26개일 때
			bw.write(N + "\n");
		else {		//그 사이일 때
        	//입력되는 남극 언어 저장
			for(int i=0;i<N;i++) {
				String temp = br.readLine();
				temp.replace("anta", "");
				temp.replace("tica", "");
				word.add(temp);
			}
			cal(1,5);	//모든 경우의 수에서 읽을 수 있는 단어 최대 수 구하는 함수
			bw.write(result + "\n");	//최대값 BufferedWriter 저장
		}
		bw.flush();		//결과 출력
		bw.close();
		br.close();
	}
    	//재귀로 알파벳을 배우는 모든 경우를 구하는 함수
	static void cal(int alpha,int cur) {
		if(cur==K) {
			wordCheck();
			return ;
		}
		for(int i=alpha;i<26;i++) {
			if(alphabet[i])
				continue;
			alphabet[i] = true;
			cal(i,cur+1);
			alphabet[i] = false;
		}
		return;
	}
    	//배운 알파벳으로 단어를 몇 개 읽을 수 있는지 확인하는 함수
	static void wordCheck() {
		int count = 0;
		for(int i=0;i<word.size();i++) {
			String temp = word.get(i);
			boolean ck = false;
			if(!temp.equals("")) {
				int size = temp.length();
				for(int j=0;j<size;j++) {
					if(!alphabet[temp.charAt(j)-97]) {
						ck = true;
						break;
					}
				}
			}
			if(!ck)
				count++;
		}
		result = Math.max(result, count);
		return;
	}
    	//'a', 'c', 'i', 'n', 't'가 배웠다고 초기화하는 함수
	static void alphabetInit() {
		alphabet[0] = alphabet[2] = alphabet[8] = alphabet[13] = alphabet[19] = true;
		return;
	}
}