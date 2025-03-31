package validate;

import entity.Product;
import business.ProductBusiness;

import java.util.Scanner;

public class ProductValidator {
    public static String inputProductName(Scanner sc) {
        while (true) {
            String productName = InputMethod.inputString(sc, "Nhập tên sản phẩm", InputMethod.ERROR_EMPTY_STRING);

            //validate độ dài chuỗi
            ValidateString validator = new ValidateString(6, 50, null);
            if (!validator.isValid(productName)) {
                System.err.println(validator.getErrorMessage());
                continue;
            }

            // Check for existing name
            if (!existsByName(productName)) {
                return productName;
            }

            System.err.println("Tên sản phẩm đã tồn tại. Vui lòng nhập tên khác.");
        }
    }

    public static String inputDescription(Scanner sc) {
        while (true) {
            String description = InputMethod.inputString(sc, "Nhập mô tả sản phẩm", InputMethod.ERROR_EMPTY_STRING);
            ValidateString validator = new ValidateString(0, 255, null);
            if (validator.isValid(description)) {
                return description;
            }
            System.err.println(validator.getErrorMessage());
        }
    }

    public static boolean inputStatus(Scanner sc) {
        return InputMethod.inputBoolean(sc,
                "Nhập trạng thái của sản phẩm (true - Đang hoạt động / false - Không hoạt động)",
                "Lựa chọn không hợp lệ, vui lòng nhập lại");
    }

    private static boolean existsByName(String name) {
        if (ProductBusiness.products == null) {
            return false;
        }

        for (Product product : ProductBusiness.products) {
            if (product != null && product.getProductName() != null &&
                    product.getProductName().trim().equalsIgnoreCase(name.trim())) {
                return true;
            }
        }
        return false;
    }
}