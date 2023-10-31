package ru.wjs.volodin.practicalTasks3.task5.importedproducts;

public interface Importable {
    default String printForImport() {
        if (!(getCountryOfOrigin().equalsIgnoreCase("Россия") || getCountryOfOrigin().equalsIgnoreCase("Russia"))) {
            return String.format("Страна производства: %s; Гарантия производителя: %s;\n", getCountryOfOrigin(),
                    printWarrantyInfo());
        }
        return "";
    }
    String getCountryOfOrigin();
    default String printWarrantyInfo(){
        return (isHasWarranty())? "Имеется гарантия":"Нет гарантии";
    }
    boolean isHasWarranty();
}
