
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	private ArrayList<String> alName;
	private ArrayList<Integer> alPrice;
	Scanner sc = new Scanner(System.in);
	Scanner sc1 = new Scanner(System.in);
	
	Menu() { //초기화
		this.alName = new ArrayList<String>();
		this.alPrice = new ArrayList<Integer>();
		load();
	}
	
	void addName(String name) {
		alName.add(name);
	}
	void addPrice(int price) {
		alPrice.add(price);
	}
	void addPrice(String price) {
		alPrice.add(Integer.parseInt(price));
	}
	void showMenu() {
		//alName, alPrice 출력
		for(int i=0; i<alName.size(); i++) {
			System.out.println((i+1) + " " + alName.get(i)+ "\n   ▶ " + alPrice.get(i));
		}
	}
	void save() { //alName, alPrice를 파일(menu.txt)에 저장
		  String fileNm = "c:/temp/menu.txt";
		  try{
		  File file = new File(fileNm);
		  FileWriter fileWrite = new FileWriter(file, false);
		  for(int i=0; i<alName.size(); i++) {
			  fileWrite.write(alName.get(i)+","+alPrice.get(i)+"\n");
		  }
		  fileWrite.flush(); 
		  fileWrite.close();
		  } catch (Exception e){
		  e.printStackTrace(); 
		  }
	}
	void load() { //파일(menu.txt)을 읽어서 alName, alPrice에 저장
		File file=new File("c:/temp/menu.txt");
		if(file.exists()) {
			BufferedReader inFile = null;
			try {
				inFile = new BufferedReader(new FileReader(file));
			} catch (FileNotFoundException e) {	e.printStackTrace(); }
			
			String line;
			
			try {
				line = inFile.readLine();
				while(line!=null) {
					String[] part = line.split(",");
					addName(part[0]);
					addPrice(part[1]);					
					line=inFile.readLine();
				}
			} catch (IOException e) { e.printStackTrace(); }
		}
	}
	
	void changeMenu() {
		System.out.println("수정할 메뉴 번호");
		int n = sc1.nextInt();
		System.out.println("변경할 메뉴명");
		String name = sc.nextLine();
		System.out.println("변경할 금액");
		int price = sc1.nextInt();
		alName.set(n-1, name);
		alPrice.set(n-1, price);
	}
	
	void deleteMenu() {
		System.out.println("삭제할 메뉴 번호");
		int n = sc1.nextInt();
		alName.remove(n-1);
		alPrice.remove(n-1);
	}
	
	void insertMenu() {
		
		System.out.println("메뉴명을 입력해주세요 ");
		String mName = sc.nextLine();
		System.out.println("가격을 입력해주세요 ");
		int mPrice = sc1.nextInt();
		addName(mName);
		addPrice(mPrice);
	}
	
}
