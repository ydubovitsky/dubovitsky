package ru.job4j.loop;

public class Board {
	
	// Метод main для проверки кода.
	
	//public static void main(String[] args) {
	//	Board board = new Board();
	//	board.paint(7,5);
	//}
	
	/*
	* Метод должен рисовать шахматную доску из символов x и пробелов.
	*/
	public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for ( int j = 0; j < width; j++) {
                // условие проверки, что писать пробел или X
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            // добавляем перевод на новую строку.
            screen.append(ln);
        }
		// Визуализируем доску.
		//System.out.println(screen.toString());
        return screen.toString();
	}
}