package org.example;

import static org.example.controller.WiseSayingController.createBuildFile;
import static org.example.controller.WiseSayingController.getListByKeyword;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.example.controller.WiseSayingController;

public class Main {

    public static void main(String[] args) throws IOException {
        App app = new App();
        app.run();
    }

    public static class App {
        private final BufferedReader br;

        public App() {
            this(new BufferedReader(new InputStreamReader(System.in)));
        }

        public App(BufferedReader br) {
            this.br = br;
        }

        public void run() throws IOException {
            System.out.println("== 명언 앱 ==");
            String cmd;

            while (true) {
                System.out.print("명령) ");
                cmd = br.readLine();

                if (cmd.equals("종료")) {
                    System.out.println("앱이 종료 되었습니다.");
                    break;
                } else if (cmd.equals("등록")) {
                    WiseSayingController.createWiseSaying(br);
                } else if (cmd.equals("목록")) {
                    WiseSayingController.getAllWiseSaying();
                } else if (cmd.startsWith("목록?keywordType")) {
                    getListByKeyword(cmd);
                } else if (cmd.startsWith("삭제")) {
                    WiseSayingController.deleteWiseSaying(cmd);
                } else if (cmd.startsWith("수정")) {
                    WiseSayingController.updateWiseSaying(cmd, br);
                } else if (cmd.equals("빌드")) {
                    createBuildFile();
                } else {
                    System.out.println("올바르지 않은 명령어 입니다.");
                }
            }

        }
    }
}