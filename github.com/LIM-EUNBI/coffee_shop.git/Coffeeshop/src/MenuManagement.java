import java.util.Scanner;

public class MenuManagement{

	public void MenuInsert(){
		Menu menu = new Menu();
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		
		System.out.println("메뉴명을 입력해주세요 → ");
		String mName = sc.nextLine();
		while(!mName.equals("")) {
			System.out.println("가격을 입력해주세요 → ");
			int mPrice = sc1.nextInt();
			menu.addName(mName);
			menu.addPrice(mPrice);
			System.out.println("메뉴명을 입력해주세요 → ");
			mName = sc.nextLine();
		}
	}
}
