package BaseballGame;

import java.util.Random;
import java.util.Scanner;

public class BaseballGame {

	public static void main(String[] args) {
		System.out.println("ピッチャーかバッターを選択してください");
		System.out.println("1:ピッチャー　2:バッター");
		Scanner sideChoice = new Scanner(System.in);
		int side = sideChoice.nextInt();
		
		
		switch(side) {
			/*ピッチャー編*/
			case 1:
				System.out.println("あなたはピッチャーです");
				
				
				System.out.println("\r\n～～～ルール～～～");
				System.out.println("ストライクを3回取ると勝ち");
				System.out.println("ヒットを打たれる又はボールを4回取ると負け");
				System.out.println("～～～～～～～～～\r\n");
				
				
				System.out.println("ストライクゾーンは１～９で１０は"
						+ "ボール球を投げます");
				System.out.println("バッターは１～９でスイング、１０は"
						+ "見逃します");
				System.out.println(" --------");
				System.out.println("｜１２３｜　 ------");
				System.out.println("｜４５６｜　｜１０｜");
				System.out.println("｜７８９｜　 ------");
				System.out.println(" --------");
				
				int stlikeCount = 0;
				int ballCount = 0;
				int i = 0;
				
				/*投球練習*/
				System.out.println("\r\nまずは投球練習！！");
				System.out.println("コントロールが悪いので4割でボール球になってしまう！");
				
				for (int l=0; l<3; l++) {
					System.out.println("\r\n投げる箇所（数字）を入力してください");
					System.out.println("入力後Enterキーで投げます");
					Random randomPractice = new Random();
					int controlPractice = randomPractice.nextInt(10);
					Scanner zonePractice = new Scanner(System.in);
					int pitchingZonePractice = zonePractice.nextInt();
					String comment = "コントロールは成功";
					if(pitchingZonePractice <= 9) {
						if (controlPractice <= 3) {
							pitchingZonePractice = 10;
							comment = "コントロールは失敗";
							
						} 
					}
					System.out.println(comment);
					System.out.println((l+1) + "回目の投球は" + pitchingZonePractice);
				}
				
				
				/*ゲームスタート*/
				System.out.println("\r\n \r\nそれでは");
				System.out.println("本番スタート！！");
				
				while (i<6) {	
					System.out.println(" --------");
					System.out.println("｜１２３｜　 ------");
					System.out.println("｜４５６｜　｜１０｜");
					System.out.println("｜７８９｜　 ------");
					System.out.println(" --------");
					System.out.println("\r\n投げる箇所（数字）を入力してください");
					System.out.println("入力後Enterキーで投げます");
					
					/*投げるコースの指定*/
					Scanner zone1 = new Scanner(System.in);
					int pitchingZone = zone1.nextInt();
					
					/*コントロールの決定*/
					Random random = new Random();
					int control = random.nextInt(10);
					if(pitchingZone <= 9) {
						if (control <= 3) {
							pitchingZone = 10;
						} 
					}
					
					/*CPUのバッティングゾーンの指定*/
					int batingZone = random.nextInt(10)+1;
					/*コントロールが悪ければ見逃す確率高くなる*/
					if(control <= 3) {
						Random randomThrough = new Random();
						int batingControl = randomThrough.nextInt(10);
						if (batingControl <= 6) {
							batingZone = 10;
						}
					} 
					
					consoleStop();
					
					/*ヒットを打たれた場合*/
					if (batingZone  == pitchingZone && batingZone <= 9){
						System.out.println("ヒット!!");
						System.out.println("あなたの負け...");
						break;
					}
					/*ボールの場合*/
					else if(batingZone == pitchingZone && batingZone == 10) {
							System.out.println("ボール!");
							System.out.println("バッターは振らなかった!");
							consoleStop();
							
							/*ボールカウントが２以下の場合*/
							if(ballCount <= 2) {
								ballCount ++;
								System.out.println("\r\nカウント");
								System.out.println("ボール:"+ ballCount);
								System.out.println("ストライク:"+ stlikeCount);
								consoleStop();
							}
							 /*フォアボールとなる場合*/
							 else {
								System.out.println("フォアボール!!");
								System.out.println("あなたの負け...");
								break;
							}
					}
					/*ストライク（見逃し）の場合*/
					else if (batingZone != pitchingZone && batingZone == 10){
						System.out.println("ストライク!");
						System.out.println("バッターは見逃した");
						consoleStop();
						
						/*ストライクカウントが２以下の場合*/
						if(stlikeCount <= 1) {
							stlikeCount ++;
							System.out.println("\r\nカウント");
							System.out.println("ボール:"+ ballCount);
							System.out.println("ストライク:"+ stlikeCount);
							consoleStop();
						}
						 /*アウトとなる場合*/
						 else {
							System.out.println("アウト!!");
							System.out.println("あなたの勝ち！！！");
							break;
						}
					}
					/*ストライク（空振り）の場合*/
					else {
						System.out.println("ストライク!");
						System.out.println("バッターは"+ batingZone +"で振った!");
						consoleStop();
						
						/*ストライクカウントが２以下の場合*/
						if(stlikeCount <= 1) {
							stlikeCount ++;
							System.out.println("\r\nカウント");
							System.out.println("ボール:"+ ballCount);
							System.out.println("ストライク:"+ stlikeCount);
							consoleStop();
						}
						/*アウトとなる場合*/
						 else {
							System.out.println("アウト!!");
							System.out.println("あなたの勝ち！！！");
							break;
						}
					}
				}
			break;
		
			/*バッター編*/
			case 2: 
				System.out.println("あなたはバッターです");
				
				System.out.println("\r\n～～～ルール～～～");
				System.out.println("ヒットを打つ又はボールを4回取ると勝ち");
				System.out.println("ストライクを3回取られると負け");
				System.out.println("～～～～～～～～～\r\n");
				
				
				System.out.println("ストライクゾーンは１～９で１０は"
						+ "ボール球を投げます");
				System.out.println("バッターは１～９でスイング、１０は"
						+ "見逃します");
				System.out.println(" --------");
				System.out.println("｜１２３｜　 ------");
				System.out.println("｜４５６｜　｜１０｜");
				System.out.println("｜７８９｜　 ------");
				System.out.println(" --------");
				
				int stlikeCount2 = 0;
				int ballCount2 = 0;
				int j = 0;
				
				/*スイング練習*/
				System.out.println("\r\nまずはスイング練習！！");
				
				for (int l=0; l<3; l++) {
					System.out.println("\r\nスイングの箇所（数字）を入力してください");
					System.out.println("入力後Enterキーで振ります");
					Scanner zonePractice = new Scanner(System.in);
					int batingZonePractice = zonePractice.nextInt();
					if(batingZonePractice <=9) {
						System.out.println(batingZonePractice+"でスイングした");
					}
					if(batingZonePractice == 10) {
						System.out.println("振らなかった");
					}
					
				}
				
				
				/*ゲームスタート*/
				System.out.println("\r\n \r\nそれでは");
				System.out.println("本番スタート！！");
				System.out.println("ピッチャーはコントロールが悪いので4割でボール球になってしまう！");
				
				while (j<6) {	
					System.out.println(" \r\n --------");
					System.out.println("｜１２３｜　 ------");
					System.out.println("｜４５６｜　｜１０｜");
					System.out.println("｜７８９｜　 ------");
					System.out.println(" --------");
					System.out.println("\r\nスイングの箇所（数字）を入力してください");
					System.out.println("入力後Enterキーで振ります");
					
					/*バッティングゾーンの指定*/
					Scanner zone2 = new Scanner(System.in);
					int batingZone = zone2.nextInt();
					
					/*CPUの投げるコースの指定*/
					Random zone1 = new Random();
					int pitchingZone = zone1.nextInt(10)+1;
					
					/*CPUのコントロールの決定*/
					Random random1 = new Random();
					int control = random1.nextInt(10);
					if(pitchingZone <= 9) {
						if (control <= 3) {
							pitchingZone = 10;
						} 
					}
					
					consoleStop();
					
					/*ヒットを打った場合*/
					if (batingZone  == pitchingZone && batingZone <= 9){
						System.out.println("ヒット!!");
						System.out.println("あなたの勝ち！！！");
						break;
					}
					/*ボールの場合*/
					else if(batingZone == pitchingZone && batingZone == 10) {
							System.out.println("ボール!");
							System.out.println("ピッチャーは"+ pitchingZone +"に投げた!");
							System.out.println("バッターは振らなかった!");
							consoleStop();
							
							/*ボールカウントが２以下の場合*/
							if(ballCount2 <= 2) {
								ballCount2 ++;
								System.out.println("\r\nカウント");
								System.out.println("ボール:"+ ballCount2);
								System.out.println("ストライク:"+ stlikeCount2);
								consoleStop();
							}
							 /*フォアボールとなる場合*/
							 else {
								System.out.println("フォアボール!!");
								System.out.println("あなたの勝ち！！！");
								break;
							}
					}
					/*ストライク（見逃し）の場合*/
					else if (batingZone != pitchingZone && batingZone == 10){
						System.out.println("ストライク!");
						System.out.println("ピッチャーは"+ pitchingZone +"に投げた!");
						System.out.println("バッターは見逃した");
						consoleStop();
						
						/*ストライクカウントが２以下の場合*/
						if(stlikeCount2 <= 1) {
							stlikeCount2 ++;
							System.out.println("\r\nカウント");
							System.out.println("ボール:"+ ballCount2);
							System.out.println("ストライク:"+ stlikeCount2);
							consoleStop();
						}
						 /*アウトとなる場合*/
						 else {
							System.out.println("ストライク!");
							System.out.println("アウト!!");
							System.out.println("あなたの負け...");
							break;
						}
					}
					/*ストライク（空振り）の場合*/
					else {
						System.out.println("ストライク!");
						System.out.println("ピッチャーは"+ pitchingZone +"に投げた!");
						consoleStop();
						
						/*ストライクカウントが２以下の場合*/
						if(stlikeCount2 <= 1) {
							stlikeCount2 ++;
							System.out.println("\r\nカウント");
							System.out.println("ボール:"+ ballCount2);
							System.out.println("ストライク:"+ stlikeCount2);
							consoleStop();
						}
						/*アウトとなる場合*/
						 else {
							System.out.println("ストライク!");
							System.out.println("アウト!!");
							System.out.println("あなたの負け...");
							break;
						}
					}
				}
			break;
			
			/*入力値の異常*/
			default:
			System.out.println("1か2を入力してね");
			break;
		}
	}

	static void consoleStop() {
		try {
			 Thread.sleep(1000); // 秒(1000ミリ秒)間だけ処理を止める
			} catch (InterruptedException e) {
			}
	}

}
