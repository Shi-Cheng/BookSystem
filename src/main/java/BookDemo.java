import java.util.Scanner;


public class BookDemo {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        String[] bookList = { "C语言", "数据结构", "汇编语言", "高数", "大学语文", "毛概" };
        String book;
        while (true){
            System.out.println("\"输入命令：1-按照名称查找图书；2-按照序号查找图书\"");
            int num = inputCommand();
            try {
                switch (num){
                    case 1://按照书名查找图书
                        book = getBookName(bookList);
                        System.out.println("书名为"+book+"存放在图书系统中");
                        break;
                    case 2://按照序号查找图书
                        String bookName = getBookNum(bookList);
                        System.out.println("该序号图书为"+bookName);
                        break;
                    case -1://返回值为-1，说明输入有误
                        System.out.println("命令输入错误！请根据提示输入数字命令！");
                        continue;
                    default://其他值的命令均认为是错误命令
                        System.out.println("命令输入错误！");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;

            }
        }
    }

    private static int inputCommand() {
        int command;
        try {
            command = scanner.nextInt();
            return command;
        } catch (Exception e) {
            scanner = new Scanner(System.in);
            return -1;
        }

    }
    public static String getBookNum(String[] bookList) throws Exception{
        System.out.println("输入你要查询的序号：");
        while (true){
            try {
                int bookIndex = inputCommand();
                if (bookIndex == -1){
                    System.out.println("命令输入错误！请根据提示输入数字命令！");
                    continue;
                }
                String bookName = bookList[bookIndex];
                return bookName;
            } catch (ArrayIndexOutOfBoundsException e) {
                Exception excInit = new Exception("图书不存在");
                excInit.initCause(e);
                throw excInit;

            }
        }
    }

    public static String getBookName(String[] bookList) throws Exception{
        System.out.println("输入图书名称：");
        String bookName = scanner.next();
        for (int i = 0; i < bookList.length; i++) {
            if(bookName.equals(bookList[i])){
                return bookList[i];
            }
        }
        throw new Exception("图书没有查到");
    }

}
