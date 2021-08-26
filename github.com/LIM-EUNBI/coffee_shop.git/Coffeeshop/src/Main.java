
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Menu menu = new Menu();

		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		// m: 메뉴 관리
		// o: 주문 받기
		// s: 실적 보기
		// x: 프로그램 종료
		while(true) {
			System.out.println("작업을 선택하세요.(m:메뉴 관리, o:주문 받기, s:실적 보기, x:프로그램 종료");
			String sys = sc.nextLine();
			if(sys.equals("x")) break;
			switch(sys) {
				case "m":
					System.out.println("메뉴 작업을 선택하세요.(c:추가, r:목록보기, u:수정, d:삭제, q:종료)");
					sys = sc.nextLine();
					while(!sys.equals("q")) {
						switch(sys) {
							case "c":
								menu.insertMenu();
								break;
							case "r":
								menu.showMenu();
								break;
							case "u":
								menu.changeMenu();
								break;
							case "d":
								menu.deleteMenu();
								break;
						}
						System.out.println("메뉴 작업을 선택하세요.(c:추가, r:목록보기, u:수정, d:삭제, q:종료)");
						sys = sc.nextLine();
					}
					menu.save();
					break;
				case "o":
					System.out.println("주문 받기");
					break;
				case "s":
					System.out.println("실적 보기");
					break;
			}
		}
//		Scanner sc1 = new Scanner(System.in);
//		
//		menu.load();
//		System.out.println("메뉴명을 입력해주세요 → ");
//		String mName = sc.nextLine();
//		
//		while(!mName.equals("")) {
//			System.out.println("가격을 입력해주세요 → ");
//			int mPrice = sc1.nextInt();
//			menu.addName(mName);
//			menu.addPrice(mPrice);
//			System.out.println("메뉴명을 입력해주세요 → ");
//			mName = sc.nextLine();
//		}
//		
		//System.out.println("메뉴 목록");
		
		sc.close();
		sc1.close();

	}
}
