package entity;

import validate.InputMethod;
import validate.ProductValidator;

import java.util.Scanner;

public class Product implements IProduct {

    private int id;
    private String productName;
    private String title;
    private String description;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private boolean status;

    public Product(int id, String productName, String title, String description, float importPrice, float exportPrice, float interest, boolean status) {
        this.id = id;
        this.productName = productName;
        this.title = title;
        this.description = description;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        // Input ID
        this.id = InputMethod.inputInteger(scanner);

        // Input product name using validator
        this.productName = ProductValidator.inputProductName(scanner);

        // Input title
        this.title = InputMethod.inputString(scanner, "Nhập tiêu đề sản phẩm", InputMethod.ERROR_EMPTY_STRING);

        // Input description using validator
        this.description = ProductValidator.inputDescription(scanner);

        // Input import price
        while (true) {
            float input = InputMethod.inputFloat(scanner, "Nhập giá nhập (import price): ");
            if (input > 0) {
                this.importPrice = input;
                break;
            }
            System.err.println("Giá nhập phải là số dương.");
        }

        // Input export price
        while (true) {
            float input = InputMethod.inputFloat(scanner, "Nhập giá xuất (export price): ");
            if (input > this.importPrice) {
                this.exportPrice = input;
                break;
            }
            System.err.println("Giá xuất phải lớn hơn giá nhập.");
        }

        // Calculate interest
        this.interest = this.exportPrice - this.importPrice;

        // Input status
        this.status = ProductValidator.inputStatus(scanner);
    }

    @Override
    public void displayData() {
        System.out.println("-------------------");
        System.out.println("Mã sản phẩm: " + this.id);
        System.out.println("Tên sản phẩm: " + this.productName);
        System.out.println("Tiêu đề: " + this.title);
        System.out.println("Mô tả: " + this.description);
        System.out.println("Giá nhập: " + this.importPrice);
        System.out.println("Giá xuất: " + this.exportPrice);
        System.out.println("Lợi nhuận: " + this.interest);
        System.out.println("Trạng thái: " + (this.status ? "Đang hoạt động" : "Không hoạt động"));
    }
}
