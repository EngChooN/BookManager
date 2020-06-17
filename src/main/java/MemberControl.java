import java.util.List;
import java.util.Scanner;

import dao.MemberDAO;
import model.Member;
import mybaits.MyBatisConnectionFactory;

public class MemberControl {
	Scanner sc = new Scanner(System.in);
	MemberDAO memberDAO = new MemberDAO(MyBatisConnectionFactory.getSqlSessionFactory());
	
	public void selectAMember() {
		List<Member> memberList = null;
		memberList = memberDAO.selectAllMember();
		for(Member obj : memberList) {
			System.out.println();
			System.out.println("ȸ�� id : "+obj.getMid());
			System.out.println("ȸ�� password : "+obj.getMpass());
			System.out.println("ȸ�� name : "+obj.getMname());
			System.out.println("etc : "+obj.getEtc());
		}
		
	}

	public void selectNMember() {
		Member member = new Member();
		System.out.print("ȸ�� name : ");
		String mname = sc.nextLine();
		try {
			member = memberDAO.selectNsearchMember(mname);
			System.out.println("ȸ�� id : "+member.getMid());
			System.out.println("ȸ�� password : "+member.getMpass());
			System.out.println("ȸ�� name : "+member.getMname());
			System.out.println("etc : "+member.getEtc());
			System.out.println(member.getMid()+"��!! ȸ�������� ���ϵ帳�ϴ�!!");
		}catch(NullPointerException e) {
			System.out.println("�������� �ʴ� ȸ���Դϴ�.");
		}
		
	}
	
	public void insertMember() {
		Member member = new Member();
		System.out.println("ȸ�� id : ");
		String mid = sc.nextLine();
		System.out.println("ȸ�� password : ");
		String mpass = sc.nextLine();
		System.out.println("ȸ�� name : ");
		String mname = sc.nextLine();
		System.out.println("etc : ");
		String etc = sc.nextLine();
		
		member.setMid(mid);
		member.setMpass(mpass);
		member.setMname(mname);
		member.setEtc(etc);
		
		memberDAO.insertMember(member);
	}
	
	public void deleteMember(String mid) {
		try {
			String idr = memberDAO.searchmid(mid);
			if(idr != null && mid.equals(idr)) {
				System.out.print("Ż���� ��й�ȣ : ");
				String pass = sc.nextLine();
				String passr = memberDAO.searchpass(idr);
				if(passr.equals(pass)) {
					memberDAO.delete(idr);
					System.out.println("Ż��Ǿ����ϴ�.");
				}else {
					System.out.println("�н����尡 ��ġ���� �ʽ��ϴ�.");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateMember(String mid) {
		try {
			
			String idr = memberDAO.searchmid(mid);
			if (idr != null && idr.equals(mid)) {
				Member member = new Member();
				System.out.println(idr + "å <����>");

				System.out.print("������ password : ");
				String mpass = sc.nextLine();
				System.out.print("������ name : ");
				String mname = sc.nextLine();
				System.out.print("������ etc : ");
				String etc = sc.nextLine();
				
				member.setMid(idr);
				member.setMpass(mpass);
				member.setMname(mname);
				member.setEtc(etc);
				
				memberDAO.update(member);
				System.out.println("������ �Ϸ�Ǿ����ϴ�.");
			}else {
				System.out.println("ȸ���� �������� �ʽ��ϴ�.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
