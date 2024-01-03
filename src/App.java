import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
	private List<WiseSaying> wiseSayings = new ArrayList<>();

	public App() {
	}

	public void run() {
		System.out.println("== 명언 앱 실행 ==");
		Scanner sc = new Scanner(System.in);
		int lastWiseSayingId = 0;
		while (true) {
			System.out.print("명령어 ) ");
			String cmd = sc.nextLine().trim();

			if (cmd.equals("등록")) {
				int id = lastWiseSayingId + 1;
				String regDate = Util.getDateTime();
				System.out.print("명언 : ");
				String content = sc.nextLine().trim();
				System.out.print("작가 : ");
				String author = sc.nextLine().trim();
				WiseSaying wiseSaying = new WiseSaying(id, regDate, content, author);
				wiseSayings.add(wiseSaying);
				System.out.printf("%d번 명언이 등록되었습니다.\n", id);
				lastWiseSayingId++;
			} else if (cmd.equals("목록")) {
				System.out.println("번호  /  작가  /  명언");
				System.out.println("============================");
				if (wiseSayings.size() == 0) {
					continue;
				}
				for (int i = wiseSayings.size() - 1; i >= 0; i--) {
					WiseSaying wiseSaying = wiseSayings.get(i);
					System.out.printf("%d  /  %s  /  %s\n", wiseSaying.getId(), wiseSaying.getAuthor(),
							wiseSaying.getContent());
				}
			} else if (cmd.startsWith("상세보기")) {

				String[] cmdBits = cmd.split("\\?");

				if (cmdBits.length == 1) {
					System.out.println("명령어 똑바로 입력해라.");
					continue;
				}

				String[] cmdDiv = cmdBits[1].split("=", 2);

				try {
					int id = Integer.parseInt(cmdDiv[1]);
					boolean iswiseSaying = false;
					for (int i = 0; i < wiseSayings.size(); i++) {
						WiseSaying wiseSaying = wiseSayings.get(i);
						if (wiseSaying.getId() == id) {
							iswiseSaying = true;
							System.out.println("번호 : " + wiseSaying);
							System.out.println("날짜 : ");
							System.out.println("작가 : ");
							System.out.println("내용 : ");
							break;
						}
					}
					if (iswiseSaying == false) {
						System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
					}

				} catch (Exception e) {
					System.out.println("정수로 똑바로 입력해.");
					continue;
				}

			} else if (cmd.startsWith("삭제")) {

				String[] cmdBits = cmd.split("\\?");

				if (cmdBits.length == 1) {
					System.out.println("명령어 똑바로 입력해라.");
					continue;
				}

				String[] cmdDiv = cmdBits[1].split("=", 2);

				try {
					int id = Integer.parseInt(cmdDiv[1]);
					boolean iswiseSaying = false;
					for (int i = 0; i < wiseSayings.size(); i++) {
						WiseSaying wiseSaying = wiseSayings.get(i);
						if (wiseSaying.getId() == id) {
							iswiseSaying = true;
							wiseSayings.remove(id);
							System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
							break;
						}
					}
					if (iswiseSaying == false) {
						System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
					}

				} catch (Exception e) {
					System.out.println("정수로 똑바로 입력해.");
					continue;
				}

			} else if (cmd.startsWith("수정")) {
				String[] cmdBits = cmd.split("\\?");

				if (cmdBits.length == 1) {
					System.out.println("명령어 똑바로 입력해라.");
					continue;
				}

				String[] cmdDiv = cmdBits[1].split("=", 2);

				try {
					int id = Integer.parseInt(cmdDiv[1]);
					boolean iswiseSaying = false;
					for (int i = 0; i < wiseSayings.size(); i++) {
						WiseSaying wiseSaying = wiseSayings.get(i);
						if (wiseSaying.getId() == id) {
							iswiseSaying = true;
							System.out.println("명언(기존) : " + wiseSaying.getContent());
							System.out.println("작가(기존) : " + wiseSaying.getAuthor());

							System.out.print("명언 : ");
							String newContent = sc.nextLine().trim();
							System.out.print("작가 : ");
							String newAuthor = sc.nextLine().trim();

							wiseSaying.setContent(newContent);
							wiseSaying.setAuthor(newAuthor);
							System.out.printf("%d번 명언이 수정되었습니다.\n", id);
							break;
						}
					}
					if (iswiseSaying == false) {
						System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
					}
				} catch (Exception e) {
					System.out.println("정수로 똑바로 입력해.");
					continue;
				}

			} else {
				System.out.println("존재하지 않는 명령어 입니다.");
			}

		}
	}
}
