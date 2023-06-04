package ua.en.kosse.oksana.hillel.hw13;

import java.io.File;
import java.util.*;


public class HomeWorkFileList {
    public static void main(String[] args) throws Exception {
        FileNavigator fileNavigator = new FileNavigator();
        List<String> pathAbsolute = new ArrayList<>();
        String filePath = "files";
        File dir = new File(filePath);

        //2. Реалізувати метод add у класі FileNavigator. Цей метод додає файл за вказаним шляхом.
        // Якщо шлях вже існує, новий файл необхідно додати до списку, вже пов'язаному з відповідним шляхом.
        // ВАЖЛИВО: Шлях – унікальне значення і не повинно повторюватися.
        if (dir.isDirectory()) {
            // получаем все вложенные объекты в каталоге
            for (File item : dir.listFiles()) {
                if (item.isDirectory()) {
                    System.out.println(item);
                    pathAbsolute.add(String.valueOf(item.getAbsoluteFile()));
                    fileNavigator.addNew(String.valueOf(item));
                } else {
                    throw new Exception("The directory does not exist");
                }
            }
        }

        //3. Реалізувати метод find у класі FileNavigator.
        // Метод повертає список файлів, пов'язаних з шляхом переданим як параметр.
        try {

            System.out.println("3. ");
            System.out.println("Find :" + pathAbsolute.get(1));
            System.out.println(fileNavigator.find(pathAbsolute.get(1)));
            System.out.println();
            System.out.println("Find :" + pathAbsolute.get(2));
            System.out.println(fileNavigator.find(pathAbsolute.get(2)));
        } catch (Exception e) {
            throw new IndexOutOfBoundsException("Out of bounds of the array!");

        }

        //4. Реалізувати метод filterBySize у класі FileNavigator. Метод повертає список файлів,
        // розмір (в байтах) яких не перевищує значення, передане як параметр.
        System.out.println("4. ");
        System.out.println("FilterBySize <= 2000:");
        System.out.println(fileNavigator.filterBySize(2000));
        System.out.println();
        System.out.println("FilterBySize <= 3000:");
        System.out.println(fileNavigator.filterBySize(3000));

        //5. Реалізувати метод remove у класі FileNavigator.
        // Метод видаляє шлях і пов'язані з ним файли, виходячи з значення шляху, переданого як параметр.
        System.out.println("5.");
        System.out.println("SortBySize:");
        System.out.println(fileNavigator.sortBySize());

        //6. * Реалізувати метод sortBySize у класі FileNavigator.
        // Метод сортує всі наявні файли за розміром (за зростанням), потім повертає список відсортованих файлів.
        try {
            System.out.println("6.");
            System.out.println("FileNavigator before delete:");
            System.out.println(fileNavigator);
            System.out.println();
            System.out.println("FileNavigator after delete:" + pathAbsolute.get(2));
            fileNavigator.remove(pathAbsolute.get(2));
            System.out.println(fileNavigator);
        } catch (Exception e) {
            throw new IndexOutOfBoundsException("Out of bounds of the array!");
        }

        // 7. ** Реалізувати перевірку консистентності у методі add у класі FileNavigator.
        // Не дозволяти додавати значення і повідомити про це в консолі, при спробі додати значення
        // FileData значення шляху якого не відповідає шляху-ключу, що веде до списку файлів.
        System.out.println("7.");
        System.out.println("Add file with invalid path: \"/path/file\"");
        fileNavigator.addNew("path/files");

    }
}
