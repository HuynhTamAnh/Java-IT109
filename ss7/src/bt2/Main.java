package bt2;
//Chuỗi ban đầu:
//Khởi tạo một chuỗi ban đầu là: "Hello, Java World!".
//Thực hiện các thao tác:
//Xóa các ký tự từ vị trí 5 đến 9 trong chuỗi.
//Thay thế đoạn "World" bằng "Universe".
//In kết quả:
//In chuỗi ban đầu.
//In chuỗi sau khi xóa.
//In chuỗi sau khi thay thế.
public class Main {
    public static void main(String[] args) {
        String initStr="Hello, Java World!";
        StringBuilder sb=new StringBuilder(initStr);

        //in chuoi ban dau
        System.out.println("chuoi ban dau: "+sb.toString());

        //xoa ki tu tu 5 den 9
        System.out.print("cac ki tu se bi xoa: \""+sb.substring(5,10)+"\"");
        sb.delete(5,10);
        System.out.print("chuoi sau khi xoa: "+sb.toString());

        //thay the world bang universe
        int world=sb.indexOf("World");
        if(world!=-1){
            sb.replace(world, world + "World".length(), "Universe");
            System.out.print("chuoi sau khi thay the: "+sb.toString());
        }else {
            System.out.println("Không tìm thấy chuỗi \"World\" để thay thế!");
            // Trong trường hợp "World" đã bị xóa, thêm "Universe" vào vị trí thích hợp
            sb.insert(sb.length(), " Universe");
            System.out.println("Đã thêm \"Universe\" vào cuối chuỗi: " + sb.toString());
        }

        // kq
        System.out.println("\nKết quả:");
        System.out.println("- Chuỗi ban đầu: " + initStr);
        System.out.println("- Chuỗi sau khi xóa các ký tự từ vị trí 5-9: " + initStr.substring(0, 5) + initStr.substring(10));
        System.out.println("- Chuỗi sau khi thay thế: " + sb.toString());
    }
}
