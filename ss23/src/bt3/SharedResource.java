package bt3;

class SharedResource {
    // Phương thức synchronized để đảm bảo đồng bộ
    public synchronized void printAlphabet() {
        for (char c = 'A'; c <= 'Z'; c++) {
            System.out.print(c + " ");
        }
        System.out.println(); // Xuống dòng sau khi in xong bảng chữ cái
    }
}
