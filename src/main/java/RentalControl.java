import java.util.List;
import java.util.Scanner;

import dao.RentalDAO;
import model.Rental;
import mybaits.MyBatisConnectionFactory;

public class RentalControl {
	Scanner sc = new Scanner(System.in);
	RentalDAO rentalDAO = new RentalDAO(MyBatisConnectionFactory.getSqlSessionFactory());
	Rental rental = new Rental();
	List<Rental> rentalList = null;
	
	public void selectRental() {
		System.out.println("1.��ü �뿩 ��ȸ 2.���� �뿩 ��ȸ");
		int sel = Integer.parseInt(sc.nextLine());
		if(sel==1) {
			rentalList = rentalDAO.selectAllR();
			for(Rental obj : rentalList) {
				System.out.println("ȸ�� �̸� : "+obj.getMname());
				System.out.println("�뿩 å�̸� : "+obj.getBname());
				System.out.println("�뿩 ��¥ : "+obj.getRdate());
			}
		}else if(sel==2) {
			
		}
	}

}
