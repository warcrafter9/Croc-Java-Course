package ru.wjs.volodin.practicalTasks3.task5;


import ru.wjs.volodin.practicalTasks3.task5.baseclasses.Product;

public class Catalog {
    public static Product[] productToCatalog(Product... products) {
        return products;
    }

    public static void printCatalog(Product[] catalog) {
        for(Product product: catalog){
            System.out.println(product);
            System.out.println();
        }
    }

}

