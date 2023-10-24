package ru.wjs.volodin.practicalTasks3.task5;

import ru.wjs.volodin.practicalTasks3.task5.baseclasses.DefaultAndImportProduct;

public class Catalog {
    public static DefaultAndImportProduct[] productToCatalog(DefaultAndImportProduct... products) {
        DefaultAndImportProduct[] catalog = new DefaultAndImportProduct[DefaultAndImportProduct.getCount()];
        for (int i = 0; i < catalog.length; i++) {
            catalog[i] = products[i];
        }
        return catalog;
    }

    public static void printCatalog(DefaultAndImportProduct[] catalog) {
        for(DefaultAndImportProduct product: catalog){
            System.out.println(product);
            System.out.println();
        }
    }

}

