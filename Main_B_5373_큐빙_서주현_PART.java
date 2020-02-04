import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_5373_큐빙_서주현 {

	static char plane=' ';
	static int dir;
	static char cube[][][] = new char[6][3][3];
	static int index=0;
	
	private static void setIndex() {
		
		switch(plane) {
		case 'U':index=0;break;
		case 'F':index=1;break;
		case 'L':index=2;break;
		case 'D':index=3;break;
		case 'B':index=4;break;
		case 'R':index=5;break;
		}
		
	}
	private static void initCube() {
		
		char c=' ';
		
		for (int i = 0; i < 6; i++) {
			switch(i) {
			case 0: c='w';break;
			case 1: c='r';break;
			case 2: c='g';break;
			case 3: c='y';break;
			case 4: c='o';break;
			case 5: c='b';break;
			}
			for (int j = 0; j < 3; j++) 
				for (int k = 0; k < 3; k++) 
					cube[i][j][k]=c;			
		}
		
	}
	

	private static void changeClock() {
		/*
		 * U F L D B R 
		 * 위 앞 왼 아 뒤 오 
		 * 0 1 2 3 4 5 
		 * w r g y o b
		 */
		/* arraycopy */ 
		char[][] cubetemp = new char[3][3];
		
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				cubetemp[i][j]= cube[index][i][j];
		
		
		/* 시계방향 */
		if(dir==1) {
		for(int i=0;i<3;i++)
			for(int j=2;j>=0;j--)
				cube[index][i][2-j]=cubetemp[j][i];
		}	
		/* 반시계방향*/
		else {
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				cube[index][i][j]=cubetemp[j][2-i];
		}	
		
	}

	private static void spinCube() {
		
		
		/* 선택된 면을 회전시킨다 */
		changeClock();
		
		/*                  ↙ B
		 * 			22 21 20
		 * 			12 11 10
		 * 		 L↙	02 01 00 ↙U       ↙R
		 * 20 10 00 00 01 02 02 12 22 
		 * 21 11 01 10 11 12 01 11 21 
		 * 22 12 02 20 21 22 00 10 20 
		 * 			00 01 02↙ F
		 * 			10 11 12
		 * 			20 21 22
		 * 			00 01 02 ↙D
		 * 			10 11 12
		 * 			20 21 22
		 * */

		/*
		 * U F L D B R 
		 * 위 앞 왼 아 뒤 오 
		 * 0 1 2 3 4 5 
		 * w r g y o b
		 */

	   /* 반시계 		시계
		* 0=1		3=2
		* 1=2		2=1
		* 2=3		1=0
		* 3=0		0=3 */
		
		char ch[] = new char[3];
		switch(plane) {

		case 'U':
			if(dir==1) {
			for(int i=2;i>=0;i--) ch[2-i]=cube[2][0][i];
			for(int i=2;i>=0;i--) cube[2][0][i]=cube[1][0][i];
			for(int i=2;i>=0;i--) cube[1][0][i]=cube[5][0][i];
			for(int i=2;i>=0;i--) cube[5][0][i]=cube[4][0][i];
			for(int i=2;i>=0;i--) cube[4][0][i]=ch[2-i];
			
			}
			else {
			for(int i=2;i>=0;i--) ch[2-i]=cube[4][0][i];
			for(int i=2;i>=0;i--) cube[4][0][i]=cube[5][0][i];		
			for(int i=2;i>=0;i--) cube[5][0][i]=cube[1][0][i];			
			for(int i=2;i>=0;i--) cube[1][0][i]=cube[2][0][i];
			for(int i=2;i>=0;i--) cube[2][0][i]=ch[2-i];
			}
			break;
		case 'F':
			if(dir==1) {
				
			for(int i=0;i<=2;i++) ch[i]=cube[2][2-i][2];
			for(int i=2;i>=0;i--) cube[2][i][2]=cube[3][0][i];
			for(int i=2;i>=0;i--) cube[3][0][i]=cube[5][2-i][0];
			for(int i=2;i>=0;i--) cube[5][2-i][0]=cube[0][2][2-i];
			for(int i=0;i<=2;i++) cube[0][2][i]=ch[i];
			}
			
			else {
			for(int i=0;i<=2;i++) ch[i]=cube[0][2][i];
			for(int i=2;i>=0;i--) cube[0][2][2-i]=cube[5][2-i][0];
			for(int i=2;i>=0;i--) cube[5][2-i][0]=cube[3][0][i];
			for(int i=2;i>=0;i--) cube[3][0][i]=cube[2][i][2];
			for(int i=0;i<=2;i++) cube[2][2-i][2]=ch[i];
			}
			break;

		case 'L':
			if(dir==1) {
				
			for(int i=0;i<=2;i++) ch[i]=cube[4][2-i][2];
			for(int i=2;i>=0;i--) cube[4][i][2]=cube[3][2-i][0];
			for(int i=2;i>=0;i--) cube[3][2-i][0]=cube[1][2-i][0];
			for(int i=2;i>=0;i--) cube[1][2-i][0]=cube[0][2-i][0];
			for(int i=0;i<=2;i++) cube[0][i][0]=ch[i];
			}
				
			else {
			for(int i=0;i<=2;i++) ch[i]=cube[0][i][0];
			for(int i=2;i>=0;i--) cube[0][2-i][0]=cube[1][2-i][0];
			for(int i=2;i>=0;i--) cube[1][2-i][0]=cube[3][2-i][0];
			for(int i=2;i>=0;i--) cube[3][2-i][0]=cube[4][i][2];
			for(int i=0;i<=2;i++) cube[4][2-i][2]=ch[i];
			}
			break;

			   /* 반시계 		시계
				* 0=1		3=2
				* 1=2		2=1
				* 2=3		1=0
				* 3=0		0=3 */
				//20 21 22 / 22 21 20 / 20 21 22 / 22 21 20
				//  F1 R5 B4 L2
		case 'D':
			if(dir==1) {
				
			for(int i=0;i<=2;i++) ch[i]=cube[2][2][2-i];
			for(int i=2;i>=0;i--) cube[2][2][i]=cube[4][2][2-i];
			for(int i=2;i>=0;i--) cube[4][2][2-i]=cube[5][2][i];
			for(int i=2;i>=0;i--) cube[5][2][i]=cube[1][2][2-i];
			for(int i=0;i<=2;i++) cube[1][2][i]=ch[i];
			}
					
			else {
				for(int i=0;i<=2;i++) ch[i]=cube[1][2][2-i];
				for(int i=2;i>=0;i--) cube[1][2][i]=cube[5][2][i];
				for(int i=2;i>=0;i--) cube[5][2][i]=cube[4][2][2-i];
				for(int i=2;i>=0;i--) cube[4][2][2-i]=cube[2][2][2-i];
				for(int i=0;i<=2;i++) cube[2][2][i]=ch[i];
				}
				break;
			
		case 'B':
			if(dir==1) {
				
				
			for(int i=0;i<=2;i++) ch[i]=cube[2][i][0];
			for(int i=2;i>=0;i--) cube[2][2-i][0]=cube[0][0][i];
			for(int i=2;i>=0;i--) cube[0][0][i]=cube[5][i][2];
			for(int i=2;i>=0;i--) cube[5][i][2]=cube[3][2][2-i];
			for(int i=0;i<=2;i++) cube[3][2][i]=ch[i];
			}
						
			else {
			for(int i=0;i<=2;i++) ch[i]=cube[3][2][i];
			for(int i=2;i>=0;i--) cube[3][2][2-i]=cube[5][i][2];
			for(int i=2;i>=0;i--) cube[5][i][2]=cube[0][0][i];
			for(int i=2;i>=0;i--) cube[0][0][i]=cube[2][2-i][0];
			for(int i=0;i<=2;i++) cube[2][i][0]=ch[i];
			}
			break;
	
		case 'R':
			if(dir==1) {
				
			for(int i=0;i<=2;i++) ch[i]=cube[1][2-i][2];
			for(int i=2;i>=0;i--) cube[1][i][2]=cube[3][2-i][2];
			for(int i=2;i>=0;i--) cube[3][2-i][2]=cube[4][2-i][0];
			for(int i=2;i>=0;i--) cube[4][2-i][0]=cube[0][i][2];
			for(int i=0;i<=2;i++) cube[0][2-i][2]=ch[i];
			}
							
			else {
			for(int i=0;i<=2;i++) ch[i]=cube[0][2-i][2];
			for(int i=2;i>=0;i--) cube[0][i][2]=cube[4][2-i][0];
			for(int i=2;i>=0;i--) cube[4][2-i][0]=cube[3][2-i][2];
			for(int i=2;i>=0;i--) cube[3][2-i][2]=cube[1][i][2];
			for(int i=0;i<=2;i++) cube[1][2-i][2]=ch[i];
			}
			break;
		}
	
	}

	private static void printCube() {
	
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++)
				System.out.print(cube[0][i][j]+" ");
			System.out.println();
		}
	
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());

		for (int t = 1; t <= test_case; t++) {

			int spin = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			initCube(); /* 큐브 초기화 */

			for (int i = 1; i <= spin; i++) {

				String get = st.nextToken();
				plane = get.charAt(0);
				char ch = get.charAt(1);
				
				dir=(ch=='+'?1:-1);
				setIndex();
				spinCube(); /* 큐브 회전 */
			}
	
			printCube(); /* 윗면 출력 */

		}

	}

}




