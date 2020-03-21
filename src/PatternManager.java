//import java.util.ArrayList;
//import java.util.Random;
//
//public class PatternManager {
//	int green = 0;
//	int red = 1;
//	int yellow = 2;
//	int blue = 3;
//	Random num = new Random(4);
//	ArrayList<Integer> Computer = new ArrayList<Integer>();
//	ArrayList<Integer> User = new ArrayList<Integer>();
//	int compPick;
//	int userPick;
//	Simon simon;
//
//	PatternManager(Simon simon) {
//		this.simon = simon;
//	}
//
////	public void makePattern() {
////		System.out.println("makePattern has been called");
////		compPick = num.nextInt(4);
////		Computer.add(compPick);
////		for (int i = 0; i < Computer.size(); i++) {
////			if (Computer.get(i) == 0) {
////				simon.flash = 0;
////				System.out.println(compPick);
////				try {
////					Thread.currentThread().sleep(1000);
////				} catch (InterruptedException e) {
////					e.printStackTrace();
////				}
////			}
////		}	//else if (Computer.get(i) == 1) {
////				simon.flash = 1;
////				System.out.println(compPick);
////				try {
////					Thread.currentThread().sleep(1000);
////				} catch (InterruptedException e) {
////					e.printStackTrace();
////				}
////			} else if (Computer.get(i) == 2) {
////				simon.flash = 2;
////				System.out.println(compPick);
////				try {
////					Thread.currentThread().sleep(1000);
////				} catch (InterruptedException e) {
////					e.printStackTrace();
////				}
////			} else if (Computer.get(i) == 3) {
////				simon.flash = 3;
////				System.out.println(compPick);
////				try {
////					Thread.currentThread().sleep(1000);
////				} catch (InterruptedException e) {
////					e.printStackTrace();
////				}
////			}
////		}
////	}
////
//}